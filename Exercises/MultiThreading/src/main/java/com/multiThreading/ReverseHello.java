package com.multiThreading;

public class ReverseHello {
    private static int threadCount;
    public static void main(String[] args) {
        threadFactory();
    }

    static void threadFactory() {
        threadCount++;
        Thread t1 = new Thread(() -> print(), "Thread" + (threadCount));
        if (threadCount < 10) {
            threadFactory();
        }
        t1.start();
    }

    public static void print() {
        System.out.println("Hello From Thread" + Thread.currentThread().getName());
    }
}
