package com.desginPattern.pizzaStore;

class Paneer extends PizzaToppings{
    Pizza pizza;

    Paneer(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName()+", Paneer";
    }

    @Override
    public int getCost() {
        return pizza.getCost()+50;
    }
}
