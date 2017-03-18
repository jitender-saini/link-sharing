package coreJava;

import java.util.Scanner;

/* Q11 Write a single program for following operation using overloading
 A) Adding 2 integer number
 B) Adding 2 double
 C) Multiplying 2 float
 d) Multiplying 2 int
 E) concatenate 2 string
 F) Concatenate 3 String*/

public class OverloadingExercise {
    public double operation(double a, double b) {
        return a + b;
    }

    public float operation(float a, float b) {
        return a * b;
    }

    public String operation(String a, String b, String c) {
        String s = a.concat(b);
        String res = s.concat(c);
        return res;
    }

    public String operation(String a, String b) {
        String s = a.concat(b);
        return s;
    }

    public int operation(int a, int b) {
        return a + b;
    }

    public int multiplyInt(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        int value;
        Scanner sc = new Scanner(System.in);
        OverloadingExercise oe = new OverloadingExercise();
        System.out.println("1. Add integers");
        System.out.println("2. Multiply integers");
        System.out.println("3. Add doubles");
        System.out.println("4. Multiply floating values");
        System.out.println("5. Two string concatenation");
        System.out.println("6. Three string concatenation");
        System.out.println("Enter your Choice");
        value = sc.nextInt();
        sc.nextLine();
        switch (value) {
            case 1:
                int num1, num2;
                System.out.println("Enter two integers to be added :");
                num1 = sc.nextInt();
                num2 = sc.nextInt();
                System.out.println("Addition of 2 integers : " + oe.operation(num1, num2));
                break;
            case 2:
                int mnum1, mnum2;
                System.out.println("Enter two integer value to be multiplied :");
                mnum1 = sc.nextInt();
                mnum2 = sc.nextInt();
                System.out.println("Multiplication of 2 values : " + oe.multiplyInt(mnum1, mnum2));
                break;
            case 3:
                double dd1, dd2;
                System.out.println("Enter two decimal values to be added :");
                dd1 = sc.nextDouble();
                dd2 = sc.nextDouble();
                System.out.println("Addition of 2 double values : " + oe.operation(dd1, dd2));
                break;
            case 4:
                float f1, f2;
                System.out.println("Enter two floating values to be multiplied :");
                f1 = sc.nextFloat();
                f2 = sc.nextFloat();
                System.out.println("Multiplication of 2 floating points : " + oe.operation(f1, f2));
                break;
            case 5:
                String str1, str2;
                System.out.println("Enter two strings to combine :");
                str1 = sc.nextLine();
                str2 = sc.nextLine();
                System.out.println("Concatenated strings : " + oe.operation(str1, str2));
                break;
            case 6:
                String sstr1, sstr2, str3;
                System.out.println("Enter two strings to combine :");
                sstr1 = sc.nextLine();
                sstr2 = sc.nextLine();
                str3 = sc.nextLine();
                System.out.println("Concatenated strings : " + oe.operation(sstr1, sstr2, str3));
                break;
            default:
                System.out.println("Select a valid option!!!");
        }
    }
}
