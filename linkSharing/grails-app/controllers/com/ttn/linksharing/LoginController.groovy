package com.ttn.linksharing

import com.ttn.linkSharing.User

class LoginController {

    def mailService

    def index() {
        if (session.user)
            forward(controller: "user", action: "index")
        else {
            flash.error = "User not found"
            render view: '/notFound'
        }
    }

    def loginHandler(String userName, String password) {
        User user = User.findByUserNameAndPassword(userName, password)
        if (user) {
            if (user.isActive) {
                session.user = user
                redirect(controller: "login", action: "index")
            } else
                render flash.error = "Your account is not active"
        } else if (user) {
            render "User not found"
            flash.error = "User not found"
        }
    }

    def logout() {
        session.invalidate()
        render "Logout success"
        forward(controller: "login", action: "index")
    }

    def register() {
        User user = new User()//(userName: params.userName, firstName: params.firstName, lastName: params.lastName,
//                password: params.password, email: params.email, confirmPassword: params.confirmPassword, isActive: true, isAdmin: false)
        bindData(user, params, [exclude: ['isAdmin,isActive']])
        user.save(flush: true)
        if (user.hasErrors())
            render flash.error = "User registration Failed"
        else render flash.success = "User Registration success"
    }

    def emails = {
        mailService.sendMail {
            to "jitender.saini@tothenew.com"
            subject "Grails plugin directory"
            html view: "/email/mail"
        }
        render "email sent"
    }

//    boolean before() {
//        if (!session.user) {
//            redirect(controller: "login", action: "index")
//            false
//        } else true
//    }
}
