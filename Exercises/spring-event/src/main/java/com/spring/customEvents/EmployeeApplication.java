package com.spring.customEvents;

import com.spring.employeeEvents.Employee;
import com.spring.employeeEvents.EmployeeEvent;
import com.spring.employeeEvents.EmployeePublisher;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Async;

import java.util.Scanner;

public class EmployeeApplication {
    @Async
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        context.start();
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Enter employee name:");
        employee.setName(sc.next());
        System.out.println("Enter employee email:");
        employee.setEmail(sc.next());
        System.out.println("Enter employee salary:");
        employee.setSalary(sc.nextDouble());

        EmployeePublisher publisher = context.getBean("employeePublisher", EmployeePublisher.class);
        EmployeeEvent employeeEvent =new EmployeeEvent(employee);

        if(employee.getSalary()>30000){
            System.out.println("Employee "+employee.getName()+"'s Salary is "+employee.getSalary()+", Which is greater than 30000");
            System.out.println("Enter Choice \n y to save employee \n n to reject employee \n c to change salary");
            String choice;
            choice = sc.next();
            switch (choice){
                case "y":
                    publisher.publish(employeeEvent);
                    break;
                case "n":
                    System.out.println("employee "+ employee.getName()+" not saved in database");
                    break;
                case "c":
                    System.out.println("Enter salary");
                    employee.setSalary(sc.nextDouble());
                    publisher.publish(employeeEvent);
                    break;
                default:
                    System.out.println("employee "+ employee.getName()+" not saved in database");
                    break;
            }
        }
        else publisher.publish(employeeEvent);
        context.stop();
    }
}
