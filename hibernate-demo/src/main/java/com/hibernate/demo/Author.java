package com.hibernate.demo;

import javax.persistence.*;
import java.util.Date;


@NamedQuery(name = "user.byId", query = "from Author where id = :id")
@Entity
public class Author {
    @Id()
    private int id;
    private String firstName;
//    private String lastName;
    private int age;
    //private Date dateOfBirth;
    private String gender;

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public Author(int id, String firstName, int age, String gender) {
//        this.id = id;
//        this.firstName = firstName;
//        this.age = age;
//        this.gender = gender;
//    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}