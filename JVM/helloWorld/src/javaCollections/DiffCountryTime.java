package javaCollections;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

// Q9 Write a program to display times in different country format.
public class DiffCountryTime {
    public static void main(String[] args) throws ParseException {
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL, new Locale("it", "ch"));
        System.out.println("Italian : "+f.format(new Date()));
        f = DateFormat.getDateInstance(DateFormat.FULL, new Locale("us", "US"));
        System.out.println("English :  " + f.format(new Date()));
        f = DateFormat.getDateInstance(DateFormat.FULL, new Locale("uk", "ch"));
        System.out.println("Ukrainian : "+f.format(new Date()));
    }
}
