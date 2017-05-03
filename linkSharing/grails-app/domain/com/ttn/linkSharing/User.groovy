package com.ttn.linkSharing

import javassist.bytecode.ByteArray

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
        password nullable: false, blank: false, size: 4..20
        email nullable: false, blank: false, unique: true, email: true
        profilePic nullable: true, blank: true
        isAdmin nullable: true, blank: true
        isActive nullable: true, blank: true
        confirmPassword nullable: true, blank:true
    }

    static mapping = {
        profilePic sqlType: 'longblob'
        sort firstName:'asc'
    }
    static transients = ['fullName','confirmPassword']

    String getFullName() {
        return "${firstName}  ${lastName}"
    }

    String toString() {
        return "User -> userName: ${userName} isAdmin: ${isAdmin}  email: ${email}"
    }
}
