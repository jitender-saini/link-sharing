package com.ttn.linksharing

import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.enums.Visibility

class TopicController {

    def index() {}

    def showTopic(Long id) {
        Topic topic = Topic.read(id)
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC)
                render "render public topic success"
            else if (topic.visibility == Visibility.PRIVATE) {
                if (Subscription.findByUserAndTopic(session["user"], topic)) {
                    render "Subscription exist Success"
                } else {
                    render "Subscription not exist"
                    flash.error = "Subscription not exist"
                    redirect(controller: "login", action: "index")
                }
            }
        }
    }

    def saveTopic(String topicTitle, String visibility) {
        Topic topic = new Topic(topicTitle: topicTitle, createdBy: session['user'], visibility: visibility, description: "description")
        topic.save(flush: true)
        if (topic.hasErrors()) {
            flash.error = "Topic is not saved!!"
            render "Topic is not Saved!!"
        }else {
            flash.success = "Topic saved success"
        }
    }
}
