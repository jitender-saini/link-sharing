Intro to grails app
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
     in util controller 
     log.info "action:$actionName -> $params" 
   
12. Add app context to / to remove app name in url
    added the below code in app-config.yml
        server:
            contextPath: /linksharing

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
    [ In bootstrap.groovy file createUser() is created ]
2. Use failOnError and flush true for persisting users
    [line no 36/37 in bootstrap.groovy]
3. Use log info statements for data creation and log error if there are any errors
    [line 42-48 logs added]
4. Users will be created only when there are no records in user table
    [line no 29]
5. Add constants file for default password
    [ constant.groovy file is added in src/main/groovy]
6. Add createTopics method in bootstrap
    [line no 53]
7. 5 topics per user needs to be created if Topic count is 0
        [line no 56]
8. Creator of topic should automatically be subscribed to topic (Use after insert event of topic)
    [In Topic domain afterInsert is added ]
9. Errors should be logged if topic or subscriptions is not saved
    [ line 60]
10. WithNewSession in after insert because it will not work without it
    [ withNewSession is added in Topic domain line no 27]
11. Seriousness should be very serious for auto subscribed topic in after insert
    [ in Topic domain line no 28]
12. Add createResources method which create 2 link resource and 2 document resource in each topic       x
    [ in bootstrap line - 74 method createResource()]
13. It should create resource only if there is not data in resource table
    [ in bootstrap line - 96 ]
14. Description of the resource should include topic name
    [ in bootstrap line - 75 ]
15. Error should be logged
16. Creator of the resource should be same as creator of the topic
    [line -95 addResource()]
17. Add subscribeTopics for user to subscribe all the topics which are not created by user
    [line-107 subscribeTopics]
18. Subscription should be created only if the subscription do not exit for user and topic
    [line 110]
19. Errors should be logged
20. log statement when subscription is created with user and topic object
    [line 115]
21. toString should be implemented for Topic with topic name and for User with username
    [toString() added in Topic domain]
22. Add createReadingItems in bootstrap to create dummy reading items
    [line 122 createReadingItems()]
23. Resources which are not created by the user in the topics subscribed by him/her should have in his/her reading item.
    [line 131 addReadItems()]
24. Reading item of resource should be created only if it does not already exit in users reading item
    [line 134]
25. Add createResourceRatings to add dummy ratings
    [line 143 createRatings()]
26. Add rating for all the unread reading items of the user
    [line 152 addRating()]
27. createdBy of resourceRating should be createdBy of reading item and resource of resourceRating should be resource of readingItem
    [line 152 addRating()]
28. Add test cases for toString of Topic and User
    [ test cases added in TopicSpec and UserSpec]
29. Add toString for linkResource with url
    [ added toString in linkResources]
30. Add test case for document resource and linkResource toString
    [added test cases in DocumentResourceSpec & LinkResourceSpec]

[************************************************************************************************************************************]
Exercise Controller1

1. Add loginController with index,loginHandler and logout action
    [loginController added ]
2. LoginController index action will check if there is session.user exists or not if exist forward to user controller 
   index action else render failure
   [ LoginController in index action this code is added ]
        if (session.user)
                    forward(controller: "user", action: "index")
                else
                    render "Failure"
        
3. Add User controller with index action that will render text 'user dashboard'
    [UserController Added]
    
4. Login Controller logout action will do session.invalidate and forward the request to login controller index action
    [In logout action this code is added]
        def logout() {
                session.invalidate()
                forward(controller: "login", action: "index")
            }
            
5. LoginController loginHandler action will take 2 argument username and password
    [ added 2 argument in loginHandler]
    
6. If LoginHandler action finds user with given username and password then it will check user active or not if active 
   set session.user to user and redirect request to login index action
   [ ]
7. If user is not active then set flash.error 'Your account is not active'
    [ in loginHandler ]
        render flash.error = "Your account is not active"
8. If user is not found then flash.error is set to 'User not found' and flash.error is rendered - UrlMapping is updated 
   for / action to controller login action index
    [ in UrlMapping this line is added in static mapping->     "/"(controller: "login",action: "index")  ]
    
9. Delete existing index.gsp file Added test cases for login controller
    [index.gsp file is deleted from views]
    
10. That should include testing of all conditions specified in above exercise
    
11. Add Application Interceptor with logging params for all controller and actions
    [ created ApplicationInterceptor and in after block log added ->    log.info "action:$actionName -> $params"]
    
12. Add session check filter in application interceptor
    [in ApplicationInterceptor filter added]
        boolean before() {
                if(!(session['user'])){
                    redirect(controller:"login",action:"index")
                    false
                }
                else true
            }
            
