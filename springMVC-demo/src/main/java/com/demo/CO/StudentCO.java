package com.demo.CO;

public class StudentCO {
    String firstName;
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public StudentCO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public StudentCO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public String toString() {
        return "StudentCO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
