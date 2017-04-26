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
        score nullable: false, blank: false, validator: {value, object->
            if(value<1 && value >6)
                return false
        }
        createdBy nullable: false, blank: false
        resource nullable: false, blank: false, unique: "createdBy"
    }

    String toString() {
        return "${resource} ${user} ${score}"
    }
}
