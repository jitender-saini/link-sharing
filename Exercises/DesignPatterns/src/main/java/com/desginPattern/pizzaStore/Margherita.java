package com.desginPattern.pizzaStore;

public class Margherita extends Pizza {
    Margherita(){
        name = "Margherita";
    }
    @Override
    public int getCost() {
        return 350;
    }
}
