package coreJava;

import java.util.Scanner;

// Q1 Write a program to replace a substring inside a string with other string ?

public class StringReplace {
	public static void main(String[] args){
		String str,subStr,replace;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string :");
		str=sc.nextLine();
		System.out.println("Enter the substring :");
		subStr=sc.nextLine();
		System.out.println("Enter the string to replace :");
		replace=sc.nextLine();
		System.out.println("Replaced string :" + str.replace(subStr, replace));
	}
}
