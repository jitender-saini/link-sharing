package com.ttn.collection

class Exer22 {

    static void main(String[] args) {
        List empList = []
        for (int i = 1; i < 11; i++) {
            empList.add(new Employee(name: "Emp$i",age: 15+i,salary: 2000*i,
                    departmentName: "JVM",employeeNumber: 100+i))
            empList.add(new Employee(name: "TtnEmp$i",age: 40-i,salary: 3000*i,
                    departmentName: "AEM",employeeNumber: 200+i))
        }

        // 1. Group the employees on the basis of the bracket in which their salary falls. The ranges are 0-5000, 5001 and 10000, and so on.
        def list1=empList.groupBy {
            int num=it.salary-(it.salary%5000)
            "${num}-${num+5000}"
        }
        list1.each {
            println it
        }

        // 2. Get a count of the number of employees in each department
        def depMap=empList.groupBy {
            return it.departmentName
        }
        depMap.each {key,value ->
            println "count of the number of employees in each department ${key}:${value.size()}"
        }
        // 3. Get the list of employees whose age is between 18 and 35
        empList.each {
            if(it.age>17 && it.age<36)
                println it
        }

        // 4. Group the employees according to the alphabet with which their first name starts and display the number of employees in each group whose age is greater than
        def employeesByName = empList.groupBy { it.name[0] }
        assert employeesByName.count { it.key } == 2
        println("Employees according to the alphabet with which their first name starts ( Key ): " + employeesByName.keySet())
        println("Employees according to the alphabet with which their first name starts ( Value.name ): " + employeesByName.values().name)
        employeesByName.each {
            println "The number of employees in group "+it.key + " whose age is greater than 20 is ->" + it.value.count { itr -> itr.age > 20 }
        }

        // 5. Group the employees according to their department.
        def employeeByDepartment=empList.groupBy {
            return it.departmentName
        }
        employeeByDepartment.each {
            println "Employee by Department : $it"
        }

    }
}
