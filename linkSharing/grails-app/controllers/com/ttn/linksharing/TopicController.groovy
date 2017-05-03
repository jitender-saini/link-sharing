package com.ttn.linksharing

import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.enums.Visibility

class TopicController {

    def index() {}

    def showTopic(Long id) {
        Topic topic = Topic.findById(id)
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC)
                render "render public topic success"
            else if (topic.visibility == Visibility.PRIVATE) {
                if (Subscription.findByUserAndTopic(session["user"], topic)) {
                    render "Subscription exist Success"
                } else {
                    render flash.error("Subscription not exist")
                    redirect(controller: "login", action: "index")
                }
            }
        }

    }
}
