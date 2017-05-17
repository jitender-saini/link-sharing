package com.ttn.linksharing

import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.TopicService
import com.ttn.linkSharing.User
import com.ttn.linkSharing.co.ResourceSearchCO
import com.ttn.linkSharing.enums.Visibility
import com.ttn.linkSharing.co.TopicCO

class TopicController {
    TopicService topicService

    def index(Long id) {
        Topic topic = Topic.get(id)
        if (topic) {
            Topic topic1 = new Topic()
            topic1.validate()
            List<Resource> resources = Resource.findAllByTopic(topic, [max: 20, sort: 'id', order: 'desc'])
            render view: 'index', model: [topic: topic, resources: resources, topic1: topic1]
        } else {
            flash.error = "Topic not found"
            redirect(controller: "login", action: "index")
        }
    }

    def showTopic(ResourceSearchCO searchCO) {
        Topic topic = Topic.read(searchCO.topicId)
        User user = session.user
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC) {
                render view: '/topic/showTopic', model: [topic      : topic,
                                                         subscribers: Topic.getSubscribers(topic.id),
                                                         resources  : Topic.getResources(topic.id)]
            } else if (topic.visibility == Visibility.PRIVATE) {
                if (topic.createdBy == user || user.isAdmin) {
                    render view: '/topic/showTopic', model: [topic      : topic,
                                                             subscribers: Topic.getSubscribers(topic.id),
                                                             resources  : Topic.getResources(topic.id)]
                }
            } else if (topic.visibility == Visibility.PRIVATE) {
                if (Subscription.findByUserAndTopic(session.user, topic)) {
                    flash.error = "user not subscribed to this topicId"
                    redirect(controller: "login", action: "index")
                } else {
                    flash.error = "Subscription not exist"
                    redirect(controller: "login", action: "index")
                }
            }
        }
    }

    def create(String name, String visibility) {
        if (name && visibility) {
            TopicCO topicCO = new TopicCO(name: name, visibility: Visibility.toEnum(visibility), createdBy: session.user)
            topicService.saveTopic(topicCO)
        }
        flash.message = "Topic Create Successfully"
        redirect(controller: "login", action: "index")
    }


    def edit(String topicName, Long topicId) {
        Topic topic = Topic.get(topicId)
        if (topic) {
            topic.name = topicName
            topic.save(flush: true, failOnError: true)
            if (topic.hasErrors()) {
                flash.error = "error in updating topic"
            } else {
                flash.message = "topic name changed"
            }
        } else {
            flash.error = "topic does not exist"
        }
        redirect(controller: 'user', action: 'index')
    }

    def delete(Long topicId) {
        Topic topic = Topic.read(topicId)
        if (topic) {
            topic.delete(flush: true, failOnError: true)
            flash.message = "Topic Deleted!!"
        } else {
            flash.error = "Topic Deletion failed!!"
        }
        redirect(controller: "user", action: "index")

    }
}
