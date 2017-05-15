package com.ttn.linksharing

import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.ResourceService
import com.ttn.linkSharing.TopicService
import com.ttn.linkSharing.co.ResourceSearchCO
import com.ttn.linkSharing.co.TopicSearchCO
import com.ttn.linkSharing.vo.TopicVO

class SearchController {
    TopicService topicService
    ResourceService resourceService

    def show() {
        if(params.q) {
            TopicSearchCO topicSearchCO = new TopicSearchCO()
            bindData(topicSearchCO, params)
            ResourceSearchCO resourceSearchCO = new ResourceSearchCO()
            bindData(resourceSearchCO, params)
            List<TopicVO> topics = topicService.search(topicSearchCO)
            List<Resource> posts = resourceService.search(resourceSearchCO)
            render view: "show", model: [topics: topics, posts: posts]
        }else {
            flash.message = "Enter any query to search"
            redirect(controller: "login", action: "index")
        }
    }
}
