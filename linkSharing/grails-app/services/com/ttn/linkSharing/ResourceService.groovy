package com.ttn.linkSharing

import com.ttn.linkSharing.co.ResourceSearchCO
import com.ttn.linkSharing.enums.Visibility
import com.ttn.linkSharing.vo.ResourceVO
import grails.transaction.Transactional

@Transactional
class ResourceService {

    List<Resource> search(User user, ResourceSearchCO co) {
        if (co) {
//            Topic topic = Topic.read(co.topicId)
//            if (!user.isAdmin || topic.createdBy != user) {
//                co.visibility = Visibility.PUBLIC
//                List<Resource> resources = Resource.search(co).list()
//                return resources
//            } else {
            List<Resource> resources = Resource.search(co).list()
            return resources
//            }
        }
    }

//    List<ResourceVO> search(User user, ResourceSearchCO co) {
//        List<ResourceVO> post = []
//        if (co.q) {
//            if (user.isAdmin || user == Topic.read(co.id).createdBy) {
//                List<Resource> resourceList = Resource.createCriteria().list(offset: co.offset, max: co.max) {
//                    ilike('description', "%${co.q}%")
//                }
//                resourceList.each { resource ->
//                    post.add(new ResourceVO(id: resourceList.id, description: resourceList.description, createdBy: resourceList.createdBy, topic: resourceList.topic))
//                }
//            } else {
//                List<Resource> resourceList = Resource.createCriteria().list(offset: co.offset, max: co.max) {
//                    ilike('description', "%${co.q}%")
//                    createAlias('topic', 't')
//                    eq('t.visibility', Visibility.PUBLIC)
//                }
//                resourceList.each { resource ->
//                    post.add(new ResourceVO(id: resourceList.id, description: resourceList.description, createdBy: user, topic: resourceList.topic))
//                }
//            }
//        }
//        return post
//    }
}