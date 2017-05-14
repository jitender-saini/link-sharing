package com.ttn.linkSharing

import com.ttn.linkSharing.co.TopicCO
import com.ttn.linkSharing.co.TopicSearchCO
import com.ttn.linkSharing.enums.Visibility
import com.ttn.linkSharing.vo.TopicVO
import grails.transaction.Transactional

//@Transactional
class TopicService {

    def saveTopic(TopicCO topicCO) {
        Topic topic = new Topic(topicCO.properties)
        println topic
        if (topic.validate()) {
            topic.save()
            return true
        } else {
            topic.errors.allErrors.each { println it }
            return false
        }
    }

    List<TopicVO> search(TopicSearchCO topicSearchCO) {
        List<TopicVO> createdTopicsList = []

        if (topicSearchCO.id) {
            User user = topicSearchCO.getUser()

            List<Topic> topicList = Topic.createCriteria().list(offset: topicSearchCO.offset, max: topicSearchCO.max) {
                eq('createdBy.id', topicSearchCO.id)

                if (topicSearchCO.visibility)
                    eq('visibility', topicSearchCO.visibility)
                if (topicSearchCO?.q)
                    eq('name', "%${topicSearchCO.q}%")
            }

            topicList.each {
                topic -> createdTopicsList.add(new TopicVO(id: topic.id, name: topic.name, visibility: topic.visibility, createdBy: topic.createdBy))
            }

        } else {
            List<Topic> topicList = Topic.createCriteria().list(offset: topicSearchCO.offset, max: topicSearchCO.max) {
                eq('visibility', Visibility.PUBLIC)
                if (topicSearchCO?.q)
                    ilike('name', "%${topicSearchCO.q}%")
            }

            topicList.each {
                topic -> createdTopicsList.add(new TopicVO(id: topic.id, name: topic.name, visibility: topic.visibility, createdBy: topic.createdBy))
            }
        }

        return createdTopicsList
    }


}

