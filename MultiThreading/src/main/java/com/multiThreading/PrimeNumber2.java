package com.multiThreading;

// 2. Print Prime and non-prime numbers from 1 to 20 in ascending order using two threads;

public class PrimeNumber2 {
    
    public static void main(String[] args) {
        PrimeCheck primeCheck = new PrimeCheck();
        Thread thread1 = new Thread(() -> {
            
            primeCheck.printPrimeCheck();
        }
        );
        Thread thread2 = new Thread(() -> {
            primeCheck.printNonPrimeCheck();
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}

class PrimeCheck {
    int check = 0;
    
    public void printPrimeCheck() {
        for (int n = 1; n <= 20; n++) {
            
            synchronized (this) {
                while (check == 1) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (isPrime(n)) {
                    System.out.println(n + " : Prime");
                    
                }
                check = 1;
                this.notify();
                
            }
            
        }
    }
    
    public void printNonPrimeCheck() {
        for (int n = 1; n <= 20; n++) {
            
            synchronized (this) {
                while (check == 0) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!isPrime(n)) {
                    System.out.println(n + " : NonPrime");
                    
                }
                check = 0;
                this.notify();
            }
        }
    }
    
    public boolean isPrime(int n) {
        for (int i = 2; i <= (n / 2); i++) {
            if (n % i == 0) {
                check = 0;
                return false;
            }
            
            
        }
        return true;
        
    }
}