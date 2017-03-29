package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
//        Exercise 1 & 2
        Database obj = applicationContext.getBean("database",Database.class);
        System.out.println(obj);

//        Exercise 3
//        Restaurant restaurant = applicationContext.getBean("teaRestaurant",Restaurant.class);
//        restaurant.getHotDrink().prepareHotDrink();

//         Exercise 4
//        Restaurant restaurant2 = applicationContext.getBean("expressTeaRestaurant",Restaurant.class);
//        restaurant2.getHotDrink().prepareHotDrink();

//        Exercise 5
        Complex complex = applicationContext.getBean("complexBean",Complex.class);
        System.out.println(complex);

//        Exercise 6
//        Autowire by name
//        Restaurant restaurant3 =applicationContext.getBean("restaurant",Restaurant.class);
//        System.out.println("autowire by name");
//        restaurant3.getHotDrink().prepareHotDrink();

//        Autowire by type
//        Restaurant restaurant4 = applicationContext.getBean("restaurant4", Restaurant.class);
//        restaurant4.getHotDrink().prepareHotDrink();

//        Autowire by Constructor
//        Restaurant restaurant5 = applicationContext.getBean("restaurant5", Restaurant.class);
//        restaurant5.getHotDrink().prepareHotDrink();

//        Exercise 7
//        Restaurant restaurant6 = applicationContext.getBean("restaurant6",Restaurant.class);
//        System.out.println(applicationContext.isPrototype("restaurant6"));

//        Exercise 8
        Restaurant restaurant7 = applicationContext.getBean("restaurant7",Restaurant.class);
        restaurant7.getHotDrink().prepareHotDrink();
        

    }
}
