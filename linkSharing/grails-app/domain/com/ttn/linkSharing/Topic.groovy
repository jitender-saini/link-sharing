package com.ttn.linkSharing

class Topic {


    String topicTitle
    String description
    Visibility visibility
    User createdBy
    Date dateCreated
    Date lastUpdated

    static belongsTo = [createdBy: User]

    static hasMany = [subscription: Subscription, resorces: Resource]

    static constraints = {
        topicTitle unique: 'createdBy', nullable: false, blank: false
        description nullable: false, blank: false
//        visibility nullable: false, blank: false
        createdBy nullable: false, blank: false
    }
}
