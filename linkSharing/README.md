1. Create basic grails app (linksharing) and add .gitignore files for excluding files from git
2. Change default package of grails app in application.yml
    default package can be change in application.yml file 
        grails:
            profile: web
            codegen:
                defaultPackage: linkSharing
                
                
3. Use mysql as database in your application
    In application.yml changed dialect property of 
    dataSource:
        Dialect : org.hibernate.dialect.MySQL5InnoDBDialect
       
4. Use mysql jar in build.gradle 
    added dependency in build.gradle
            compile group: 'mysql', name: 'mysql-connector-java', version: '5.1.27'

5. Update database drive class name in application.yml
    In application.yml change the property of driverClassName value with mysql driver
    dataSource:
        driverClassName: com.mysql.jdbc.Driver
        
6. Create database with name linksharing
    In mysql 
    create database linkSharing
     
7. Update dbcreate property to update mode
    In application.yml change the property of dbCreate
    environments:
        development:
            dataSource:
                dbCreate: create-drop
                
                
8. Update username password and database connection url according to the system
    In application.yml change the property of username and password
    dataSource:
        username: root
        password: delete

9. Add index action in util controller and use different logging levels
    index action is added in util controller
    
10. Updated logging and pattern in logback.groovy
    added the below line in logback.groovy
        logger('grails.app', INFO, ['STDOUT'],false)

    
11. Added log statements of params in utilController index action
    

12. Add app context to / to remove app name in url
    added the below code in app-config.yml
        grails:
            app:
            context: /

13. Read config properties from external config and use BootStrap.groovy for verifying properties are actually read from external config
    created new file app-config.yml in root directory of the project 
    and added database property in this file
    in build.gradle file add 
    bootRun{ 
    jvmArgs = ['-Dlocal.config.location=app-config.yml']
    }
    
[************************************************************************************************************************************]
Exercise GORM1

1. Add createUsers method to Bootstrap to create 1 admin and 1 normal user.
2. Use failOnError and flush true for persisting users
3. Use log info statements for data creation and log error if there are any errors
4. Users will be created only when there are no records in user table
5. Add constants file for default password
6. Add createTopics method in bootstrap
7. 5 topics per user needs to be created if Topic count is 0
8. Creator of topic should automatically be subscribed to topic (Use after insert event of topic)
9. Errors should be logged if topic or subscriptions is not saved
10. WithNewSession in after insert because it will not work without it
11. Seriousness should be very serious for auto subscribed topic in after insert
12. Add createResources method which create 2 link resource and 2 document resource in each topic
13. It should create resource only if there is not data in resource table
14. Description of the resource should include topic name
15. Error should be logged
16. Creator of the resource should be same as creator of the topic
17. Add subscribeTopics for user to subscribe all the topics which are not created by user
18. Subscription should be created only if the subscription do not exit for user and topic 
19. Errors should be logged
20. log statement when subscription is created with user and topic object
21. toString should be implemented for Topic with topic name and for User with username
22. Add createReadingItems in bootstrap to create dummy reading items
23. Resources which are not created by the user in the topics subscribed by him/her should have in his/her reading item.
24. Reading item of resource should be created only if it does not already exit in users reading item
25. Add createResourceRatings to add dummy ratings
26. Add rating for all the unread reading items of the user
27. createdBy of resourceRating should be createdBy of reading item and resource of resourceRating 
        should be resource of readingItem
28. Add test cases for toString of Topic and User
29. Add toString for linkResource with url
30. Add test case for document resource and linkResource toString