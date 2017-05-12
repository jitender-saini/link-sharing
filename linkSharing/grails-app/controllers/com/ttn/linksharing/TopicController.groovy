package com.ttn.linksharing

import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.TopicService
import com.ttn.linkSharing.co.ResourceSearchCo
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
            render view: '/notFound'
        }
    }

    def renderJS() {
        render("<script>alert('Hi controller')</script>")
    }

    def showTopic(Long topicId){
        Topic topic = Topic.get(topicId)
        if(topic){
            render view: '/topic/showTopic', model: [topic:topic,
                                                     subscribers:Topic.getSubscribers(topicId),
                                                     resources: Topic.getResources(topicId)]
        }
    }

//    def showTopic(ResourceSearchCo searchCO) {
//        Topic topic = Topic.read(searchCO.topicId)
//        if (topic ) {
//            if (topic.visibility == Visibility.PUBLIC)
//                render "render public topic success"
//            else if (topic.visibility == Visibility.PRIVATE) {
//                if (Subscription.findByUserAndTopic(session["user"], topic)) {
//                    render "Subscription exist Success"
//                } else {
//                    render "Subscription not exist"
//                    flash.error = "Subscription not exist"
//                    redirect(controller: "login", action: "index")
//                }
//            }
//        }
//    }

    def findTopic(){
        def topic = Topic.get(params.topic.id)
    }

    def create(String name, String visibility) {
//        Topic topic = new Topic(name: name,visibility: Visibility.toEnum(visibility),createdBy: session.user)
//        topic.save(flush:true,failOnError:true)

        TopicCO topicCO = new TopicCO(name: name,visibility: Visibility.toEnum(visibility),createdBy: session.user)
        topicService.saveTopic(topicCO)
        redirect(controller: "login", action: "index")

    }

    def search() {

    }
}
