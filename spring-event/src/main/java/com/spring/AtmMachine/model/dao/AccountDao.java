package com.spring.AtmMachine.model.dao;

public interface AccountDao {
    public void checkBalance(int id,int pin);

    public void withdrawsAmount(int id, int amount,int pin);

    public void change(int id, int oldPin);

    public void changeMobile(int id, String number, int pin);
}
