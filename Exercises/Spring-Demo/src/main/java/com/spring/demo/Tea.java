package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tea implements HotDrink {
    @Override
    @Autowired  //Exercise 9
    public void prepareHotDrink() {
        System.out.println("Preparing Tea");
    }
}
