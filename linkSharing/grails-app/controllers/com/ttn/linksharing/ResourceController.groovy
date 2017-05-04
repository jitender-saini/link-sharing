package com.ttn.linksharing

import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.co.ResourceSearchCo
import org.springframework.dao.DataIntegrityViolationException

class ResourceController {

    def index() { }

    def showResource(Long id){
        Resource resource = Resource.read(id)
    }

    def deleteResource(Long id) {
        Resource resource = Resource.load(id)
        try{
            resource.delete(flush: true)
            render flash.success = "Resource Deleted!!"
        } catch (DataIntegrityViolationException e){
            render flash.error = "Resource Deletion failed!!"
        }
    }

    def resourceSearch(ResourceSearchCo searchCo){
        if(searchCo.q){
            searchCo.visibility = "PUBLIC"
        }


    }
}
