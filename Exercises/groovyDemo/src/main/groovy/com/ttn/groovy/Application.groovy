package com.ttn.groovy

import com.ttn.groovy.model.Employee
import com.ttn.groovy.model.Person

class Application {

    static void main(String[] args) {

        Person person = new Person()

        person.setName("Jay")
        person.setAge(24)
        person.gender="male"
        person.setAddress("Noida")

        println("Name :"+person.getName())
        println("Age :"+person.getAge())
        println("Gender :"+person.getGender())
        println("Address :"+person.getAddress())

        println("Name :"+person.name)
        println("Age :"+person.age)
        println("Gender :"+person.gender)
        println("Address :"+person.address)

        println(person)

        Employee employee = new Employee()
        employee.empId=101
        employee.name="Sam"
        employee.setAge(24)
        employee.setGender("male")
        employee.setAddress("Delhi")
        employee.setSalary(45600)
        employee.setCompany("To The New")

        println "Name : "+employee.name
        println "Age : "+employee.getAge()
        println "Gender : "+employee.getGender()
        println "Address : "+employee.address
        println "Salary : "+employee.salary
        println "EmpId : "+employee.getEmpId()
        println "Company : "+employee.@company

        println employee

    }
}