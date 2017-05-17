package com.multiThreading;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Exercise8 {
    public static void main(String[] args) throws InterruptedException {
        PubSub1 pubSub = new PubSub1();

        Thread thread1 = new Thread(() -> pubSub.publisher());
        Thread thread2 = new Thread(() -> pubSub.subscriber());
        Thread thread3 = new Thread(() -> pubSub.publisher());
        Thread thread4 = new Thread(() -> pubSub.subscriber());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

    }
}
 class PubSub1{
    private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
    
    public void subscriber() {
        for (int i = 0; i < 2; i++) {
            String message = "";
            try {
                message = queue.take();
            } catch (InterruptedException e) {
            }
            System.out.println( "Message subscribed by : "+Thread.currentThread().getName()+" = " + message);
        }
    }
    
    public void publisher() {
        for (int i = 0; i < 2; i++) {
            String message =UUID.randomUUID().toString();;
            try {
                queue.put(message);
            } catch (InterruptedException e) {
            }
            System.out.println("Message published by : "+Thread.currentThread().getName()+" = " + message);
        }
    }
}
