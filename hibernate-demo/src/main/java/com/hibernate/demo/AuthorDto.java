package com.hibernate.demo;

public class AuthorDto {

    private String firstName;
    private int age;

    public AuthorDto(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
