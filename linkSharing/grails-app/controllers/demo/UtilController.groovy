package demo

import grails.async.Promises
import groovyx.gpars.dataflow.Promise
import org.springframework.web.multipart.MultipartFile

class UtilController {
    static defaultAction = "list"

    def index() {
        log.info "Info log"
        log.error "Error log"
        log.warn "Warning level"
        log.info "action:$actionName -> $params"
        render "I got the following name:  ${params.name}"
    }

    def paramsUsage() {
        render "I got the following name: ${params.name}"
    }
    def list = {
        List<Author> authors = Author.createCriteria().list {
            or {
                between("age", 18, 60)
                eq("firstName", "Jay")
            }
        }
        render "result -> ${authors.size()} ${authors.firstName} ${authors.age}"
    }

    def listPagination = {
        List<Author> authors
        authors = Author.createCriteria().list(max: 10, offset: 0) {
            ilike("firstName", "jay%")
            between("age", 18, 60)
        }
        render "result -> ${authors.size()} ${authors.id} authorName ${authors.firstName}"
        Integer totalCount = authors.totalCount
        render "</br> total count -> "
        render totalCount
    }

    def listDistinct = {
        List<Author> authors = Author.createCriteria().listDistinct {
            ilike("firstName", "Jay%")
            le("age", 50)
            order("firstName", "desc")
        }
        render "result -> ${authors.size()} ${authors.firstName}"
    }

    def listCount = {
        List<Author> authors = Author.createCriteria().listDistinct {
            and {
                ilike("firstName", "Jay%")
                between("age", 18, 60)
            }
        }
        render "result -> ${authors.size()} ${authors.firstName} ${authors.age}}"
    }

    def not = {
        List<Author> authors = Author.createCriteria().listDistinct {
            not {
                between("age", 10, 30)
            }
        }
        render " result ${authors.firstName} ${authors.age}"

    }

    def property(){
        def dates = Author.createCriteria().list {
            projections {
                property("title")
                'author' {
                    property('dateCreated')
                }
            }
        }
        render "result -> ${dates}"
    }

//    def projections = {
//        Integer ageSum = Author.createCriteria().get() {
//            projections {
//                sum("age")
//            }
//            le("age", 20)
//        }
//        render "result -> age sum = ${ageSum}"
//    }

    def groupProperty = {
        List result = Book.createCriteria().list {
            projections {
                groupProperty("title")
                sum("author.id")
                rowCount()
            }
        }
        render "result -> ${result}"
    }

    def executeQuery() {
        Integer age = 19
        List authorInfo = Author.executeQuery("select a.firstName, a.lastName from Author as a where age >:age", [age: age])
        render "result -> ${authorInfo}"
    }

    def executeUpdate() {
        Author author = Author.get(1)
        String firstName = author.firstName
        Author.executeUpdate("update Author as a set a.firstName =:firstName where a.id=:id", [firstName: "updated", id: 1.toLong()])
        render "firstName Before ${firstName}  || firstName after update ${author.firstName}"
    }

    def namedQuery = {
        Date date = new Date()
        List<Author> author = Author.recentAuthors(date).list()
        render "list of author -> ${author}"
    }

    def namedQueryAge = {
        Integer age = 20
        def author = Author.adultAuthor(age).list()
        render "list of author -> ${author}"
    }


    //Controller 2

    def personSet(){
        Author author = new Author(name: params.name,age: params.age)
        render author.properties
    }

    def personParam(String name,int age){
        Author author = new Author(name: name,age: age)
        render author.properties
    }

    def personBind(){
        Author author = new Author()
        bindData(author,params,[exclude:['age'],include:['name']])
        render author.properties
    }

    def authorCo(AuthorCO authorCO){
        if(authorCO.hasErrors())
            render authorCO.errors.getFieldError()
        else
        render authorCO.firstName
    }

    def Upload(){
        MultipartFile file =params.myfile
        render file.dump()
//        render file.inputSream.text
    }

    def download(){
        byte[] bytes = new File("/home/jitender/Desktop/file.txt").bytes
        response.setHeader("Content-Disposition", "attachment;filename=abc.txt")
        response.setContentType("text/plain")
        response.outputStream << bytes
    }

    def respond(){
        AuthorCO authorCO = new AuthorCO(firstName: "jay",lastName: "saini",age: 22)
        respond authorCO, [formats:['xml', 'json']]
    }

    def asyncReso(){
        println "hello"
        Promises.task {
            render "Async"
        }
        println "hello2"
    }
}
