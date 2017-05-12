package com.ttn.linksharing

import com.ttn.linkSharing.DocumentResource
import com.ttn.linkSharing.LinkResource
import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.User
import com.ttn.linkSharing.co.ResourceSearchCo
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.multipart.MultipartFile

class ResourceController {

    def index() {

    }

    def saveLink(){
        Resource linkResource = new LinkResource(url: params.link, description: params.description,
                createdBy: session.user, topic: Topic.load(params.topicId))
        linkResource.save(flush:true)
        if(linkResource.hasErrors()) {
            println linkResource.errors.allErrors
            redirect(controller: "user", action: "index")
        }
        else {
            println "save success link"
            redirect(controller: "user", action: "index")
        }

    }
    def saveDoc() {
        try {
            MultipartFile file = params.file
            String extension = '.' + file.originalFilename.tokenize('.').last()
            String folderPath = grailsApplication.config.resource.document.folderPath
            println "folder path: ${folderPath}"
            File directory = new File(folderPath)
            String fullPath = folderPath + UUID.randomUUID() + extension
            if (!directory.exists()) {
                directory.mkdirs()
                println "directory created"
            }
            if (file.empty) {
                flash.message = "File can't be empty"
            } else {
                DocumentResource documentResource = new DocumentResource(filePath: fullPath, description: params.description,
                        topic: Topic.load(params.topicId), createdBy: session.user)
                documentResource.save(flush: true)
                if(documentResource.hasErrors()){
                    println documentResource.errors.allErrors
                }
                else{
                    println " saved success"
                }
                file.transferTo(new File(fullPath))
            }
            redirect(controller: 'login', action: 'index')
        } catch (Exception e) {
            e.printStackTrace()
            redirect(controller: "user", action: "index")
        }
    }

    def show(){
        render(view:"resourceShow",model: [resource:Resource.get(params.resourceId)])
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

    def searchByQuery(String query){
        User user = session.user
        if(query ||user && user.isAdmin && !query){
            log.info "1"
            render(view:"/search", model: [searchresource:Resource.findResourceByQuery(query)])
        }
    }
}
