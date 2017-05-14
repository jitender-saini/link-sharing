package com.ttn.linkSharing.co

import com.ttn.linkSharing.User
import com.ttn.linkSharing.enums.Visibility
import grails.validation.Validateable

class ResourceSearchCO extends SearchCO implements Validateable {
    Long id
    Long topicId
    Visibility visibility

    User getUser() {
        User user = User.get(id)
        return user
    }
}
