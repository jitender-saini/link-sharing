package com.ttn.groovy

class Employee extends Person {
    double salary
    int empId
    String company

    @Override
    String toString() {
       super.toString()+ " He works for $company with employee id $empId and draws $salary lots of money !!!!."
    }

}
