package com.ttn.linkSharing

import com.ttn.linkSharing.enums.Seriousness

class Subscription {

    User user
    Topic topic
    Seriousness seriousness = Seriousness.SERIOUS
    Date dateCreated = new Date()
    Date lastUpdated = new Date()

    static constraints = {
        user unique: "topic", nullable: false, blank: false
    }
    static mapping = {
        user lazy: false
        topic lazy: false
    }

    static belongsTo = [topic: Topic]

    String toString() {
        return "User: ${user.userName} Subscribed Topic: ${topic.name}"
    }

//    def afterInsert() {
//        withNewSession {
//            topic.resource.each {
//                ReadingItem readingItem = new ReadingItem(user: user, resource: it, isRead: false)
//                readingItem.save(flush: true)
//                if(readingItem.hasErrors()){
//                    log.error readingItem.errors.allErrors
//                }
//                else log.info "Reading item created"
//            }
//        }
//    }
}