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

    def subscribedTopicList = {
        User user = session.user
//        def params = [:]
        params.max=5
        params.offset=0
        Topic subscribedTopics = User.getSubscribedTopic(user,params)
        out<< g.render(template: "/topic/template/topicList", model: [subscribedTopics:subscribedTopics])
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
        User user = attrs.user
        if (user) {
            count = User.getTopicCount(user)
            out << count
        }
    }


    def showEditTopic = { attrs ->
        Topic topic = Topic.read(attrs.topicId)
        out << g.render(template: "/topic/template/editTopic", model: [topic: topic])
    }

    def shoeEditResource = { attrs ->
        Resource resource = attrs.resource
        out << g.render(template: "/resource/template/edit-resource", model: [resource: resource])
    }

    def canUpdateTopic = { attrs ->
        User user = session.user
        if (user) {
            Subscription subscription = User.getSubscriptionOfTopic(user, attrs.topicId)
            if (subscription) {
                if (topic.createdBy == user) {
                    out << g.render(template: "/topic/template/topicCreatePanel", model: [topic: topic])
//                } else {
//                    out << g.render(template: "/topic/template/subscribeTopicPanel", model: [topic: topic])
                }
            }
        }
    }
    def showChangeSeriousness = { attrs ->
        User user = session.user
        if (user) {
            Subscription subscription = User.getSubscriptionOfTopic(user, attrs.topicId)
            List seriousness = ['Serious', 'Very Serious', 'Casual']
            if (subscription) {
                out << g.render(template: "/topic/template/change-seriousness", model: [subscription: subscription, seriousness: seriousness])
            }
        }
    }

    def showUserDetails = { attrs ->
        User user = User.get(attrs.userId)
        if (user) {
            out << g.render(template: "/user/template/show", model: [user: user])
        }
    }
    def showUserProfile = { attrs ->
        User user = User.read(attrs.userId)
        out << "<a href='${createLink(controller: 'user', action: 'profile', params: [userId: attrs.userId])}'>$user.userName</a>"
    }

    def userImage={attr->
        if(attr.userId){
            out << "<img src='${createLink(controller: "user", action: "image", id: "${attr.userId}")}' width=80 height=80 >"
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


