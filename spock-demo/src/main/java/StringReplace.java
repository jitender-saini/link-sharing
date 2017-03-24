import java.util.Scanner;

public class StringReplace {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String firstSrt, secondStr, thirdStr;
        System.out.println("Enter a string: ");
        firstSrt = sc.next();
        System.out.println("Enter the string to be replaced: ");
        secondStr = sc.next();
        System.out.println("Enter the new string: ");
        thirdStr = sc.next();

        String result = getReplacedString(new String[]{firstSrt, secondStr, thirdStr});

        System.out.println(result);
        sc.close();


    }

    public static String getReplacedString(String firstStr[]) {
        return firstStr[0].replace(firstStr[1], firstStr[2]);
    }
}
