package javaCollections;

import java.util.ArrayList;
import java.util.Collections;

// Q5 Write a program to sort the Student objects based on Score , if the score are same then sort on First Name . Class Student{ String Name; Double Score; Double Age

public class SortStudent {
    public static void main(String[] args) {
        Student ob1 = new Student();
        ob1.initEmployee(24.0, 82.0, "Jay ");
        Student ob2 = new Student();
        ob2.initEmployee(20.0, 53.0, "Tom");
        Student ob3 = new Student();
        ob3.initEmployee(27.0, 98.0, "Sam");
        ArrayList<Student> list = new ArrayList<>();
        list.add(ob1);
        list.add(ob2);
        list.add(ob3);
        Collections.sort(list);
        for (Student student : list) {
            System.out.println(" name : " + student.getName() + " score : " + student.getScore() + " age : " + student.getAge());
        }
    }
}

class Student implements Comparable<Student> {
    double Age;
    double Score;
    String Name;

    public void initEmployee(double age, double score, String Name) {
        setAge(age);
        setScore(score);
        setName(Name);
    }

    public double getAge() {
        return Age;
    }

    public void setAge(double age) {
        Age = age;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public int compareTo(Student o) {
        if (o.getScore() != this.getScore()) {
            return (int) (o.getScore() - this.getScore());
        } else {
            return this.getName().compareTo(o.getName());
        }
    }

    @Override
    public String toString() {
        return " Name : " + this.getName() + " Score : " + this.getScore() + " Age : " + this.getAge();
    }

}