package com.ttn.linkSharing

class Subscription {

    User user
    Topic topic
    Seriousness seriousness
    Date dateCreated
    Date lastUpdated

    static constraints = {
        user unique: "topic", nullable: false, blank: false

    }

    static belongsTo = [topic:Topic]

    String toString() {
        return "Topic : ${topic} User : ${user} Seriousness : ${seriousness}"
    }
}