import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Q4 Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String
public class PercentageOfCharacters {
    static Map characterPercentage(String inputString){
        int length = inputString.length();
        DecimalFormat df = new DecimalFormat("##.#");
        int upperCaseLetters = 0, lowerCaseLetters = 0, digits = 0, others = 0;
        Map<String,Double> map=new HashMap<>();
        for (int i = 0; i < inputString.length(); i++){
            char ch = inputString.charAt(i);
            if(Character.isUpperCase(ch))
                upperCaseLetters++;
            else if(Character.isLowerCase(ch))
                lowerCaseLetters++;
            else if (Character.isDigit(ch))
                digits++;
            else
                others++;
        }
        map.put("Uppercase",Double.parseDouble(df.format((double)(upperCaseLetters * 100) / length)));
        map.put("Lowercase",Double.parseDouble(df.format((double)(lowerCaseLetters * 100) / length)));
        map.put("Digits",Double.parseDouble(df.format((double)(digits * 100) / length)));
        map.put("Other",Double.parseDouble(df.format((double)(others * 100) / length)));
        return map;
    }

    public static Map getPercentage(String s){
        HashMap<String,Double> map=new HashMap();
        DecimalFormat df = new DecimalFormat("##.#");
        int length=s.length();
        int digits=0,upperCaseLetters=0,lowerCaseLetters=0,others=0;
        for (int count=0;count<length;count++){
            int ascii_code=s.charAt(count);
            if(ascii_code>=48 && ascii_code<=57)
                digits++;
            else if(ascii_code>=65 && ascii_code<=90)
                upperCaseLetters++;
            else if(ascii_code>=97 && ascii_code<=122)
                lowerCaseLetters++;
            else others++;
        }
        map.put("Uppercase",Double.parseDouble(df.format((double)(upperCaseLetters * 100) / length)));
        map.put("Lowercase",Double.parseDouble(df.format((double)(lowerCaseLetters * 100) / length)));
        map.put("Digits",Double.parseDouble(df.format((double)(digits * 100) / length)));
        map.put("Other",Double.parseDouble(df.format((double)(others * 100) / length)));
        return map;
    }

    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        Map<String,Double> map;
        Map<String,Double> map2;
        System.out.println("Enter characters special symbols numbers :");
        map = characterPercentage(sc.nextLine());
        for(Map.Entry m:map.entrySet()){
            System.out.println(m.getValue()+"% "+m.getKey());
        }

        System.out.println("Enter characters special symbols numbers again :");
        map2 = getPercentage(sc.nextLine());
        for(Map.Entry m:map2.entrySet()){
            System.out.println(m.getValue()+"% "+m.getKey());
        }
    }
}