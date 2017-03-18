package java8iO;

import java.io.Serializable;

public class Employee implements Serializable{
    private static final long serialVersionUID = 10L;
    private String name;
    private int age;
    private int empId;
    transient private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, int age, int empId, int salary) {
        this.name = name;
        this.age = age;

        this.empId = empId;
        this.salary = salary;
    }
    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return "Employee{name="+name+",Age="+age+",id="+empId+",salary="+salary+"}";
    }
}
