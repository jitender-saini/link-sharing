package com.multiThreading;

class Test1 extends Thread
{
    static int sum;
    public void run()
    {
        for(int i = 0; i < 10; i++)
        {
            sum += i;
        }
    }
}

public class ArrayOfThreads
{
    public static void main(String args[])
    {
        Test1 test[] = new Test1[2];
        for(int i = 0; i < test.length; i++)
        {
            test[i] = new Test1();
            test[i].start();
        }
        System.out.println("Sum = " + Test1.sum);
    }
}