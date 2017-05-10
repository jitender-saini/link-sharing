package com.ttn.linksharing

import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.User
import com.ttn.linkSharing.UserService
import com.ttn.linkSharing.co.UserCO

class UserController {

    UserService userService
    def index() {
        render view: 'index', model: [subscribedTopic: User.getSubscribedTopic(session.user)]
    }

    def register() {
        log.info "controller"
        UserCO userCO = new UserCO()
        bindData(userCO, params, [exclude: ['isAdmin,isActive']])
        boolean result = userService.registration(userCO)
        if (result) {
//            flash.success="User Registration Success"
            log.info "User Registration Success"
            render "register success"
//            forward(controller: "login", action: "index")

        } else {
//            flash.error="User Registration Failed"
            log.info "User Registration failed"
            render "register fail"
//            forward(controller: "login", action: "index")
        }
//        bindData(user, params, [exclude: ['isAdmin,isActive']])
    }

    def sendInvitation() {
        Topic topic = Topic.get(params.topicId)
        def list = ['user': session.user.fullName, 'topic': topic.name]
        println topic.name
        sendMail {
            to params.email
            subject "Subscribe ${topic.name}"
//            body "hello"
            body(view: "/email/mail", model: [data: list])
        }
        render "email sent ${topic.name}"
    }
}
