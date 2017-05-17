package com.multiThreading;

import java.util.ArrayList;
import java.util.Iterator;
// 5. Create a program that calculates the sum of all the elements of an Array by using 4 threads.

public class ArraySum {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(40);
        list.add(50);
        list.add(500);
        list.add(1000);
        Multi t1;
        Multi t2;
        Multi t3;
        Multi t4;
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            t1 = new Multi(itr.next());
            t1.start();
            t1.join();
            if (itr.hasNext()) {
                t2 = new Multi(itr.next());
                t2.start();
                t2.join();
            }
            if (itr.hasNext()) {
                t3 = new Multi(itr.next());
                t3.start();
                t3.join();
            }
            if (itr.hasNext()) {
                t4 = new Multi(itr.next());
                t4.start();
                t4.join();
            }
        }

        Total sum = Total.getInstance();
        System.out.println("Sum of all elements of the array is :" + sum.getSum());
    }
}

class Multi extends Thread {
    private Integer num;

    Multi(Integer num) {
        this.num = num;
    }

    @Override
    public void run() {
        Total sum = Total.getInstance();
        sum.setSum(sum.getSum() + num);
//         System.out.println(sum.getSum());
    }
}

class Total {
    int sum;
    private static Total total = new Total();

    private Total() {
    }

    public int getSum() {
        return sum;
    }

    public Total setSum(int sum) {
        this.sum = sum;
        return this;
    }

    static Total getInstance() {
        if (total == null)
            total = new Total();
        return total;
    }
}
