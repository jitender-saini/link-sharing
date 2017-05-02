package com.ttn.linksharing

import com.ttn.linkSharing.DocumentResource
import com.ttn.linkSharing.LinkResource
import com.ttn.linkSharing.ReadingItem
import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.ResourceRating
import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.User
import com.ttn.linkSharing.enums.Seriousness
import com.ttn.linkSharing.enums.Visibility

class BootStrap {

    def init = { servletContext ->
        createUser()
        createTopics()
        resources()
        subscribeTopics()
        addReadItems()
        addRating()
    }

    void createUser() {
        if (User.count() == 0) {
            User adminUser = new User(userName: "jaysaini", firstName: "Jay", lastName: "Saini", password: "delete", email: "jitender.saini@ttn.com",
                    isActive: true, isAdmin: true, dateCreated: new Date(), lastUpdated: new Date())

            User user = new User(userName: "sam123", firstName: "Sam", lastName: "Saini", password: "delete", email: "sam@ttn.com",
                    isActive: true, isAdmin: false, dateCreated: new Date(), lastUpdated: new Date())

//        adminUser.save(flush:true,failOnError : true)
//        user.save(flush:true,failOnError : true)

            adminUser.save(flush: true)
            user.save(flush: true)

            if (adminUser.hasErrors()) {
                log.error(adminUser.errors.allErrors)
                log.error(user.errors.allErrors)
            } else {
                log.info("Admin user created")
                log.info("User created")
            }
        }
    }

    void createTopics() {
        if (Topic.count() == 0) {
            def topicName = ['Groovy', 'Grails', 'Java', 'Spring', 'BootStrap']
            5.times {
                Topic topic = new Topic(topicTitle: "${topicName[it]}", description: "programing language",
                        visibility: Visibility.PUBLIC, createdBy: User.get(1))
                topic.save(flush: true)
                if (topic.hasErrors())
                    log.error topic.errors.allErrors
                else log.info "Topic: ${topic.topicTitle} is created by ${User.get(1) userName}"

                Topic topic2 = new Topic(topicTitle: "${topicName[it]}", description: "programing language",
                        visibility: Visibility.PUBLIC, createdBy: User.get(2))
                topic2.save(flush: true)
                if (topic2.hasErrors())
                    log.error topic2.errors.allErrors
                else log.info "Topic: ${topic2.topicTitle} is created by ${User.get(2) userName}"
            }
        }
    }

    void createResources(User user, Topic topic) {
        def topicName = ['Groovy', 'Grails', 'Java', 'Spring', 'BootStrap']
        def linkResourceList = ['http://groovy-lang.org/', 'http://grails.asia/', 'http://oracle.com/', 'http://spring.com/', 'http://bootstrap.com/']
        def documentResourceList = ['https://www.tutorialspoint.com/groovy/groovy_tutorial.pdf', 'http://grails.asia/grails.pdf', 'http://oracle.com/jdk.tar', 'http://spring.com/sts.tar', 'http://bootstrap.com/css.zip']
        def description = 'Required tools'
        2.times {
            Resource linkResource = new LinkResource(url: linkResourceList[it], description: "${topicName[it]} : ${description}",
                    createdBy: user, topic: topic)
            Resource documentResource = new DocumentResource(filePath: documentResourceList[it], description: "${topicName[it]} : ${description}",
                    createdBy: user, topic: topic)
            linkResource.save(flush: true)
            documentResource.save(flush: true)

            if (linkResource.hasErrors())
                log.error linkResource.errors.allErrors
            else if (documentResource.hasErrors())
                log.error documentResource.errors.allErrors
            else log.info "Resource created by ${user.userName} for topic ${topic.topicTitle} "
        }
    }

    void resources() {
        if (Resource.count() == 0) {
            for (int i = 1; i < 3; i++) {
                User user = User.get(i)
                def topic = Topic.findAllByCreatedBy(user)
                topic.each {
                    createResources(user, it)
                }
            }
        }
    }

    void subscribeTopics() {
        for (int i = 1; i < 3; i++) {
            (1..Topic.count()).each {
                if (Subscription.countByTopicAndUser(Topic.get(it), User.get(i)) == 0) {
                    Subscription subscribe = new Subscription(user: User.get(i), topic: Topic.get(it), seriousness: Seriousness.CASUAL)
                    subscribe.save(flush: true)
                    if (subscribe.hasErrors())
                        log.error(subscribe.errors.allErrors)
                    else log.info "${User.get(i).userName} has subscribed ${Topic.get(it).topicTitle}"
                } else
                    log.info "Subscription already exist"
            }
        }
    }

    void createReadingItems(User user, Resource resource) {
        ReadingItem readingItem = new ReadingItem(user: user, resource: resource, isRead: true)
        readingItem.save(flush: true)
        if (readingItem.hasErrors())
            log.error readingItem.errors.allErrors
        else
            log.info "User ${user.userName} has read resource"
    }

    void addReadItems() {
        1..(Subscription.count()).each {
            Subscription subscription = Subscription.get(it)
            if (subscription.user != subscription.topic.createdBy) {
                List<Resource> recourseList = Resource.findAllByTopic(subscription.topic)
                recourseList.each {
                    createReadingItems(subscription.user, it)
                }
            }
        }
    }

    void createRatings(User user, Resource resource, int score) {
        ResourceRating rating = new ResourceRating(createdBy: user, resource: resource, score: score)
        rating.save(flush: true)
        if(rating.hasErrors())
            log.error(rating.errors.allErrors)
        else
            log.info "User ${user.userName} Added $score Rating to resource "
    }

    void addRating() {
        def readingItem = ReadingItem.findAllByIsRead(true)

        readingItem.each {
            createRatings(it.user,it.resource,3)
        }
    }

    def destroy = {
        log.info("Closing application")
    }
}
