package java8iO;

import java.util.Arrays;
import java.util.Scanner;

public class TableUsingLambdaExp {

    public static void main(String[] args) {
        TableUsingLambdaExp test = new TableUsingLambdaExp();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number:");
        int n = s.nextInt();
        MathOperation table = (a, b) -> a * b;
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = "+test.operate(i, n, table));
        }
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}