import java.util.Comparator;

public class Employee implements Comparable{
    private String name;
    private int salary;
    Employee(String name,int salary){
        this.name=name;
        this.salary=salary;
    }


    @Override
    public int compareTo(Object o) {
        Employee e=(Employee)o;
        return this.name.compareTo(e.name);
    }
    public static void main(String[] args){
        Employee clerk = new Employee("rohan",2000);
        Employee developer =new Employee("ram",89000);
        System.out.println(clerk.compareTo(developer));
    }
}
