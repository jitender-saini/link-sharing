package com.spring.controller;

import com.spring.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        UserService userService = applicationContext.getBean(UserService.class);
//        userService.addUser();
//        userService.deleteUser();
        userService.throwException();
    }
}
