// Q2 Write a program to find the number of occurrences of the duplicate words in a string and print them ?

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintDuplicateWords {
	static Map findDuplicate(String str) {
		int distinct = 0;
		str=str.toLowerCase();
        Map<Character,Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))
					distinct++;
			}
			if(distinct>1)
			    map.put(str.charAt(i),distinct);
			//System.out.println("Number of occurrences of "+str.charAt(i) + ":" + distinct);
			String duplicate = String.valueOf(str.charAt(i)).trim();
			str = str.replaceAll(duplicate, "");
			distinct = 0;
		}
        return map;
	}

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a String :");
        Map<Character,Integer> map;
        map = findDuplicate(sc.nextLine());
        for(Map.Entry m:map.entrySet()){
            System.out.println("Number of occurrence of :"+m.getKey()+" "+m.getValue());
        }
    }

}
