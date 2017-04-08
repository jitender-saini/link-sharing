package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONParsing {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Company company = mapper.readValue(new File("src/organisation.json"), Company.class);
        TTN ttn = company.getTtn();
        Department[] departments = ttn.getDepartment();
        for (Department department : departments) {
            System.out.println("----------------------------------------");
            Competency[] competencies = department.getCompetency();
            System.out.println("Department Name:" + department.getName());
            for (Competency competency : competencies) {
                System.out.println("**************************************");
                System.out.println("Competency Name:" + competency.getName());
                System.out.println("Competency Head:" + competency.getHead());
                System.out.println("Employees:" + competency.getEmployees());
            }
        }

    }
}
