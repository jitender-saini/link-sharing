package com.ttn.linkSharing.co

import com.ttn.linkSharing.User
import com.ttn.linkSharing.enums.Visibility

class TopicSearchCO extends SearchCO {
    Long id
    Visibility visibility

    User getUser() {
        User user = User.get(id)
        return user
    }
}