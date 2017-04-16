package com.desginPattern.pizzaStore;

 class Barbeque extends PizzaToppings {
     Pizza pizza;

     Barbeque(Pizza pizza){
         this.pizza= pizza;
     }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getCost() {
        return 0;
    }
}
