package com.ttn.linksharing

import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic

class SubscriptionController {

    def index() {}

    def saveSubscription(Long topicId) {
        Subscription subscribe = new Subscription(topic: Topic.load(topicId), user: (session['user']))
        if (subscribe) {
            subscribe.save(flush: true)
            if (subscribe.hasErrors()) {
                flash.error = "Subscription failed!!"
                render "Subscription failed!!"
            } else {
                flash.success = "Subscription Success!!"
                render "Subscription Success!!"
            }
        }

    }

    def updateSubscription(Long id, String seriousness) {
        Subscription subscription = Subscription.findByIdAndSeriousness(id, seriousness)
        if (subscription) {
            subscription.save(flush: true)
            if (subscription.hasErrors()) {
                render "Subscription notFound"
            } else {
                render "Subscription update failed"
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