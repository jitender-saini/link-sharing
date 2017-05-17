package coreJava;

import java.util.Scanner;

// Q3 Write a program to find the number of occurrences of a character in a string without using loop?

public class CountCharOccurrences {
	public static void main(String[] args) {
		String str ;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a String");
		str=sc.nextLine();
		System.out.println("Enter a Character");
		String chr=sc.next();
		int charCount = str.length() - str.replaceAll(chr, "").length();
		System.out.println("Number of occurrences of "+chr+" is :"+charCount);
	}
}
