package com.ttn.groovy

import groovy.transform.ToString

@ToString
class Person {
    String name
    int age
    String gender
    String address


    @Override
     String toString() {
        "$name is a $gender aged $age who lives at $address."
    }
}
