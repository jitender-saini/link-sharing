package com.spring.services;

import com.spring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    @Autowired
    User user;

    public void addUser(String fName,String lName){
        user.setFirstName(fName);
        user.setLastName(lName);
        System.out.println("Adding user");
    }

    @Deprecated
    public void deleteUser(){
        System.out.println("deleting user");
    }

    public String getUserFirstName(){
        return user.getFirstName();
    }


    public void throwException(){
        int i=1/0;
        throw new ArithmeticException();
    }


    public void throwIOException() throws IOException{
        throw new IOException();
    }


}
