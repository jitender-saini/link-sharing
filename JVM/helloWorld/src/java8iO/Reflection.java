package java8iO;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Reflection Reflection = new Reflection();
        Reflection.getFieldNames();
    }
    public void getFieldNames() throws NoSuchFieldException, IllegalAccessException {
        Student s1 = new Student(1,"Arpit");
        Field[] field = s1.getClass().getDeclaredFields();
        for (Field f : field)
            System.out.println(f);
        Method[] methods = s1.getClass().getDeclaredMethods();
        for (Method m : methods)
            System.out.println(m);

    }
}
class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
