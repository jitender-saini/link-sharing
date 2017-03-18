package javaCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Q4 Write a program to sort Employee objects based on highest salary using Comparator. Employee class{ Double Age; Double Salary; String Name
public class SortEmployee {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.initEmployee(24.0, 89000.0, "Jay");
        Employee employee2 = new Employee();
        employee2.initEmployee(20.0, 11500.0, "Tom");
        Employee employee3 = new Employee();
        employee3.initEmployee(27.0, 121000.0, "Sam");
        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        Collections.sort(list);
        System.out.println("Employee sorted on basis of salary :" + list);
    }

}

class Employee implements Comparable<Employee> {
    Double Age;
    Double Salary;
    String Name;

    public void initEmployee(Double age, Double salary, String Name) {
        setAge(age);
        setSalary(salary);
        setName(Name);
    }

    public Double getAge() {
        return Age;
    }

    public void setAge(Double age) {
        Age = age;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public int compareTo(Employee o) {
        return (int) (o.getSalary() - this.getSalary());
    }

    @Override
    public String toString() {
        return " Name : " + this.getName() + " Salary : " + this.getSalary() + " Age : " + this.getAge();
    }
}