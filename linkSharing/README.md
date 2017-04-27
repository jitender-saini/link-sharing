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