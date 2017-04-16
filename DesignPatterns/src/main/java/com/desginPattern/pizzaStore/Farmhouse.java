package com.desginPattern.pizzaStore;

public class Farmhouse extends Pizza {
    Farmhouse(){
        name = "Farmhouse";
    }
    @Override
    public int getCost() {
        return 450;
    }
}
