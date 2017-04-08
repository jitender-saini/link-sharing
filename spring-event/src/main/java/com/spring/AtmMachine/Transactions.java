package com.spring.AtmMachine;

import com.spring.AtmMachine.model.dao.impl.AccountDaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Transactions {
    public static void main(String[] args) throws IOException {
        AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char temp;
        outer:
            do {
                System.out.println("Enter ATM ID");
                int id = sc.nextInt();
                System.out.println("Enter ATM Pin");
                int pin = sc.nextInt();
                System.out.println("Select option \n 1 -> Withdrawal Amount \n 2 -> check balance\n 3 -> change pin\n 4 -> change phone number");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter Amount to Withdrawal in multiple of 100");
                        int amount = sc.nextInt();
                        accountDaoImpl.withdrawsAmount(id,amount,pin);
                        break;
                    case 2:
                        accountDaoImpl.checkBalance(id,pin);
                        break;
                    case 3:
                        System.out.println("Enter new pin:");
                        accountDaoImpl.change(id,pin);
                        int newPin = sc.nextInt();
                        System.out.println("Enter OTP to change pin");
                        accountDaoImpl.setUserOtp(sc.nextInt());
                        accountDaoImpl.updatePin(id, pin, newPin);
                        break;
                    case 4:
                        System.out.println("Enter new mobile number:");
                        String newNumber = reader.readLine();
                        accountDaoImpl.change(id,pin);
                        System.out.println("Enter OTP to change Mobile number");
                        accountDaoImpl.setUserOtp(sc.nextInt());
                        accountDaoImpl.changeMobile(id,newNumber,pin);
                        break;
                    case 5:
                        break outer;
                }
            System.out.println("do you want to continue: press y for yes and n for no :");
            temp = reader.readLine().charAt(0);
        } while (temp != 'n');
        System.out.println("Thank you for your time.");
    }
}
