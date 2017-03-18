package javaCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// Q3 Write a method that takes a string and print the number of occurrence of each character characters in the string.

public class OccurrenceOfUniqueChar {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a String : ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        getOccurrences(br.readLine());
    }

    private static void getOccurrences(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int count=0;count<s.length();count++){
            char character=s.charAt(count);
            if(map.containsKey(character)){
                map.put(character,map.get(character)+1);
            }else map.put(character,1);
        }
        for(Map.Entry<Character,Integer> iterate:map.entrySet())
            System.out.println(" character " + iterate.getKey() + " occurs " + iterate.getValue() + " times " );
    }
}
