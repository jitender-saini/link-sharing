package com.multiThreading;

//3. Print pattern 1 2 3 1 2 3.... using three different threads



public class ThreadSignalPattern {
    int number=10;
    boolean one = true;
    boolean two = false;
    boolean three = false;

    public void print1(int number){
        for (int i = 1; i < number+1; i++) {
            synchronized (this){
                try {
                    while (!one )
                        this.wait();
                    System.out.println("Thread1 ");
                    one = false;
                    two = true;
                    three = false;
                    this.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void print2(int number){
        for (int i = 1; i < number+1; i++) {
            synchronized (this){
                try {
                    while (!two )
                        this.wait();
                    System.out.println("Thread2 ");
                    one = false;
                    two = false;
                    three = true;
                    this.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void print3(int number){
        for (int i = 1; i < number+1; i++) {
            synchronized (this){
                try {
                    while (!three )
                        this.wait();
                System.out.println("Thread3 ");
                    one = true;
                    two = false;
                    three = false;
                this.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args)  {
        ThreadSignalPattern test = new ThreadSignalPattern();
        new Thread( ()-> test.print1(test.number)).start();
        new Thread( ()-> test.print2(test.number)).start();
        new Thread( ()-> test.print3(test.number)).start();
    }
}
