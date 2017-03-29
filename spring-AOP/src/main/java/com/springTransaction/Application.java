package com.springTransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-Datasource.xml");
        AccountServices accountServices = applicationContext.getBean(AccountServices.class);
        accountServices.transferAmount("user1","user2",100);

    }
}
