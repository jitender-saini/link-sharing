package demo

class Book {

    String title
    Author author
    Date dateCreated
    Date lastUpdated
    static belongsTo = [author: Author]
    static constraints = {
    }
}
