package com.ttn.linkSharing

import com.ttn.linkSharing.co.TopicCO
import grails.transaction.Transactional

@Transactional
class TopicService {

    def saveTopic(TopicCO topicCO) {
        Topic topic = new Topic(topicCO.properties)
        if (topic.save(flush: true, failOnErron: true)) {
            println "topic register called"
            return true
        } else {
            println "topic register failed"
            return false
        }
    }
}
