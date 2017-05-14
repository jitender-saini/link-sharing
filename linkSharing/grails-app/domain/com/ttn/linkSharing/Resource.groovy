package com.ttn.linkSharing

import com.ttn.linkSharing.co.ResourceSearchCO
import com.ttn.linkSharing.vo.RatingInfoVO

abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated

    static belongsTo = [topic: Topic, createdBy: User]
    static hasMany = [readingItem: ReadingItem, resourceRating: ResourceRating]
    static transients = ['ratingInfo']

    static constraints = {
        description nullable: false, blank: false, maxSize: 2048
        createdBy nullable: false, blank: false
        topic nullable: false, blank: false
    }

    static mapping = {
        description type: 'text'
        tablePerHierarchy: false
    }

    static namedQueries = {
        search { ResourceSearchCO searchCo ->
            if (searchCo.topicId) {
                eq('topic_id', searchCo.topicId)
            }
            if (searchCo.visibility) {
                eq('topic.visibility', searchCo.visibility)
            }
        }
    }

//    def afterInsert(){
//        withNewSession {
//            ReadingItem readingItem = new ReadingItem(user: topic.subscription.user, resource: this, isRead: false)
//            readingItem.save(flush:true)
//            if(readingItem.hasErrors()){
//                log.error readingItem.errors.allErrors
//            }
//            else log.info "Reading item created"
//        }
//    }

    RatingInfoVO getRatingInfo() {
        List result = ResourceRating.createCriteria().get() {
            projections {
                count('id', 'totalVotes')
                sum('score')
                avg('score')
            }
            eq('resource', this)
        }
        return new RatingInfoVO(totalVotes: result[0], totalScore: result[1], averageScore: result[2])
    }

    static List<Resource> getRecentPost() {
        List<Resource> result = createCriteria().list(max: 5) {
            order('dateCreated', 'desc')
        }
        return result
    }

    static List<Resource> findResourceByQuery(String query) {
        List<Resource> result = createCriteria().list() {
            projectons {
                createAlias('topic', 't')
                or {
                    like('description', query)
                    like('t.name', query)
                }
            }
        }
        return result
    }


    String toString() {
        return "Resource for Topic : ${topic.name} created by ${createdBy.userName}"
    }
}
