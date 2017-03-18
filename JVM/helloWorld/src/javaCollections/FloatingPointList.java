package javaCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
// Q1 Write Java code to define List . Insert 5 floating point numbers in List, and using an iterator, find the sum of the numbers in List.
public class FloatingPointList {
    public static void main(String[] args) throws IOException {

        ArrayList<Float> list =new ArrayList<>();

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int count=1;
        while(count<6){
            System.out.print("Enter any float number " +count++ + " : " );
            list.add(Float.parseFloat(br.readLine()));
        }

        Iterator<Float> iterator=list.iterator();
        float sum=0;
        while(iterator.hasNext()){
            sum += iterator.next();
        }

        System.out.println("sum : " + sum);
    }
}
