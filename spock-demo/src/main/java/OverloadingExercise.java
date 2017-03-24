import java.text.DecimalFormat;
import java.util.Scanner;

public class OverloadingExercise{
    private static DecimalFormat df = new DecimalFormat(".##");
    public static double operation(double a, double b) {
        return Double.parseDouble(df.format((a+b)));
    }

    public static float operation(float a, float b) {
        return a + b;
    }

    public static String operation(String a, String b) {
        String s = a.concat(b);
        return s;
    }

    public static int operation(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first input");
        int input1 = sc.nextInt();
        System.out.println("Enter second input");
        int input2 = sc.nextInt();
        System.out.println("sum of int: "+operation(input1, input2));
        System.out.println("sum of Double: "+operation(22.3, 77.1));
        System.out.println("sum of float: "+operation(55f, 3f));
        System.out.println("Concatenate String: "+operation("hello", "friends"));

    }
}