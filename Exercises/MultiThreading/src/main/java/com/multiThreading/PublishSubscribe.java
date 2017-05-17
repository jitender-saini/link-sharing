package com.multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PublishSubscribe {
    private List<String> queue = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        PublishSubscribe pubSub = new PublishSubscribe();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(() -> pubSub.publish());
        executor.execute(() -> pubSub.subscribe());
    }

    private void publish() {
        String message;
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                while (queue.size() == 3) {
// wait
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                    }
                }
                message = UUID.randomUUID().toString();
                System.out.println(Thread.currentThread().getName() + ": Publish......" + message);
                queue.add(message);
// notify sub
                this.notify();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void subscribe() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                while (queue.size() == 0) {
// wait
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": Subscribe......" + queue.remove(0));
// notify pub
                this.notify();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}