package com.multiThreading;

public class Interrupt extends Thread{
    static boolean threadInterrupted = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            print();
        }, "Child");
        t.start();
        Thread.sleep(2000);
        threadInterrupted = true;
        t.interrupt();

        System.out.println(Thread.currentThread().getName()+" :: Execution complete..");
    }
    public static synchronized void print(){
        while(!Thread.currentThread().isInterrupted() && !threadInterrupted){
            System.out.println(Thread.currentThread().getName()+" thread sleeping...");
            System.out.println(Thread.currentThread().getName()+" Active...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            if(Thread.currentThread().isInterrupted())
//                threadInterrupted = true;
        }
    }
}
