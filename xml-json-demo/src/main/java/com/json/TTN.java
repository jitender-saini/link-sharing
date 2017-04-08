package com.json;

import java.util.Arrays;

public class TTN {

    private Department[] department;

    public Department[] getDepartment() {
        return department;
    }

    public void setDepartment(Department[] department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Ttn{" +
                "department=" + Arrays.toString(department) +
                '}';
    }
}
