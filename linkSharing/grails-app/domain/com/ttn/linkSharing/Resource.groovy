package com.ttn.linkSharing

abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated

    static belongsTo = [topic: Topic, createdBy: User]
    static hasMany = [readingItem: ReadingItem, resourceRating: ResourceRating]

    static constraints = {
        description nullable: false, blank: false, maxSize: 2048
        createdBy nullable: false, blank: false
        topic nullable:false, blank: false
    }

    static mapping = {
        description type: 'text'
        tablePerHierarchy: false
    }


    String toString() {
        return "Resource for Topic : ${topic.topicTitle} created by ${createdBy.userName}"
    }
}
