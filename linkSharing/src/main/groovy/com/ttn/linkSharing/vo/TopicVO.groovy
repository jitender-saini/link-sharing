package com.ttn.linkSharing.vo

import com.ttn.linkSharing.User
import com.ttn.linkSharing.enums.Visibility

class TopicVO {
    Integer id
    String name
    Visibility visibility
    Integer count
    User createdBy
}
