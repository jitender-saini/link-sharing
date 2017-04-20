package com.ttn.collection

class Exer8 {
    static void main(String[] args) {

        List list = []
        for (int i = 1; i < 11; i++) {
            list.add(new Employee(name: "emp$i",age: 20+i,salary: 2000*i))
        }
        int i=0
        Employee empMaxSal = new Employee(salary: 0)
        Employee empMaxAge = new Employee(age: 0)

        Employee empMinAge = new Employee(age: 100)

        list.each {
            if(list[i].salary<5000)
                println "Employee With Salary Below 5000 : "+list[i]

            if(list[i].age > empMaxAge.age)
                empMaxAge = (Employee)list[i]

            if(list[i].age < empMinAge.age)
                empMinAge = (Employee)list[i]

            if(list[i].salary>  empMaxSal.salary)
                empMaxSal =(Employee)list[i]

            i++
        }
        println "Max Salary of Employee : "+empMaxSal
        println "Max Age of Employee : "+empMaxAge
        println "Min Age of Employee : "+empMinAge
        println "List of Employee Name : ${list.name}"
    }
}
