package com.ttn.linkSharing.vo

import com.ttn.linkSharing.User
import com.ttn.linkSharing.enums.Visibility

class TopicVO {
    Long id
    int count
    User createdBy
    String name
    Visibility visibility
}
