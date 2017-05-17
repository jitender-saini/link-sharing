package com.ttn.collection

import com.ttn.collection.model.Employee

class Exer8 {
    static void main(String[] args) {

        List list = []
        for (int i = 1; i < 11; i++) {
            list.add(new Employee(name: "emp$i",age: 20+i,salary: 2000*i))
        }
        Employee empMaxSal = new Employee(salary: 0)
        Employee empMaxAge = new Employee(age: 0)
        Employee empMinAge = new Employee(age: 100)

        list.each {
            if(it.getSalary()<5000)
                println "Employee With Salary Below 5000 : "+it

            if(it.age > empMaxAge.age)
                empMaxAge = it

            if(it.age < empMinAge.age)
                empMinAge = it

            if(it.salary >  empMaxSal.salary)
                empMaxSal =it
        }
        println "Max Salary of Employee : "+empMaxSal
        println "Max Age of Employee : "+empMaxAge
        println "Min Age of Employee : "+empMinAge
        println "List of Employee Name : ${list.name}"

        list.sort({a,b ->
            a.getAge() - b.getAge()
        })
        println "Min Age of Employee : "+list.first()
        println "Max Age of Employee : "+list.last()
    }
}
