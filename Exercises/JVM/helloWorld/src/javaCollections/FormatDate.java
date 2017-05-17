package javaCollections;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Q8 Write a program to format date as example "21-March-2016"
public class FormatDate {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Format: " + date.format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
    }
}
