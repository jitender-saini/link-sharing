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

13. Read config properties from external config and use BootStrap.groovy for verifying properties are actually 
    read from external config
    created new file app-config.yml in root directory of the project 
    and added database property in this file
    in build.gradle file add 
    bootRun{ 
    jvmArgs = ['-Dlocal.config.location=app-config.yml']
    }
    
[************************************************************************************************************************************]
Exercise Domain1

1. Add User domain class with fields as mentioned by requirement doc
2. Add following constraints
    Email should be unique, email type, not null, not blank
    Password should be not null, not blank and minimum 5 characters
    FirstName,LastName should not be null and not blank
    Photo, Admin and Active field can be null
    Write test cases for validating user (including username and email uniqueness)
3. Add topic domain and its fields with following constraints:
    Topic name should be not null, not blank, unique per user
    Visibility should be enum and should not be null
    Created by should not be null 
    Write test cases for validating topic
4. Add subscription domain and seriousness enum.Add following constraints:
    User,topic, seriousness should not be null
    User should not be able to subscribe to topic multiple times 
    Write test cases for validating subscription domain
5. Add Resource abstract domain as parent class and 2 child classes Document Resource domain and Link Resource domain
6. Resource should have createdBy, description and topic
7. Document resource should have filepath
8. Description of resource should be of text type
9. Link Resource should have valid url
10. Add test cases for link resource and document resource domains
11. Add resource rating domain with following constraints:
    Resource rating should not have null createdBy, score, resource
    Resource score should not be more than 5 and less than 1
    ResourceRating can be given by a user only one time for a resource
    Write test cases for validating resource rating domain
12. Add ReadingItem domain for user reading items with constraints: -
    User,isRead and resource cannot be null for readingItem
    ReadingItem resource should be unique per user
    Write test cases for validating readingItem domain
13. Add transient of getFullName in user domain and update test cases accordingly
14. Change data type of photo in user as longblob
15. Add dateCreated and lastUpdated in all domains
16. Define relationships between domain classes: -
    User hasMany topics,subscriptions,readingItems and resources -
    Topic hasMay subscriptions and resources
    Resource hasMany ratings and readingItems


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
12. Add createResources method which create 2 link resource and 2 document resource in each topic       x
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

[************************************************************************************************************************************]
Exercise Controller1

1. Add loginController with index,loginHandler and logout action
2. LoginController index action will check if there is session.user exists or not if exist forward to user controller 
   index action else render failure
3. Add User controller with index action that will render text 'user dashboard'
4. Login Controller logout action will do session.invalidate and forward the request to login controller index action
5. LoginController loginHandler action will take 2 argument username and password
6. If LoginHandler action finds user with given username and password then it will check user active or not if active 
   set session.user to user and redirect request to login index action
7. If user is not active then set flash.error 'Your account is not active'
8. If user is not found then flash.error is set to 'User not found' and flash.error is rendered - Urlmapping is updated 
   for / action to controller login action index
9. Delete existing index.gsp file Added test cases for login controller
10. That should include testing of all conditions specified in above exercise 
11. Add Application Interceptor with logging params for all controller and actions
12. Add session check filter in application interceptor
13. Create loginCheck interceptor which will work all the controller except login
14. If session.user is not set then redirect user to login index, this should be done in interceptor - user index action 
    should render session user username
15. Update test case for userController index action Add show action for topic which will take id as a parameter
16. If topic do not exist in database then user should redirected to login index action and flash error should be set
17. If topic found and its a public topic then it should render success
18. If topic found is private then check the subscription of logged in user exist for the topic or not
19. If subscription exist then render success otherwise redirect user to login index and set flash error
20. Write test case for the same Adde validator and transient field for confirmPassword -Confirm password will be nullable 
    true and blank true when user is updating but when its getting created it should match password and it cannot be null
21. Update bootstrap for user creation Create register action in login controller to register user
22. Errors with proper message properties should be rendered if user is not set and flash message should be set.
23. If user is set the success should be rendered - Validation message should be on email(null,blank,email,unique), 
    username(null,blank,unique), firstName(null,blank), lastName (null,blank), password(null,blank,minsize), confirmPassword (null,blank,customvalidator)
24. Render validation errors using message tag No need to create UI for this just send the parameter through url.