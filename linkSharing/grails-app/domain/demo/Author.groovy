package demo

class Author {
    String firstName
    String lastName
    Integer age
    Date dateCreated
    Date lastUpdated

    static namedQueries = {
        recentAuthors{Date date ->
            gt 'dateCreated',date -10
        }

        adultAuthor{int age ->
            le 'age',age
        }
    }

    static constraints = {
    }
}
