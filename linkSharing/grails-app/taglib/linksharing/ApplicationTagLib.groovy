package linksharing

import com.ttn.linkSharing.LinkResource
import com.ttn.linkSharing.ReadingItem
import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.User
import com.ttn.linkSharing.vo.TopicVO

class ApplicationTagLib {
    static defaultEncodeAs = "raw"

    static namespace = "ls"
    def isRead = { attrs, body ->
        User user = session.user
        if (user) {
            Resource resource = attrs.resource
            if (resource) {
                Integer count = ReadingItem.countByResourceAndIsReadAndUser(resource, true, user)
                if (count) {
                    out << "<a href='${createLink(controller: 'readingItem', action: 'toggleIsRead', id: resource.id)}'>Mark as Un Read</a> "
                } else {
                    out << "<a href='${createLink(controller: 'readingItem', action: 'toggleIsRead', id: resource.id)}'>Mark as Read</a> "
                }
            }
        }
    }

    def isLoggedIn = { attrs, body ->
        if (session.user) {
            out << body()
        }

    }

    def checkResourceType = { attrs ->
        if (session.user) {
            log.info(" $session.user")
            Resource resource = Resource.get(attrs.resourceId)
            if (resource instanceof LinkResource)

                out << "<span><a href='${resource.url}' target='_blank'>View Full Site</a></span> "
            else out << "<span><a href='${resource.filePath}' target='_blank'>Download</a></span> "
        } else out << ""
    }

    def showTrendingTopic = {
        User user = session.user
        if (user) {
            List<TopicVO> trendingTopics = Topic.getTrendingTopics()
            out << g.render(template: "/topic/template/trendingTopic", model: [trendingTopics: trendingTopics, user: user])
        }
    }

    def showTopPost = {
        User user = user.session
        List<Resource> topPost = Topic.getTopPost()
        out << g.render(template: "/resource/template/show", model: [topPost: topPost, user: user])
    }

    def getSubscriptionCount = { attrs ->
        int count
        String result = ""
        if (attrs.topicId) {
            count = Topic.getSubscriptionCount(Topic.load(attrs.topicId))
//            result = g.link(controller: "topic", action: "show", params: [id: attrs.topicId],count)
        } else if (attrs.user) {
            count = User.getSubscriptionCount(attrs.user)
//            result = g.link(controller: "user", action: "profile", params: ["resourceSearchCO.id": user.userId],count)
        }
        out << count
    }

    def getResourceCount = { attrs ->
        int count
        String result = ""
        if (attrs.topicId) {
            count = Topic.getResourceCount(Topic.load(attrs.topicId))
//            result = g.link(controller: "topic", action: "show", params: [id: attrs.topicId],count)
        }
        out << count
    }

    def showSubscribe = { attrs ->
        User user = session.user
        if (user && attrs.topicId) {
            if (User.isSubscribed(user, attrs.topicId)) {
                out << "<a href='${createLink(controller: 'subscription', action: 'delete', params: [topicId: attrs.topicId])}'>Unsubscribe</a>"
            } else {
                out << "<a href='${createLink(controller: 'subscription', action: 'save', params: [topicId: attrs.topicId])}'>subscribe</a>"
            }
        }
    }

    def topicCount = { attrs ->
        int count
        User user = User.get(attrs.userId)
        if (user) {
            count = User.getTopicCount(user)
            out << count
//                   "<p>${createLink(controller: "topic", action: "show", params: [id: attrs.topicId])} $count</p>"
//            result = g.link(controller: "topic", action: "show", params: [id: attrs.topicId],count)
        }
//        out << result
    }


    def showEditTopic = { attrs ->
        def topic = attrs.topic
        out << g.render(template: "/topic/template/editTopic", model: [topic: topic])
    }

    def canUpdateTopic = {attrs->
            User user = session.user
        if(user){
            Topic topic = attrs.topic
            Subscription subscription =user.getSubscription(topic.id)
            if(subscription){
                if(topic.createdBy == user){
                    out<<g.render(template: "/topic/templates/menuPanelForTopicCreator",model: [topic:topic])
                }
                else {
                    out<<g.render(template: "/topic/templates/menuPanelForTopicSubscriber",model: [topic:topic])
                }
            }
        }
    }
}

//    def subscribedTopic = { attrs ->
//        User user = session.user
//        if(user){
//            List list = User.getSubscribedTopic(user)
//            out<<"<g:select class= ' btn dropdown-toggle form-control' data-toggle='dropdown' name='topicId'  optionKey='id' optionValue='name' from='${list}'/>"
//        }
//    }


