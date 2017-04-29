package com.ttn.linkSharing

import com.ttn.linkSharing.enums.Seriousness
import com.ttn.linkSharing.enums.Visibility

class Topic {


    String topicTitle
    String description
    Visibility visibility
    User createdBy
    Date dateCreated = new Date()
    Date lastUpdated = new Date()

    static belongsTo = [createdBy: User]

    static hasMany = [subscription: Subscription, resorces: Resource]

    static constraints = {
        topicTitle unique: 'createdBy', nullable: false, blank: false
        description nullable: false, blank: false
        visibility nullable: false, blank: false
        createdBy nullable: false, blank: false
    }

    def afterInsert(){
        Topic.withNewSession {
            Subscription subscription = new Subscription(topic: this, user: createdBy, seriousness: Seriousness.VERY_SERIOUS)
            this.addToSubscription(subscription)

            if (subscription.hasErrors())
                log.error "Subscription failed ${subscription.errors.allErrors}"
            else log.info "${createdBy.name} has subscribed ${topicTitle}"
        }
    }

    String toString(){
        return "Topic: ${topicTitle} is createdBy ${createdBy.userName}"
    }
}
