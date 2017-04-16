package com.multiThreading;

// 2. Print Prime and non-prime numbers from 1 to 20 in ascending order using two threads;

public class PrimeNumbers {

    private int num = 2;

    public static void main(String[] args) {
        PrimeNumbers primeNumbers = new PrimeNumbers();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (primeNumbers.num <= 20) {
                    synchronized (primeNumbers) {
                        if (primeNumbers.isPrime(primeNumbers.num)) {
                            System.out.println(primeNumbers.num + " " +
                                    Thread.currentThread().getName());
                            primeNumbers.num++;
                            try {
                                primeNumbers.notify();
                                primeNumbers.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            }
        }, "Prime : ").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (primeNumbers.num <= 20) {
                    synchronized (primeNumbers) {
                        if (!primeNumbers.isPrime(primeNumbers.num)) {
                            System.out.println(primeNumbers.num + " " +
                                    Thread.currentThread().getName());
                            primeNumbers.num++;
                        } else {
                            try {
                                primeNumbers.notify();
                                primeNumbers.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            }
        }, "NonPrime : ").start();

    }

    boolean isPrime(int n) {
        for (int count = 2; count * count < n; count = count == 2 ? count + 1 : count + 2) {
            if (n % count == 0) {
                return false;
            }
        }
        return true;
    }
}