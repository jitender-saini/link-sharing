package com.ttn.linkSharing

import com.ttn.linkSharing.enums.Seriousness
import com.ttn.linkSharing.enums.Visibility
import com.ttn.linkSharing.vo.TopicVO

class Topic {

    String name
    String description
    Visibility visibility
    User createdBy
    Date dateCreated
    Date lastUpdated

    static belongsTo = [createdBy: User]

    static hasMany = [subscription: Subscription, resorces: Resource]

    static mapping = {
        sort name: "asc"
    }

    static constraints = {
        name unique: 'createdBy', nullable: false, blank: false
        description nullable: false, blank: false
        visibility nullable: false, blank: false
        createdBy nullable: false, blank: false
    }


//    def afterInsert() {
//        withNewSession {
//            Subscription subscription = new Subscription(topic: this, user: createdBy, seriousness: Seriousness.VERY_SERIOUS)
//            subscription.save()
//            if (subscription.hasErrors())
//                log.error "Subscription failed ${subscription.errors.allErrors}"
//            else log.info "${createdBy.userName} has subscribed ${name}"
//        }
//    }

//    static List<TopicVO> getTrendingTopics() {
//        def resource = Resource.createCriteria().list(max:5) {
//            projections {
//                createAlias('topic', 't')
//                groupProperty('t.id')
//                property('t.visibility')
//                property('t.name')
//                property('t.createdBy')
//                count('t.id', 'rCount')
//            }
//            and {
//                order('rCount', 'desc')
//                order('name')
//            }
//        }
//        println(resource.properties)
//        List<TopicVO> topicVOList = []
//        resource.each {
//            topicVOList << new TopicVO(id: it[0], name: it[1], visibility: it[2], createdBy: it[3], count: it[4])
//        }
//        if (topicVOList.size() > 4)
//        println topicVOList.properties
//        return topicVOList
//        else topicVOList
//    }

    static List<TopicVO> getTrendingTopics() {
        List<TopicVO> topicVOList = createCriteria().list(max: 5) {
            projections {
                groupProperty('id')
                property('name')
                property('visibility')
                property('createdBy')
                resorces {
                    count('id', 'resourceCount')
                }
            }
            and {
                order('resourceCount', 'desc')
                order('name')
            }
        }.collect {
            new TopicVO(id: it[0], name: it[1], visibility: it[2], createdBy: it[3], count: it[4])
        }
        return topicVOList
    }

    String toString() {
        return "Topic: ${name} is createdBy ${createdBy.userName}"
    }
}
