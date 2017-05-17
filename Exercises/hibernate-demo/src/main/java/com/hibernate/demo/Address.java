package com.hibernate.demo;


import javax.persistence.Embeddable;

//QUES 10
@Embeddable                 //Ques11
public class Address {
    
    private Integer streetNo;
    private String location;
    private String state;

    public Integer getStreetNo() {
        return streetNo;
    }

    public String getLocation() {
        return location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStreetNo(Integer streetNo) {
        this.streetNo = streetNo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNo=" + streetNo +
                ", location='" + location + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
