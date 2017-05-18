package com.ttn.linksharing

import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.ResourceService
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.TopicService
import com.ttn.linkSharing.User
import com.ttn.linkSharing.co.ResourceSearchCO
import com.ttn.linkSharing.co.TopicSearchCO
import com.ttn.linkSharing.vo.TopicVO

class SearchController {
    TopicService topicService
    ResourceService resourceService

    def show(String q) {
        if (q) {
            User user = session.user
            TopicSearchCO topicSearchCO = new TopicSearchCO()
            bindData(topicSearchCO, params)

            ResourceSearchCO resourceSearchCO = new ResourceSearchCO()
            bindData(resourceSearchCO, params)

            List<TopicVO> topics = topicService.search(user, topicSearchCO)
            List<Resource> posts = resourceService.search(user, resourceSearchCO)
            render view: "show", model: [topics: topics, posts: posts]
        } else {
            flash.message = "Enter any query to search"
            redirect(controller: "login", action: "index")
        }
    }
}
