package com.ttn.linkSharing

import javassist.bytecode.ByteArray

class User {

    String userName
    String firstName
    String lastName
    String password
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
    }

    static mapping = {
        profilePic sqlType: 'longblob'
    }

    String getName() {
        return firstName + lastName
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                '}'
    }
}
