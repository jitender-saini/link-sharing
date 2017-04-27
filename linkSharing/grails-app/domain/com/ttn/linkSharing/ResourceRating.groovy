package com.ttn.linkSharing

import java.sql.Date

class ResourceRating {

    Integer score
    User createdBy
    Resource resource
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user: User, resource: Resource]

    static constraints = {
        score nullable: false, blank: false, min: 1, max: 5
        createdBy nullable: false, blank: false
        resource nullable: false, blank: false, unique: "createdBy"
    }

    String toString() {
        return "${resource} ${user} ${score}"
    }
}
