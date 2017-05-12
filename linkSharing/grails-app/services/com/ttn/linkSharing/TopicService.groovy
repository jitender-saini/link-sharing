package com.ttn.linkSharing

import com.ttn.linkSharing.co.TopicCO
import grails.transaction.Transactional

//@Transactional
class TopicService {

    def saveTopic(TopicCO topicCO) {
        println "1"
        Topic topic = new Topic(topicCO.properties)
        println "2"
        println topic
        println "-------"
        if (topic.validate()) {
            topic.save()
            println "3"
            println "topic register called"
            return true
        } else {
            println "4"
            println "topic register failed :"
            topic.errors.allErrors.each { println it }
            return false
        }
        println "5"
    }
}
