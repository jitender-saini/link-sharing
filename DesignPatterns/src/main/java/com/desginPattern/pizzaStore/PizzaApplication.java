package com.desginPattern.pizzaStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PizzaApplication {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 -> Peppy Paneer \n2 -> Margherita \n3 -> ChickenFiesta \n4 -> Farmhouse \nEnter Choice :");
        int choice = scanner.nextInt();
        Pizza pizza;
        if (choice == 1) {
            pizza = new PeppyPaneer();
            pizza = addToppings(pizza);
        } else if (choice == 2) {
            pizza = new Margherita();
            pizza = addToppings(pizza);
        } else if (choice == 3) {
            pizza = new ChickenFiesta();
            pizza = addToppings(pizza);
        } else if (choice == 4) {
            pizza = new Farmhouse();
            pizza = addToppings(pizza);
        } else {
            pizza = null;
            System.out.println("Bie bie");
        }
        if (pizza != null)
            System.out.println("Pizza Name : " + pizza.getName() + " Price :" + pizza.getCost());
    }

    public static Pizza addToppings(Pizza pizza) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char temp;
        char choice;
        do {
            System.out.println(" \n t -> Tomatoes \n p -> Paneer \n j -> Jalepeno \n b -> Barbequee \n c -> Capsicum \n Enter toppings to addon");
            choice = reader.readLine().charAt(0);
            switch (choice) {
                case 't':
                    pizza = new Tomato(pizza);
                    break;
                case 'p':
                    pizza = new Paneer(pizza);
                    break;
                case 'j':
                    pizza = new Jalapeno(pizza);
                    break;
                case 'c':
                    pizza = new Capsicum(pizza);
                    break;
                case 'b':
                    pizza = new Barbeque(pizza);
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
            System.out.println("do you want to continue: press y for yes and n for no :");
            temp = reader.readLine().charAt(0);
        } while (temp != 'n');
        return pizza;
    }
}

