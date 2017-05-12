package com.ttn.linksharing

import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.User
import com.ttn.linkSharing.enums.Seriousness

class SubscriptionController {

    def index() {
        render "hello subscription"
    }

    def save(Long topicId) {
        Topic topic = Topic.read(topicId)
        if (topic) {
            Subscription subscribe = new Subscription(topic: topic, user: session.user)
            subscribe.save(flush: true)
            if (subscribe.hasErrors()) {
                flash.error = "Subscription failed!!"
                redirect(controller: 'login', action: 'index')
            } else {
                flash.success = "Subscription Success!!"
                redirect(controller: 'login', action: 'index')
            }
        } else flash.error = "Invalid TopicId!!!"
    }

    def update(Long id, String seriousness) {
        Subscription subscription = Subscription.read(id)
        if (subscription) {
            subscription.seriousness = Seriousness.toEnum(seriousness)
            subscription.save(flush: true)
            if (subscription.hasErrors()) {
                render "Subscription update failed"
            } else {
                render "Subscription updated"
            }
        } else {
            render "Subscription notFound"
        }
    }
//todo
    def delete(Long topicId) {
        println "delete $topicId"
        Subscription subscription = Subscription.findByUserAndTopic(session.user,Topic.read(topicId))
        if (subscription) {
            subscription.delete(flush: true)
            if (subscription.hasErrors()) {
                flash.error = "Subscription deletion failed"
                redirect(controller: 'login', action: 'index')

            } else {
                flash.success = "Subscription Deleted!!"
                redirect(controller: 'login', action: 'index')
            }
        }
    }
}