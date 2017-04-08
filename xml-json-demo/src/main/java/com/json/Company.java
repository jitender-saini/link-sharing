package com.json;

public class Company {
    private TTN ttn;

    public TTN getTtn() {
        return ttn;
    }

    public void setTtn(TTN ttn) {
        this.ttn = ttn;
    }

    @Override
    public String toString() {
        return "Company{" +
                "ttn=" + ttn +
                '}';
    }
}
