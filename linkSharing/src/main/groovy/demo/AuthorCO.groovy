package demo

import grails.validation.Validateable

class AuthorCO implements Validateable {
    String firstName
    String lastName
    int age
}
