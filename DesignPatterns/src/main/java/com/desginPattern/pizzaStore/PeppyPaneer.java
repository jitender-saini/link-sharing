package com.desginPattern.pizzaStore;

public class PeppyPaneer extends Pizza {
    PeppyPaneer(){
        name = "Peppy Paneer";
    }

    @Override
    public int getCost() {
        return 300;
    }
}
