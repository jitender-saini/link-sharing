package com.multiThreading;

import java.util.UUID;

public class Exercise7
{
    public static void main(String[] args) {
        PubSub pubSub=new PubSub();

        Thread thread1=new Thread(()->pubSub.subscriber());
        Thread thread2=new Thread(()->pubSub.publisher());
        Thread thread3=new Thread(()->pubSub.subscriber());
        Thread thread4=new Thread(()->pubSub.publisher());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



class PubSub {
    private String message = "";
    public void subscriber() {
        for(int i = 0; i < 2; i++){
            synchronized (this) {
                try {
                    while(message.equals("")){
                        this.wait();
                    }
                    System.out.println(i+". Message subscribed by subscriber+"+Thread.currentThread().getName()+" = "+message);


                    message="";
                    this.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void publisher() {
        for(int i = 0; i < 2; i++){
            synchronized (this) {
                try {
                    while(!message.equals("")){
                        this.wait();
                    }
                    message= UUID.randomUUID().toString();
                    System.out.println(i+". Message published by Publisher"+Thread.currentThread().getName()+ " = "+message);
                    this.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}