package demo

class Employee {

    static constraints = {
    }

    String firstName
    String lastName
    static transients = ['fullName']
    int age

//    String getFullName(){
//        [firstName,lastName].findAll{ }.split {" "}
//    }
}
