package com.json;

public class Competency {
    private String name;

    private String head;

    private String employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Competency{" +
                "name='" + name + '\'' +
                ", head='" + head + '\'' +
                ", employees='" + employees + '\'' +
                '}';
    }
}