13. Create loginCheck interceptor which will work all the controller except login
     [ in the constructor of ApplicationInterceptor it is added
      matchAll().excludes(controller: 'login')]
      
14. If session.user is not set then redirect user to login index, this should be done in interceptor - user index action 
    should render session user username
      [ in LoginController added interceptor before ]
        boolean before() {
                if(!(session['user'])){
                    redirect(controller:"login",action:"index")
                    false
                }
                else true
            }
            
15. Update test case for userController index action Add show action for topic which will take id as a parameter

16. If topic do not exist in database then user should redirected to login index action and flash error should be set
    [ TopicController is created and showTopic() is added in it]
    
17. If topic found and its a public topic then it should render success
    [ showTopic() in TopicController ]
    
18. If topic found is private then check the subscription of logged in user exist for the topic or not
    [ showTopic() in TopicController ]
    
19. If subscription exist then render success otherwise redirect user to login index and set flash error
    [ showTopic() in TopicController ]

20. Write test case for the same Adde validator and transient field for confirmPassword -Confirm password will be nullable 
    true and blank true when user is updating but when its getting created it should match password and it cannot be null
    
21. Update bootstrap for user creation Create action in login controller to register user
      [ in bootstrap userCreate() is updated for confirm password]

22. Errors with proper message properties should be rendered if user is not set and flash message should be set.
    [ flash message is set ]

23. If user is set the success should be rendered - Validation message should be on email(null,blank,email,unique), 
    username(null,blank,unique), firstName(null,blank), lastName (null,blank), password(null,blank,minsize), confirmPassword (null,blank,customValidator)
    
    
24. Render validation errors using message tag No need to create UI for this just send the parameter through url.

[************************************************************************************************************************************]

Exercise Domain 2 

1. Add default sorting: - Topic domain should be default sorted by name asc
    [In Topic domain sorting is added in static mapping block]
2. User should be default sorted by the id desc so that latest created user comes first
3. Use read() for /topic/show and load() for /resource/delete action.
4. Exception of object not found should be handled in resource delete
5. Add topic save action in TopicController
6. Add save action in topic controller, which takes a topic and string seriousness as an argument
7. Create a method in visibility enum to convert string into enum and write test case for the same
8. Session user should be createdBy of the topic
9. If a topic is saved without error flash message should be set and success should be rendered
10. If a topic is not saved errors should be logged flash error should be set and error text should be rendered
11. Write the test case for the Topic save.
12. Write a test case for topic deletion.
13. Subscription domain should have a default seriousness as Serious.
14. Implement subscription save, update, delete
15. Create subscription delete action which takes id as parameter, if it exist then delete and send success else render not found
16. Create save action which takes id as parameter for topic id, user for subscription should be read from the session, if subscription save render success else errors -
17. Create update action which takes an id and serious as a parameter if subscription and seriousness found, then save else render not found, if saved then render success else errors
18. Create static method in seriousness which take string as parameter and returns seriousness, it should be case insensitive
19. Write the test cases for subscription save, update, delete functionality.
20. Use eager fetching for topic and user in subscription

[************************************************************************************************************************************]
Exercise GORM2

1. Add search named query for resources.
    - Add String q, Integer max,Integer offset,String order, String sort parameter in searchCO which will be used for text search
    - Create ResourceSearchCo which extend searchCO and add topicId long field into it to get resource specific to topic
    - Create named query 'search' which takes ResourceSearchCO as argument and find resources specific to topic id.
    - Update topic show action which will take ResourceSearchCO as an argument other than long id
2. Add resource/search action for resource search in public topics
    - Update ResourceSearchCO and add visibility field in it
    - Updated Resource search named query and add condition to search topic with specified visibility
    - Add search action in a resource controller, which will search if q parameter is set and it will set visibility of resourcesearchco to public
3. Create method in resource to get rating details like totalVotes, avgScore, totalScore of a resource
    - Create transient in resource ratingInfo and create method which will return RatingInfoVO
    - RatingInfoVO will have fields totalVotes, averageScore, totalScore
    - Write criteria query to get the above information.
    - Call this method from resource show action
4. Add resource show action and get trending topics also
    - Public Topic with maximum resources is considered as a trending topic
    - Create static method getTrendingTopics in Topic domain which will return list of TopicVO
    - TopicVO will have id,name,visibility,count,createdBy fields
    - Use createAlias and groupProperty in criteria
    - Use count for getting count of resources of a topic
    - Use multiple order statement first one ordered by resource count and second one ordered by topic name
    -Maximum 5 records should be shown
    - Topic with maximum resource should come first
