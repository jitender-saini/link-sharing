package com.desginPattern.pizzaStore;

public class ChickenFiesta extends Pizza {
    ChickenFiesta(){
        name = "Chicken Fiesta";
    }
    @Override
    public int getCost() {
        return 600;
    }
}
