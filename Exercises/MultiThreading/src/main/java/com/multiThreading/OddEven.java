package com.multiThreading;

public class OddEven extends Thread{
    public static void printEven () {
        for (int i = 2; i < 11; i = i + 2) {
               System.out.println("even :" + i);
        }
    }


    public static void printOdd() {
        for (int i = 1; i < 11; i = i + 2) {
            System.out.println("Odd :" + i);
        }
    }

    public static void main(String[] args) {
        Thread t3 = new Thread(()->printEven());
        Thread t4 = new Thread(()->printOdd());
        t3.start();
        t4.start();
//        printEven();
//        printOdd();
    }
}
