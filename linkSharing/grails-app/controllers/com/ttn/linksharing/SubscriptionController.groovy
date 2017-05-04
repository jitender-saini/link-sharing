package com.ttn.linksharing

import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic

class SubscriptionController {

    def index() {
        render "hello subscription"
    }

    def saveSubscription(Long topicId) {
        Topic topic = Topic.load(topicId)
        if (topic) {
            Subscription subscribe = new Subscription(topic: topic, user: (session['user']))
            subscribe.save(flush: true)
            if (subscribe.hasErrors()) {
                flash.error = "Subscription failed!!"
                render "Subscription failed!!"
            } else {
                flash.success = "Subscription Success!!"
                render "Subscription Success!!"
            }
        }
        else render "Invalid TopicId!!!"
    }

    def updateSubscription(Long id, String seriousness) {
        Subscription subscription = Subscription.findByIdAndSeriousness(id, seriousness)
        if (subscription) {
            subscription.seriousness = "CASUAL"
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

    def deleteSubscription(Long id) {
        Subscription subscription = Subscription.load(id)
        if (subscription) {
            subscription.delete(flush: true)
            if (subscription.hasErrors()) {
                flash.error = "Subscription deletion failed"
                render "Subscription deletion failed"
            } else {
                flash.success = "Subscription Deleted!!"
                render "Subscription Deleted!!"
            }
        }
    }
}