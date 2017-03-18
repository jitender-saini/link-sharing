package coreJava;

import java.util.Scanner;

// Q4 Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String
public class PercentageOfCharacters {
    static void characterPercentage(String inputString){
        int totalChars = inputString.length();
        int upperCaseLetters = 0;
        int lowerCaseLetters = 0;
        int digits = 0;
        int others = 0;
        for (int i = 0; i < inputString.length(); i++){
            char ch = inputString.charAt(i);
            if(Character.isUpperCase(ch)){
                upperCaseLetters++;
            }
            else if(Character.isLowerCase(ch)){
                lowerCaseLetters++;
            }
            else if (Character.isDigit(ch)){
                digits++;
            }
            else {
                others++;
            }
        }
        System.out.println("In '"+inputString+"' : ");
        System.out.println("Uppercase letters are "+((upperCaseLetters * 100) / totalChars)+"% ");
        System.out.println("Lowercase letters are "+((lowerCaseLetters * 100) / totalChars)+"%");
        System.out.println("Digits Are "+((digits * 100) / totalChars)+"%");
        System.out.println("Other Characters Are "+((others * 100) / totalChars)+"%");
    }

    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter characters special symbols numbers :");
        characterPercentage(sc.nextLine());
    }
}