package com.desginPattern.pizzaStore;

class Capsicum extends PizzaToppings {
    Pizza  pizza;

    Capsicum(Pizza pizza){
        this.pizza = pizza;
    }


    @Override
    public String getName() {
        return pizza.getName()+", Capsicum";
    }

    @Override
    public int getCost() {
        return pizza.getCost()+30;
    }
}
