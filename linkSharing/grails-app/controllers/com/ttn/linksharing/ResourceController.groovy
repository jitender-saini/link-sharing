package com.ttn.linksharing

import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.co.ResourceSearchCo
import org.springframework.dao.DataIntegrityViolationException

class ResourceController {

    def index() {

    }

    def show(int id){
        render Resource.get(id).getRatingInfo()
    }

    def delete(int id) {
        Resource resource = Resource.load(id)
        try{
            resource.delete(flush: true)
            render flash.success = "Resource Deleted!!"
        } catch (DataIntegrityViolationException e){
            render flash.error = "Resource Deletion failed!!"
        }
    }

    def search(ResourceSearchCo resourceSearchCo){
        if(resourceSearchCo.q){
            resourceSearchCo.visibility = "PUBLIC"
        }
    }
}
