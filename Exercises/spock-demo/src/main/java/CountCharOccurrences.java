import java.util.Scanner;

public class CountCharOccurrences {
    public static void main(String[] args) {
        String str ;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a String");
        str=sc.nextLine();
        System.out.println("Enter a Character");
        String chr=sc.next();
        System.out.println("Number of occurrences of "+chr+" is :"+countDuplicate(str,chr));
    }
    public static int countDuplicate(String str, String chr){
        int charCount = str.length() - str.replaceAll(chr, "").length();
        return charCount;
    }
}