package com.springTransaction;

import org.springframework.stereotype.Repository;

@Repository
public class UserAccount {
    private String username;
    private long salary;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "username='" + username + '\'' +
                ", salary=" + salary +
                '}';
    }
}
