package com.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 10. Write a program called SharedCounter.java in which 5 threads each increment a shared
// int counter 1000 times. When all the threads have finished, print the final value of the counter.
// If the initial value is zero, do you always get 5000? Arrange your code to get the correct output.
// Note: - use a thread pool of 2 threads.

public class SharedCounter {
    private static int counter = 0;

    public static void increment() {
        for (int i = 0; i < 1000; i++) {
            synchronized (SharedCounter.class) {
                counter++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                increment();
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Finished all threads");
        System.out.println("Counter: " + counter);


    }
}
