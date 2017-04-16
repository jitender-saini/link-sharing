package com.desginPattern.pizzaStore;

abstract class Pizza {
    String name = "";

    public String getName() {
        return name;
    }

    public abstract int getCost();
}

