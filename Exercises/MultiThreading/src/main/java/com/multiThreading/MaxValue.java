package com.multiThreading;

import java.util.ArrayList;
import java.util.Iterator;

// 6. Write a program called MaxValue.java that finds the maximum value in an array of ints using 4 threads.

public class MaxValue {

    private static ArrayList<Integer> list = new ArrayList<>();
    private static Iterator<Integer> itr;
    private static Integer max = 0;


    public static void main(String[] args) throws Exception {
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(40);
        list.add(50);
        list.add(500);
        list.add(1900);
        list.add(2);
        list.add(1000);
        itr = list.iterator();
            while (itr.hasNext()) {
                synchronized (max) {
                    new Thread(() -> findMax(max, itr.next())).start();

//                    Thread.sleep(10);

                    if (itr.hasNext())
                        new Thread(() -> findMax(max, itr.next())).start();

//                    Thread.sleep(10);

                    if (itr.hasNext())
                        new Thread(() -> findMax(max, itr.next())).start();

//                    Thread.sleep(10);

                    if (itr.hasNext())
                        new Thread(() -> findMax(max, itr.next())).start();

//                    Thread.sleep(10);
                }
            }
            System.out.println("Max : " + max);
    }

    private static void findMax(Integer temp, Integer num){
        if(num>temp)
            max =num;
    }
}

