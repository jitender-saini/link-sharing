package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

@Repository
public class Restaurant {

    @Autowired  //Exercise 9
    public Restaurant(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    @Autowired  //Exercise 9
    private HotDrink hotDrink;
    @Autowired  //Exercise 9
    public HotDrink getHotDrink() {
        return hotDrink;
    }

    @Required
    @Autowired  //Exercise 9
    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "hotDrink=" + hotDrink +
                '}';
    }

}
