package com.ttn.linksharing

import com.ttn.linkSharing.ReadingItem
import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.ResourceService
import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.SubscriptionService
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.TopicService
import com.ttn.linkSharing.User
import com.ttn.linkSharing.UserService
import com.ttn.linkSharing.co.ResourceSearchCO
import com.ttn.linkSharing.co.TopicSearchCO
import com.ttn.linkSharing.co.UserCO
import com.ttn.linkSharing.enums.Visibility
import com.ttn.linkSharing.vo.TopicVO
import org.apache.commons.lang.RandomStringUtils

class UserController {

    UserService userService
    TopicService topicService
    ResourceService resourceService
    SubscriptionService subscriptionService
    def assetResourceLocator

    def index() {
        User user = session.user
        params.max = 5
        params.offset = 0
        def list = Topic.getTrendingTopics()
        list.each {
            println list.properties
        }
        render view: '/user/index', model: [subscribedTopic  : User.getSubscribedTopic(user, params),
                                            subscriptionCount: User.getSubscriptionCount(user),
                                            inboxList        : ReadingItem.getUnReadItems(user, params),
                                            unReadCount      : ReadingItem.getUnReadItemCount(user),
                                            trendingTopic    : Topic.getTrendingTopics()]
    }

    def profile(ResourceSearchCO resourceSearchCO) {
        if (resourceSearchCO) {
            User user = User.get(resourceSearchCO.id)
            if (session.user) {
                if (!(session.user.isAdmin || session.user == user)) {
                    resourceSearchCO.visibility = Visibility.PUBLIC
                }
            }
            List<TopicVO> createdTopics = topicService.search(new TopicSearchCO(id: resourceSearchCO.id))
            int totalCreatedTopicCount = Topic.findAllByCreatedBy(user).size()
            List<TopicVO> subscribedTopics = subscriptionService.search(new TopicSearchCO(id: resourceSearchCO.id))
            int totalSubscribedTopicCount = Subscription.count()
            List<Resource> createdPosts = resourceService.search(resourceSearchCO)
            int totalCreatedPostCount = Resource.findAllByCreatedBy(user).size()
            [createdPosts             : createdPosts,
             createdTopics            : createdTopics,
             subscribedTopics         : subscribedTopics,
             totalSubscribedTopicCount: totalSubscribedTopicCount,
             totalCreatedTopicCount   : totalCreatedTopicCount,
             totalCreatedPostCount    : totalCreatedPostCount,
             user                     : user]
        }
    }

    def image(Long id) {
        User user = User.get(id)
        byte[] photo

        if (user.profilePic) {
            photo = user.profilePic
        } else {
            photo = assetResourceLocator.findAssetForURI('user.png').byteArray
        }
        response.contentType = 'image/png'
        OutputStream out = response.getOutputStream()
        out.write(photo)
        out.flush()
        out.close()
    }

    def inbox() {
        User user = session.user
        render template: '/user/template/messages', model: [inboxList: ReadingItem.getUnReadItems(user, params)]
    }

    def subscriptions() {
        User user = session.user
        render(template: '/subscription/template/show', model: [subscribedTopic: User.getSubscribedTopic(user, params)])
    }

    //todo
    def register() {
        log.info "controller"
        UserCO userCO = new UserCO()
        bindData(userCO, params, [exclude: ['isAdmin,isActive']])
        boolean result = userService.registration(userCO)
        if (result) {
            flash.success = "User Registration Success"
            forward(controller: "login", action: "index")

        } else {
            flash.error = "User Registration Failed"
            forward(controller: "login", action: "index")
        }
    }

    //todo
    def sendInvitation() {
        Topic topic = Topic.get(params.topicId)
        def list = ['user': session.user.fullName, 'topic': topic.name]
        println topic.name
        sendMail {
            to params.email
            subject "Subscribe ${topic.name}"
            body(view: "/email/mail", model: [data: list])
        }
        render "email sent ${topic.name}"
    }

    //todo
    def forgetPassword(String recoveryEmail) {
        User user = User.findByEmail(recoveryEmail)
        String charset = (('A'..'Z') + ('0'..'9')).join()
        if (user) {
            String newPassword = RandomStringUtils.random(8, charset.toCharArray())
            sendMail {
                to recoveryEmail
                subject "account recovery"
                body "new password ${newPassword}"
            }
            user.password = newPassword
        }
    }
}
