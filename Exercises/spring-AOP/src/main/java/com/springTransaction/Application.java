package com.springTransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-Datasource.xml");
        AccountServices accountServices = applicationContext.getBean(AccountServices.class);
        accountServices.addUser("Tom",1000);
        accountServices.updateBalance("Tom",80000);
        accountServices.transferAmountDeclarativeTransaction("Jay","Tom",50000);
        accountServices.transferAmountProgrammaticTransaction("Jay","Sam",2500);
        System.out.println(accountServices.getUser("Jay"));
        accountServices.deleteUser("Tom");
    }
}
