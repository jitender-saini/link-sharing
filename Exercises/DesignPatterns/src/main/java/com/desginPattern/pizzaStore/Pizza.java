package com.desginPattern.pizzaStore;

abstract class Pizza {
    String name;
    int cost;

    public String getName() {
        return name;
    }

    public abstract int getCost();
}

