package com.ttn.linksharing

import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.User

class LoginController {

    def index() {
        User user = session.user
        if (user)
            forward(controller: "user", action: "index")
        else {
            render view: 'index', model: [topPost: Topic.getTopPost(), recentPost: Resource.getRecentPost()]
        }
    }

    def loginHandler(String userName, String password) {
        User user = User.createCriteria().get {
            projections {
                or {
                    eq('userName', userName)
                    eq('email', userName)
                }
                eq('password', password)
            }
        }
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
        forward(controller: "login", action: "index")
    }

    def emails = {
        sendMail {
            to "jitender.saini@tothenew.com"
            subject "Grails plugin directory"
            body "hello"
//            html view: "/email/mail"
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
