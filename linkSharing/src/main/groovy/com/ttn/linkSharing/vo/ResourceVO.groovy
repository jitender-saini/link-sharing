package com.ttn.linkSharing.vo

import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.User

class ResourceVO {
    String description
    User createdBy
    Topic topic
    String filePath
    String url
    boolean isLinkResource
}
