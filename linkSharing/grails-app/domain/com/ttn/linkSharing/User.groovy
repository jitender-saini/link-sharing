package com.ttn.linkSharing

import com.ttn.linkSharing.co.SearchCO

class User {

    String userName
    String firstName
    String lastName
    String password
    String confirmPassword
    String email
    File profilePic
    Boolean isAdmin = false
    Boolean isActive = true
    Date dateCreated
    Date lastUpdated

    static hasMany = [topic: Topic, resource: Resource, subscription: Subscription, resourceRating: ResourceRating, readItem: ReadingItem]

    static constraints = {
        userName nullable: false, blank: false, unique: true, size: 3..20
        firstName nullable: false, blank: false
        lastName nullable: false, blank: false
        password nullable: false, blank: false, size: 4..20, validator: { val, user ->
            if (!user.id)
                user.confirmPassword == val
        }
        email nullable: false, blank: false, unique: true, email: true
        profilePic nullable: true, blank: true
        isAdmin nullable: true, blank: true
        isActive nullable: true, blank: true
        confirmPassword nullable: true, blank: true
    }

    static mapping = {
        profilePic sqlType: 'longblob'
        sort id: "desc"
    }
    static transients = ['fullName', 'confirmPassword']

    String getFullName() {
        return "${firstName}  ${lastName}"
    }

    String toString() {
        return "User -> userName: ${userName} isAdmin: ${isAdmin}  email: ${email}"
    }

    ReadingItem getUnReadResources(SearchCO searchCO){


    }
}
