package com.multiThreading;

//1. Print Odd and even numbers from 1 to 20 in ascending order using two threads;

public class ThreadSignalOddEvenAscendingOrder {
    private volatile int number = 0;

    public void printEven () {
        for (int i = 2; i < 21; i = i + 2) {
       synchronized (this){
           try {
               while (number%2 == 0)
                   this.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           number = number+1;
               System.out.println("Even :" + number);
               this.notify();
           }
       }
    }

    public void printOdd() {
        for (int i = 1; i < 21; i = i + 2) {
            synchronized (this){
                try {
                    while (number%2 != 0)
                        this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                number = number+1;
                System.out.println("Odd :" + number);
                this.notify();
            }
        }
    }

    public static void main(String[] args) {
        ThreadSignalOddEvenAscendingOrder test = new ThreadSignalOddEvenAscendingOrder();
        new Thread(()-> test.printOdd()).start();
        new Thread(()->test.printEven()).start();
    }
}
