package com.ttn.linkSharing

import java.sql.Date

class ReadingItem {

    User user
    Resource resource
    Boolean isRead = false
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user: User, resource: Resource]

    static constraints = {
        user nullable: false, blank: false
        resource nullable: false, blank: false, unique: "user"
        isRead nullable: false, blank: false
    }
}
