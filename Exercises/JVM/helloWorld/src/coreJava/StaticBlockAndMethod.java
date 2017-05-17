package coreJava;

// Q7 Write a program to print your Firstname,LastName & age using static block,static method & static variable respectively
public class StaticBlockAndMethod {
    public static String firstName="Jay";
    public static String lastName="Saini";
    public static byte age=25;

    StaticBlockAndMethod(){
        System.out.println("Constructor method");
        System.out.println("First Name : "+ firstName+"\nLast Name : "+lastName+"\nAge : "+age);
    }

    static{
        System.out.println("Static Block");
        System.out.println("First Name : "+ firstName+"\nLast Name : "+lastName+"\nAge : "+age);
    }

    public static void printDetails(){
        System.out.println("Static method");
        System.out.println("First Name : "+ firstName+"\nLast Name : "+lastName+"\nAge : "+age);
    }

    public static void main(String[] args) {
        StaticBlockAndMethod obj = new StaticBlockAndMethod();
        printDetails();
        System.out.println("Main method");
        System.out.println("First Name : "+ firstName+"\nLast Name : "+lastName+"\nAge : "+age);
    }
}
