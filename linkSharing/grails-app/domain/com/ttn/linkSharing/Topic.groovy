package com.ttn.linkSharing

import com.ttn.linkSharing.enums.Seriousness
import com.ttn.linkSharing.enums.Visibility
import com.ttn.linkSharing.vo.TopicVO

class Topic {

    String topicTitle
    String description
    Visibility visibility
    User createdBy
    Date dateCreated
    Date lastUpdated

    static belongsTo = [createdBy: User]

    static hasMany = [subscription: Subscription, resorces: Resource]

    static mapping = {
        sort topicTitle: "asc"
    }

    static constraints = {
        topicTitle unique: 'createdBy', nullable: false, blank: false
        description nullable: false, blank: false
        visibility nullable: false, blank: false
        createdBy nullable: false, blank: false
    }

    def afterInsert(){
        withNewSession {
            Subscription subscription = new Subscription(topic: this, user: createdBy, seriousness: Seriousness.VERY_SERIOUS)
                subscription.save()
            if (subscription.hasErrors())
                log.error "Subscription failed ${subscription.errors.allErrors}"
            else log.info "${createdBy.userName} has subscribed ${topicTitle}"
        }
    }

    static List<TopicVO> getTrendingTopics(){
        List resource = Resource.createCriteria().list {
            projections{
                createAlias('topic','t')
                groupProperty
            }
        }


    }

    String toString(){
        return "Topic: ${topicTitle} is createdBy ${createdBy.userName}"
    }
}
