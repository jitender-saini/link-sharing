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
        description nullable: true, blank: true, maxSize: 2048
    }

    static mapping = {
        description type: 'text'
    }


    String toString() {
        return "Topic : ${topic} Description : ${description}"
    }
}
