package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class Restaurant {

    public Restaurant(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    private HotDrink hotDrink;
    @Autowired
    public HotDrink getHotDrink() {
        return hotDrink;
    }

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
