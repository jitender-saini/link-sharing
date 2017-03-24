import java.util.Scanner;

public class ReverseRemove {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        System.out.println(reverseString(sc.nextLine()));
    }

    public static String reverseString(String s) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        if (sb.length() > 9)
            sb.replace(4, 9 , "");
        else
            System.out.println("String length is less than 10");
        return sb.toString();
    }
}
