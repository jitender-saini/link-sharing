package com.ttn.linkSharing

import com.ttn.linkSharing.co.ResourceSearchCo
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
        search { ResourceSearchCo searchCo ->
            if (searchCo.topicId) {
                eq('topic_id', searchCo.topicId)
            }
            if (searchCo.visibility) {
                eq('topic.visibility', searchCo.visibility)
            }
        }
    }

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


    String toString() {
        return "Resource for Topic : ${topic.name} created by ${createdBy.userName}"
    }
}
