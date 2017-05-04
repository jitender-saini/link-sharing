package com.ttn.linksharing

import com.ttn.linkSharing.User

class LoginController {

    def index() {
        if (session["user"])
            forward(controller: "user", action: "index")
        else
            render "Failure"
    }

    def loginHandler(String userName, String password) {
        User user = User.findByUserNameAndPassword(userName, password)
        if (user != null) {
            if (user.isActive) {
                session["user"] = user
                redirect(controller: "login", action: "index")
            } else
                render flash.error = "Your account is not active"
        }
        else if(user == null){
            render "User not found"
            flash.error = "User not found"
        }
    }

    def logout() {
        session.invalidate()
        render "Logout success"
        forward(controller: "login", action: "index")
    }

    def register(){
        User user = new User(userName: params.userName, firstName: params.firstName, lastName: params.lastName,
                password: params.password, email: params.email,confirmPassword: params.confirmPassword, isActive: true, isAdmin: false)
        user.save(flush:true)
        if(user.hasErrors())
            render flash.error = "User registration Failed"
        else render flash.success = "User Registration success"
    }

    boolean before() {
        if(!(session['user'])){
            redirect(controller:"login",action:"index")
            false
        }
        else true
    }
}
