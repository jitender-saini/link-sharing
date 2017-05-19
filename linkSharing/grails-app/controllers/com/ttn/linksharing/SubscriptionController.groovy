package com.ttn.linksharing

import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.User
import com.ttn.linkSharing.enums.Seriousness
import grails.converters.JSON

class SubscriptionController {

    def save(Long topicId) {
        Map json = [:]
        Topic topic = Topic.read(topicId)
        if (topic) {
            Subscription subscribe = new Subscription(topic: topic, user: session.user)
            subscribe.save(flush: true)
            if (subscribe.hasErrors()) {
                json.error = "Subscription failed!!"
            } else {
                json.message = "Subscription Success"
            }
        } else json.error = "Invalid TopicId!!!"
        response json as JSON
    }

    def update(Long topicId, String seriousness) {
        Map json = [:]
        Subscription subscription = Subscription.read(topicId)
        if (subscription) {
            subscription.seriousness = Seriousness.toEnum(seriousness)
            subscription.save(flush: true)
            if (subscription.hasErrors()) {
                json.message = "Subscription update failed"
            } else {
                json.message = "Subscription updated"
            }
        } else {
            json.message = "Subscription notFound"
        }
        response json as JSON
    }

//todo
    def delete(Long topicId) {
        Map json = [:]
        Subscription subscription = Subscription.findByUserAndTopic(session.user, Topic.read(topicId))
        if (subscription) {
            subscription.delete(flush: true)
            if (subscription.hasErrors()) {
                json.error = "Subscription deletion failed"

            } else {
                json.message = "Subscription Deleted!!"
            }
        }
        response json as JSON
    }
}