package com.desginPattern.utility;

public class Main {
    public static void main(String[] args) {

        Thread t1=new Thread(()->{
            FileUtility.getInstance().readFile();
        });
        Thread t2=new Thread(()->{
            FileUtility.getInstance().readFile();
        });
        t1.start();
        t2.start();
    }
}