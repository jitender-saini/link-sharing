package com.ttn.linkSharing

import com.ttn.linkSharing.enums.Visibility
import grails.transaction.Transactional

@Transactional
class TopicService {

    def saveTopic(String topicTitle, String visibility, User createdBy) {
        Topic topic = new Topic(name: topicTitle, createdBy: createdBy, visibility: Visibility.toEnum(visibility), description: "description")
        topic.save()
        if (topic.hasErrors()) {
            log.info "Topic is not saved!!"
        }else {
            log.info "Topic saved success"
        }
    }
}
