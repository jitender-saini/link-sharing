package com.spring.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    public void addUser(){
        System.out.println("Adding user");
    }

    @Deprecated
    public void deleteUser(){
        System.out.println("deleting user");
    }

    public String getValue(){
        return "hello friends";
    }

    public void throwException(){
        throw new ArithmeticException();
    }


}
