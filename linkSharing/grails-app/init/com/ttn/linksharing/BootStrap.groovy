package com.ttn.linksharing

import demo.Employee


class BootStrap {

    def init = { servletContext ->
        createEmployee()
        getById(1)
        getById(2)
        findById(1)
        findById(2)
        findbyProperty()
        findAndCreate()
        findAndSave()
    }

    def createEmployee(){
        Employee employee = new Employee()
        employee.firstName = "Jay"
        employee.lastName = "Saini"
        employee.age=25
        employee.save(flush : true, failOnErron : true)
        Employee emp2 = new Employee(firstName: "sam",lastName: "saini",age: 22)
        emp2.save(flush:true,failOnError : true)
    }

    void getById(float id){
        log.info("############ getting employee with : ${id}#########")
        Employee employee = Employee.get(1)
    }

    void findById(float id){
        log.info("############ find employee with id : ${id}#########")
        Employee employee = Employee.findById(1)
    }

    void findbyProperty(){
        Employee employee = Employee.findByFirstName("Jay")
        log.info("############ employee with name Jay : ${employee.id}#########")

        Employee emp2 = Employee.findByFirstNameIlike("s%")
        log.info("############ employee with start with s : ${emp2.id}#########")
//        List<Employee> employeeList = Employee.findAllByFirstName(sort)
        Integer empCount = Employee.count()
        log.info("Employee count ${empCount}")
        Integer empCountByName = Employee.countByFirstName("jay")
        log.info("Employee count by name ${empCountByName}")
    }

    void findAndCreate(){
        Employee employee = Employee.findOrCreateWhere([firstName: "ajay",lastName: "goyal", age: 21])
        log.info("Employee find and create ${employee.firstName}")
        Employee employee2 = Employee.findOrCreateWhere([firstName: "ajay",lastName: "goyal", age: 21])
        log.info("Employee find and create ${employee2.firstName}")
        Employee emp3 = Employee.findOrCreateByFirstName("Tom")
        log.info("Employee find or create by name ${emp3.firstName} ${emp3.lastName}")
    }

    void findAndSave(){
        Employee employee = Employee.findOrSaveWhere([firstName: "isha",lastName: "goyal", age: 21])
        log.info("Employee find and save ${employee.firstName}")
        Employee employee2 = Employee.findOrSaveWhere([firstName: "isha",lastName: "goyal", age: 21])
        log.info("Employee find and save ${employee2.firstName}")
        Employee emp3 = Employee.findOrSaveByFirstName("Tom")
        log.info("Employee find or create by name ${emp3.firstName} ${emp3.lastName}")
        println emp3.hasErrors()
    }

    def destroy = {
        log.info("Closing application")
    }
}
