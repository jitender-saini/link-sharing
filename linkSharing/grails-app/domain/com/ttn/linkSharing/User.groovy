package com.ttn.linkSharing


class User {

    String userName
    String firstName
    String lastName
    String password
    String confirmPassword
    String email
    byte[] profilePic
    Boolean isAdmin = false
    Boolean isActive = true
    Date dateCreated
    Date lastUpdated

    static hasMany = [topic: Topic, resource: Resource, subscription: Subscription, resourceRating: ResourceRating, readingItem: ReadingItem]

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
    static transients = ['fullName', 'confirmPassword', 'getSubscribedTopic']

    String getFullName() {
        return "${firstName}  ${lastName}"
    }

    String toString() {
        return "User -> userName: ${userName} isAdmin: ${isAdmin}  email: ${email}"
    }

    static List getSubscribedTopic(User user) {
        List list = createCriteria().list() {
            projections {
                createAlias('subscription', 's')
                property('s.topic')
            }
            eq('s.user', user)
        }
        return list
    }

    static boolean isSubscribed(User user, Long topicId) {
        Subscription subscription = Subscription.findByUserAndTopic(user, Topic.read(topicId))
        if (subscription) {
            println "$subscription ++++++++++++++++++++++++++="
            return true
        }
        return false
    }

    static int getSubscriptionCount(User user) {
        int count = Subscription.countByUser(user)
        return count
    }

    static int getTopicCount(User user) {
        int count = Topic.countByCreatedBy(user)
        return count
    }

//    ReadingItem getUnReadResources(SearchCO searchCO) {
//
//    }
}
