package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        Database obj = applicationContext.getBean("database",Database.class);
        System.out.println("Hello World");
    }
}
