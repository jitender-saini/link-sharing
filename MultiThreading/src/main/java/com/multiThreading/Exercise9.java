package com.multiThreading;

public class Exercise9 {
        public static void main(String[] args)
        {
            call(4,10);
        }
        
        public static void printPattern(int min,int max,int incr)
        {
            for (int i=min;i<=max;i=i+incr)
            {
                System.out.println(Thread.currentThread().getName()+" : "+i);
            }
        }
        public static void call(int threadCount,int max)
        {
            for(int i=1;i<=threadCount;i++)
            {
                int finalI = i;
                new Thread(()->printPattern(finalI,max,threadCount),"Thread "+i).start();
                
            }
        }
        
    }
    

