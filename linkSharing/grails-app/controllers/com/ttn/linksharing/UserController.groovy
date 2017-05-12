package com.ttn.linksharing

import com.ttn.linkSharing.ReadingItem
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.User
import com.ttn.linkSharing.UserService
import com.ttn.linkSharing.co.UserCO
import org.apache.commons.lang.RandomStringUtils

class UserController {

    UserService userService

    def index() {
        User user = session.user
        params.max = 5
        params.offset = 0

        println "hello"
        def list = Topic.getTrendingTopics()
        list.each {
            println list.properties
        }
        render view: '/user/index', model: [subscribedTopic: User.getSubscribedTopic(user),
                                            inboxList      : ReadingItem.getUnReadItems(user, params),
                                            unReadCount    : ReadingItem.getUnReadItemCount(user),
                                            trendingTopic  : Topic.getTrendingTopics()]
    }

    def inbox() {
        User user = session.user
        render template: '/user/template/messages', model: [inboxList: ReadingItem.getUnReadItems(user, params)]
    }

    //todo
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

    //todo
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

    //todo
    def forgetPassword(String recoveryEmail) {
        User user = User.findByEmail(recoveryEmail)
        String charset = (('A'..'Z') + ('0'..'9')).join()
        if (user) {
            String newPassword = RandomStringUtils.random(8, charset.toCharArray())
            sendMail {
                to recoveryEmail
                subject "account recovery"
                body "new password ${newPassword}"
            }
            user.password = newPassword
        }
    }
}
