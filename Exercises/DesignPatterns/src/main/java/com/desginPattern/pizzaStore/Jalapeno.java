package com.desginPattern.pizzaStore;

class Jalapeno extends PizzaToppings {
    Pizza pizza;
    Jalapeno(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName() + ", Jalapeno";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 80;
    }
}
