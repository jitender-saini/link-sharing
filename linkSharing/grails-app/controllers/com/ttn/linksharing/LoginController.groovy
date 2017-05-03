package com.ttn.linksharing

import com.ttn.linkSharing.User

class LoginController {

    def index() {
        if (session.user)
            forward(controller: "user", action: "index")
        else
            render "Failure"
    }

    def loginHandler(String userName, String password) {
        User user = User.findByUserNameAndPassword(userName, password)
        if (user != null) {
            if (user.isActive) {
                session.user = user;
                redirect(controller: "login", action: "index")
            } else
                render flash.error = "Your account is not active"
        }
        else if(user == null){
            render flash.error = "User not found"
        }
    }

    def logout() {
        session.invalidate()
        forward(controller: "login", action: "index")
    }

    boolean before() {
        if(!(session['user'])){
            redirect(controller:"login",action:"index")
            false
        }
        else true
    }

}
