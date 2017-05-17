import java.util.ArrayList;

public class CommonElements {
    public static ArrayList countCommon(int[] arr1,int[] arr2){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr1.length;i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    list.add(arr1[i]);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6,7,8,9,12,23,51,230,33};
        int[] arr2={5,7,5,6,7,8,9,12,8,9,10,89,230,32};
        System.out.println("Common elements between two arrays : "+countCommon(arr1, arr2));
    }
}