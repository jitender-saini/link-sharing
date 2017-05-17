package coreJava;
// Q2 Write a program to find the number of occurrences of the duplicate words in a string and print them ?

import java.util.Scanner;

public class PrintDuplicateWords {
	public static void findDuplicate(String str) {
		int distinct = 0;
		str=str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))
					distinct++;
			}
			if(distinct>1)
			System.out.println("Number of occurrences of "+str.charAt(i) + ":" + distinct);
			String duplicate = String.valueOf(str.charAt(i)).trim();
			str = str.replaceAll(duplicate, "");
			distinct = 0;
		}
	}

	public static void findDuplicate2(String str){
        char Char;
        int distinct;
        str = str.toLowerCase();
        for (Char = 'a'; Char <= 'z'; Char++) {
            distinct = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == Char) {
                    distinct++;
                }
            }
            if(distinct>1)
            System.out.println("Number of occurrences of " + Char + " is " + distinct);
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a String :");
        //findDuplicate(sc.nextLine());
        findDuplicate2(sc.nextLine());
    }

}