5. Add top post when user is not logged in
    - Resource with maximum number of votes will be top post
    - Only 5 posts should be shown in order of maximum vote count
    - Use groupProperty with id of resource otherwise lots of queries will be fired
    - Collect Resource list with resource id using getAll rather then finder otherwise ordering will not be maintained
6. Add Inbox feature on user/index when user is loggedIn
    - Create method getUnReadResources in user domain which takes SearchCO argument and returns unreaditems of user from ReadingItem domain
    - The search should also work using user/index page, q parameter of SearchCO. If searchco.q is found then getUnReadResources method will search the items based on ilike of resource.description.
    - The pagination parameter should also be used in getUnReadResources criteria query. Create readingItem/changeIsRead action which takes Long id and Boolean isRead
    - User executeUpdate to change the isRead of readingItem with given id
    - If value returned by executeUpdate is 0 then render error else render success
7. Write integration tests where criteria and hql queries are used
    - Create linkSharing_test database for testing, which should be used in a testing environment.
    
[************************************************************************************************************************************]

Exercise -> Controller2

1. Update interceptor and user should be able to access all the actions except those which require session user
2. Few actions which requires session users are /linkResource/save, readingItem/save, resource/delete, resourceRating/save, subscription controller, topic/save, /user/index
3. Update resource/_show template to show edit link only if user is logged in
4. Update topic/_show template to show drop downs and links only if user is logged in
5. Display user image on user/_show, resource/_show, topic/_show (all the places where user image are showing)
6. Create tag userImage which will take userId as a parameter and creates img tag with src of /user/image/id and add all other parameters to img tag like width, height
7. Update all the default user.png image with tag and add widht height to 64
8. Create action user/image which will take long id and gets User from id, if user has uploaded photo then that photo will be rendered else dummy user image will show
9. Use assetResourceLocator bean of asset pipeline plugin to get dummy image
10. Create test case for new tag and action, need to know the mocking of service in controller
11. Create register action in user controller to register user
12. Errors with proper message properties should be rendered if user is not set and flash message should be set
13. If user is set the success should be rendered -
14. Validation message should be on email(null,blank,email,unique),username(null,blank,unique), firstName(null,blank), lastName (null,blank),password(null,blank,minsize), confirmPassword(null,blank,customvalidator) message tag should be explained by rendering validation errors using message tag
15. If there are any errors, then registration form should be refilled with pervious values and errors on each field should be displayed
16. If the user is registered successfully, then it needs to be set in the session and logged in to the system
17. renderErrors, hasErrors, fieldError tag should be used Implement documentResource save and download document
18. Create save action in LinkResourceController and update linkResource/_create template to save data through the new action
19. Create config property linksharing.documents.folderPath = /var/www/linksharing to store files
20. Create contentType as transient property in DocumentResource and add validator to validate that contenttype is present when object is creating and it should be application/pdf and while updating if contenttype is set then it should be application/pdf
21. Create constant DOCUMENT_CONTENT_TYPE for application/pdf
22. Create fileName transient to get name of the file
23. Each file will have a uuid as file name and content type will be set in save action and if object is saved then file will be written to file system
24. Mark save action as transactional
25. Once the resource is created then it will be added to readingitem of all the user subscribed topic and isRead will be true for creator of the resource
26. Extend LinkResourceController and DocumentResourceController with ResourceController add protected method addToReadingItems which take resource as parameter and creates ReadingItems for all subscribed user of resource topic, this method will be called in LinkResourceController save action and DocumentResourceController save action after save is successful
27. addToReadingItems method will use async controller method to save readingitems asynchronously
28. Update message properties for validation messages
29. Create deleteFile method in Resource.groovy which will just logs message that this will be implemented in linkresource
30. Override deleteFile method in DocumentResource.groovy to delete the file and call this method in ResourceController delete action after delete is called
31. Create download action in DocumentResource to download the file, action takes id as parameter and shows resource not found if resource doesn't exist or resource is not accessible by logged in user else it download the file if its present
32. Resource can be downloaded only if the resource is accessible by user i.e; either admin or created by user or topic of user subscribed by user or topic is public (ideally it should use topic canViewedBy method, same will be used in resource show action as well)
33. Create test cases for new functionlities and update bootstrap as well
34. Implement marking resource isRead with json response - [message: 'Status changed successfully'] should be rendered if status changed successfully - [error: 'Error while updating status'] should be rendered if status is not updated successfully
35. Update the test cases and use response.json to validate response
36. Update the test cases as well
37. Implement 404 and 500 page of the application

[************************************************************************************************************************************]

Grails Views

