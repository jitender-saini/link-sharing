package com.desginPattern.pizzaStore;


class Tomato extends PizzaToppings {
    Pizza pizza;

    Tomato(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName() + ", Tomato";
    }

    @Override
    public int getCost() {
        return 40 + pizza.getCost();
    }
}
