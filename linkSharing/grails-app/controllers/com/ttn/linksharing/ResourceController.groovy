package com.ttn.linksharing

import com.ttn.linkSharing.Resource
import org.springframework.dao.DataIntegrityViolationException

class ResourceController {

    def index() { }

    def showResource(Long id){
        Resource resource = Resource.read(id)
    }

    def deleteTopic(Long id) {
        Resource resource = Resource.load(id)
        try{
            resource.delete(flush: true)
            flash.success = "Resource Deleted!!"
        } catch (DataIntegrityViolationException e){
            flash.error = "Resource Deletion failed!!"
        }
    }
}
