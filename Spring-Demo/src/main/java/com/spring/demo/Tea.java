package com.spring.demo;

public class Tea implements HotDrink {
    @Override
    public void prepareHotDrink() {
        System.out.println("Preparing Tea");
    }
}
