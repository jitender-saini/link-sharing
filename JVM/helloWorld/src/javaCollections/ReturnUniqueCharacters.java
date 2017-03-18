package javaCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Q2 Write a method that takes a string and returns the number of unique characters in the string.

public class ReturnUniqueCharacters {

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a String  : ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Number of Unique characters : " + getUniqueChars(br.readLine()));
        //System.out.println("Number of Unique characters : " +getUniqueCharactersUsingJava8(br.readLine()));
        System.out.println("Number of Unique characters : " +getUniqueCharactersUsingCharAt(br.readLine()));
    }


    private static int getUniqueChars(String s){
        int count_char=0;
        int arr[]=new int[128];

        for(int count=0;count<s.length();count++)
            arr[s.charAt(count)]++;

        for(int count=0;count<128;count++){
            if(arr[count]==1)count_char++;

        }

        return count_char;
    }
    public static long getUniqueCharactersUsingJava8(String input) {
        return input.chars()
                .distinct()
                .count();
    }

    public static int getUniqueCharactersUsingCharAt(String input) {
        String uniqueChar = "";
        for (int i = 0; i < input.length(); i++) {
            if (!uniqueChar.contains(String.valueOf(input.charAt(i)))) {
                uniqueChar += input.charAt(i);
            }
        }
        return uniqueChar.length();
    }
}
