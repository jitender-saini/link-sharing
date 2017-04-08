package com.spring.AtmMachine.model;

import java.sql.Date;

public class Sms {
    private int id;
    private double amountLeft;
    private double amountDebited;
    private java.util.Date date;
    private String content;
    private String name;
    public Sms(){
    }

    public int getId() {
        return id;
    }

    public Sms setId(int id) {
        this.id = id;
        return this;
    }

    public double getAmountLeft() {
        return amountLeft;
    }

    public Sms setAmountLeft(double amountLeft) {
        this.amountLeft = amountLeft;
        return this;
    }

    public double getAmountDebited() {
        return amountDebited;
    }

    public Sms setAmountDebited(double amountDebited) {
        this.amountDebited = amountDebited;
        return this;
    }

    public java.util.Date getDate() {
        return date;
    }

    public Sms setDate(java.util.Date date) {
        this.date = date;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Sms setContent(String content) {
        this.content = content;
        return this;
    }

    public String getName() {
        return name;
    }

    public Sms setName(String name) {
        this.name = name;
        return this;
    }
}
