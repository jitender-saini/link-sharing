package com.spring;

import com.spring.customEvents.CustomPublisher;
import com.spring.customEvents.Email;
import com.spring.customEvents.EmailEvent;
import com.spring.employeeEvents.Employee;
import com.spring.employeeEvents.EmployeeEvent;
import com.spring.employeeEvents.EmployeePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEvent {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        context.start();

        Email email = new Email().setToMail("Jay@ttn.com")
                .setFromMail("sam@ttn.com")
                .setSubject("Hello ")
                .setBody("Friend");

        CustomPublisher publisher = context.getBean("customPublisher",CustomPublisher.class);

        EmailEvent emailEvent = new EmailEvent(email);
        publisher.publish(emailEvent);
        System.out.println("Async");
        context.stop();

    }
}
