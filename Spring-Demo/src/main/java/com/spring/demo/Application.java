package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        //Exercise 1 & 2
        Database obj = applicationContext.getBean("database",Database.class);
        System.out.println(obj);

        //Exercise 3
        Restaurant restaurant = applicationContext.getBean("teaRestaurant",Restaurant.class);
        restaurant.getHotDrink().prepareHotDrink();

        // Exercise 4
        Restaurant restaurant2 = applicationContext.getBean("expressTeaRestaurant",Restaurant.class);
        restaurant2.getHotDrink().prepareHotDrink();

        //Exercise 5
        Complex complex = applicationContext.getBean("complexBean",Complex.class);
        System.out.println(complex);

    }
}
