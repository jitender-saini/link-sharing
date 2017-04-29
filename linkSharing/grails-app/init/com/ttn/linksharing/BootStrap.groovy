package com.ttn.linksharing

import com.ttn.linkSharing.DocumentResource
import com.ttn.linkSharing.LinkResource
import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.Subscription
import com.ttn.linkSharing.Topic
import com.ttn.linkSharing.User
import com.ttn.linkSharing.enums.Seriousness
import com.ttn.linkSharing.enums.Visibility
import demo.Employee


class BootStrap {

    def init = { servletContext ->
        createUser()
        createTopics()
        resources()
        subscribeTopics()
    }

    void createUser() {
        // Exercise 4. Users will be created only when there are no records in user table
        if (User.count() == 0) {
            // Exercise 1. Add createUsers method to Bootstrap to create 1 admin and 1 normal user.
            User adminUser = new User(userName: "jaysaini", firstName: "Jay", lastName: "Saini", password: "delete", email: "jitender.saini@ttn.com",
                    isActive: true, isAdmin: true, dateCreated: new Date(), lastUpdated: new Date())

            User user = new User(userName: "sam123", firstName: "Sam", lastName: "Saini", password: "delete", email: "sam@ttn.com",
                    isActive: true, isAdmin: false, dateCreated: new Date(), lastUpdated: new Date())

            // Exercise 2. Use failOnError and flush true for persisting users
//        adminUser.save(flush:true,failOnError : true)
//        user.save(flush:true,failOnError : true)

            adminUser.save(flush: true)
            user.save(flush: true)

            // Exercise 3. Use log info statements for data creation and log error if there are any errors
            if (adminUser.hasErrors()) {
                log.error(adminUser.errors.allErrors)
                log.error(user.errors.allErrors)
            } else {
                log.info("Admin user created")
                log.info("User created")
            }
        }
    }

    // 6. Add createTopics method in bootstrap
    void createTopics() {
        // 7. 5 topics per user needs to be created if Topic count is 0
        if (Topic.count() == 0) {
            def topicName = ['Groovy', 'Grails', 'Java', 'Spring', 'BootStrap']
            5.times {
                Topic topic = new Topic(topicTitle: "${topicName[it]}", description: "programing language",
                        visibility: Visibility.PUBLIC, createdBy: User.get(1))
                topic.save(flush: true)
                if(topic.hasErrors())
                    log.error topic.errors.allErrors
                else log.info "Topic: ${topic.topicTitle} is created by ${User.get(1)userName}"

                Topic topic2 = new Topic(topicTitle: "${topicName[it]}", description: "programing language",
                        visibility: Visibility.PUBLIC, createdBy: User.get(2))
                topic2.save(flush: true)
                if(topic2.hasErrors())
                    log.error topic2.errors.allErrors
                else log.info "Topic: ${topic2.topicTitle} is created by ${User.get(2)userName}"
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
        for (int i = 1; i < 3; i++) {
            User user = User.get(i)
            def topic = Topic.findAllByCreatedBy(user)
            topic.each {
                createResources(user, it)
            }
        }
    }

    void subscribeTopics() {
        (1..10).each {
            if (it % 2 == 0) {
                if (Subscription.countByTopicAndUser(Topic.get(it), User.get(1)) == 0) {
                    Subscription subscribe = new Subscription(user: User.get(1), topic: Topic.get(it), seriousness: Seriousness.CASUAL)
                    subscribe.save(flush: true)
                    if (subscribe.hasErrors())
                        log.error(subscribe.errors.allErrors)
                    else log.info "${User.get(1).userName} has subscribed ${Topic.get(it).topicTitle}"
                } else
                    log.info "Subscription already exist"
            } else {
                if (Subscription.countByTopicAndUser(Topic.get(it), User.get(2)) == 0) {
                    Subscription subscribe = new Subscription(user: User.get(2), topic: Topic.get(it), seriousness: Seriousness.CASUAL)
                    subscribe.save(flush: true, failOnError: true)
                    subscribe.save(flush: true)
                    if (subscribe.hasErrors())
                        log.error(subscribe.errors.allErrors)
                    else log.info "${User.get(2).userName} has subscribed ${Topic.get(it).topicTitle}"
                } else
                    log.info "Subscription already exist"
            }
        }
    }

    def destroy = {
        log.info("Closing application")
    }
}
