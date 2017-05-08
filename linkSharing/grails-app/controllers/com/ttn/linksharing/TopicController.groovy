package com.ttn.linksharing

import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.TopicService
import com.ttn.linkSharing.co.ResourceSearchCo
import com.ttn.linkSharing.enums.Visibility

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
            render view: '/notFound'
        }
    }

    def renderJS() {
        render("<script>alert('Hi controller')</script>")
    }

    def showTopic(ResourceSearchCo searchCO) {
        Topic topic = Topic.read(searchCO.topicId)
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC)
                render "render public topic success"
            else if (topic.visibility == Visibility.PRIVATE) {
                if (Subscription.findByUserAndTopic(session["user"], topic)) {
                    render "Subscription exist Success"
                } else {
                    render "Subscription not exist"
                    flash.error = "Subscription not exist"
                    redirect(controller: "login", action: "index")
                }
            }
        }
    }

    def saveTopic(String topicTitle, String visibility) {
        topicService.saveTopic(topicTitle, visibility, session.user)
        render "Topic saved success"
    }

//    def saveTopic(String topicTitle, String visibility) {
//        Topic topic = new Topic(name: topicTitle, createdBy: session['user'], visibility: Visibility.toEnum(visibility), description: "description")
//        topic.save(flush: true)
//        if (topic.hasErrors()) {
//            flash.error = "Topic is not saved!!"
//            render "Topic is not Saved!!"
//        }else {
//            render "Topic saved success"
//        }
//    }

    def search() {

    }
}
