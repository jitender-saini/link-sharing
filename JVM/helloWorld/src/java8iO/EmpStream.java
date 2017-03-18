package java8iO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EmpStream {
    public static void main(String[] args) {

//        Employee e1 = new Employee("Jay", 22, 1001, 89000);
//        Employee e2 = new Employee("Sam", 22, 1002, 89000);
//        Employee e3 = new Employee("Shef", 22, 1003, 89000);
//        Employee e4 = new Employee("Ajay", 22, 1004, 89000);
//        Employee e5 = new Employee("Bhupi", 22, 1005, 89000);
//        Employee e6 = new Employee("Bhatura", 22, 1006, 89000);
//        Employee e7 = new Employee("Mani", 22, 1007, 89000);
//        Employee e8 = new Employee("Aro", 22, 1008, 89000);

        List<Employee> employee = Arrays.asList(
                new Employee("nJay", 25),
                new Employee("Sam", 24),
                new Employee("nitesh", 27),
                new Employee("njay", 21),
                new Employee("Bhupi", 22)
        );
        employee.stream().filter(s -> s.getName().startsWith("n")).filter(s -> s.getAge()>24).forEach(e->
            System.out.println(e.getName()+""+e.getAge()));

    }
}