1. Add application layout
2. Application layout should use bootstrap and font awesome
3. All the previous unused files of css, images, js should be removed and only required files should be committed
4. Single js and single js file should be included using asset tag other css and js sould be included in main js, as per the syntex of asset pipeline
5. All the static resource should be in assets folder, no need to add jquery as this plugin is already added in grails BuildConfig by default
6. Update layout main.gsp according to the document mentioned in intro to linksharing, add flash message and flash error in layout by using g:if tag
7. Add templates topic/create topic/email linkResource/create documentResource/create and include them in layout which will be opened in modal window by clicking on header links. These links and templates are added only when user is logged in
8. Implement topic/save and linkresource/save save action. Topic, linkresource save should set errors in flash and user should redirected to the dashboard, successful save should set flash.message.
9. Login should work from login form on home page and show top posts and recent post on home page
10. Create templates for resource/show topic/show user/login user/register
11. Create static method in topic to get trending topic which will be used on user dashboard as well as resource show action
12. Add createdBy in topicVO so that createdBy can be shown in trending topic list on UI
13. Create transient method in user domain getSubscribedTopic to get only subscribed topics of user, this method will be used in user dashboard and dropdown of linkresource create and email invite of topic
14. Add /user/forgotPassword template which will show up on click on forgotPassword link in login form
15. Update test cases accordingly
16. Tags which will be used for this are layouthead, layoutbody, layouttitle, select, if, else, render, message, asset:javascript,stylesheet, actionsubmit, form, filed, each, img, paginate, uploadform
17. Implement Topic show page
18. Create transient method getSubscribedUsers in topic domain to get all the subscribed users
19. Create user/_show template from user index page which take user as model and use this template to show subscribed user list in topic show page and user index page
20. Change links on subscriptions and posts in topic/_show template to topic show action
21. Implement search on posts header of topic show pass topic id as hidden field in form and also pass it in pagination parameters
22. Update test cases with new changes

[************************************************************************************************************************************]

Grails Taglib

1. Add search page for resources and create linksharing taglib with ls namespace
2. Create tag for showing mark as read link, it should be visible only to logged in user and if there is reading item added for the user  
3. If the resource is read, then mark as unread should appear else mark as read should appear, this should only appear if user is logged in
4. Create tag to show trending topics and top post which will take no argument and shows the whole template of trending topics and top post
5. Replace trending topics and top posts on login index page and add them to search page as well
6. Flash error should set in search action if the search criteria not given
7. markasread tag should be used in resource/_show template which will take resource as argument and user from session
8. Update changeIsRead action of readingitem controller, now it will take resourceId as argument and user from session update the query accordingly
9. Create static methog getTopPosts in Resource domain and update the usages accordingly
10. Create testcase for linksharingtaglib and update the existing failing test cases as well
11. Add resource show page and implement its rating and delete actions
12. Create method in resource domain to find resource is linkresource or document, use method to show download or view full site links
13. If resource is link resoure then it should open the url in new window, download will be implemented later
14. Create tag canDeleteResource to check session user can delete resource or not, create method in user canDeleteResource and use it in tag
15. In delete action as well use user canDeleteResource method to validate on server side as well, only admin and creator of resource can delete resource
16. Update resource delete action and redirect user on dashboard after delete and set flash messages
17. Create isPublic method in Topic to check whether topic is public or not
18. Create method in topic canViewedBy to verify whether user can view the topic or not, only public topic(use isPublic method) or the user subscribed to topic or admin can view the topic
19. Create canViewBy method in resource as well which will call its topic canViewedBy method to validate whether resource can be view by logged in user
20. Update show action in ResourceController and implement resource show page, use resource canViewedBy method to validate user access to resource
21. In resource show page add drop down of 1 to 5 points and vote button which will store the user vote to resource using resourcerating controller save action
22. Create getScore method in user which will return the score given by user to a resource, default value in resource show should be set to session user score (refer resource.png)
23. Update test cases for all the updated code Implement topic subscribe and unsubscribe
24. Create tag showSubscribe which will take topicId and shows the text with delete or save link only when topicId is given and user is logged in
25. Create method in user isSubscribed which takes long topic id and returns boolean, write criteria query
26. If user subscribed to topic then Un subscribe should be visible with subscrition delete action else Subscribe should be visible with save action link
27. Update delete and save action of subscription controller set flash error if subscription not found or not saved and set flash message if subscription deleted or saved properly
28. User is redirected to home page in delete and save actions
29. Write test cases for the code as well Show subscription count and post count on topic/_show and user subscription count and topic created count on user/index
30. Create tag subscriptionCount which will take user or topicid to show subscription count
31. Create tag resourceCount which will take topicId and shows resource count of that topic
32. Create tag topicCount which takes user and shows number of topics created by user
33. Create test cases for the tags and use these tags on pages

[************************************************************************************************************************************]
