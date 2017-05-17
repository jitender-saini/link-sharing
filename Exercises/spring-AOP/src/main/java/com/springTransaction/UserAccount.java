package com.springTransaction;

import org.springframework.stereotype.Repository;

@Repository
public class UserAccount {
    private String username;
    private long balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}
