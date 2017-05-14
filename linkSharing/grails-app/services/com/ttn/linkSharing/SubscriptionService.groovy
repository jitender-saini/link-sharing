package com.ttn.linkSharing

import com.ttn.linkSharing.co.TopicSearchCO
import com.ttn.linkSharing.vo.TopicVO
import grails.transaction.Transactional

@Transactional
class SubscriptionService {

    def serviceMethod() {

    }
    List<TopicVO> search(TopicSearchCO topicSearchCO){

        if(topicSearchCO.id)
        {
            User user = topicSearchCO.getUser()
            def params = [:]
            params.max=topicSearchCO.max
            params.offset=topicSearchCO.offset
            return User.getSubscribedTopic(user,params)
        }
    }
}
