package com.json;

import java.util.Arrays;

public class Department {
    private Competency[] competency;
    private String name;

    public Competency[] getCompetency() {
        return competency;
    }

    public void setCompetency(Competency[] competency) {
        this.competency = competency;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "competency=" + Arrays.toString(competency) +
                ", name='" + name + '\'' +
                '}';
    }
}
