package com.multiThreading;

public class UserProfile {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> execute());// <---------------- (t) NEW
        System.out.println("New thread created -> "+t.getState());
        t.start();// <---------------------------------------- (t) RUNNABLE
        System.out.println("Thread started -> "+t.getState());
        new Thread(() -> checkingState(t)).start();
        t.join();// <--------------------------- (main thread) TIMED_WAITING
        // <--------------------------------------------------(t) TERMINATED
        System.out.println("Thread terminated -> "+t.getState());
    }
    public static void execute(){
        for(int i = 0; i < 5; i++){
            System.out.println(i);
            try {
                System.out.println("Sleeping...");
                Thread.sleep(500);// <------------------------ (t) TIMED_WAITING
            } catch (InterruptedException e) {
            }
            System.out.println("Resuming work...");
        }
    }

    public static void checkingState(Thread t){
        do{
            System.out.println("Current state -> "+t.getState());
            try {
                System.out.println("Sleeping...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }while(t.isAlive()); // Tests if this thread is alive.
    }
}