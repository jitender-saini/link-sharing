package com.ttn.linkSharing.co

import com.ttn.linkSharing.User
import com.ttn.linkSharing.enums.Visibility
import grails.validation.Validateable

class TopicCO implements Validateable{
    Integer id
    String name
    Visibility visibility
    Integer count
    User createdBy
    static constraints = {
        name nullable: false, blank: false
        visibility nullable: false, blank: false
        createdBy nullable: false, blank: false
        id nullable: true
        count nullable: true
    }
}
