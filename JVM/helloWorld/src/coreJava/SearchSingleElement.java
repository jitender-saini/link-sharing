package coreJava;

// Q6 There is an array with every element repeated twice except one. Find that element?

import java.util.HashSet;
import java.util.Set;

public class SearchSingleElement {
    public static void findSingleElement(int[] arr) { // this method will display every single element in the array
        int distinct = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] )
                    distinct++;
            }
            if(distinct==1)
                System.out.println("Element which appears only once in array is : "+arr[i]);
            distinct = 0;
        }
    }

    public static int findSingle(int[] array) {  //displaying array with every element repeated twice except one.
        Set<Integer> set = new HashSet<>();
        for (int item : array) {
            if (!set.remove(item)) {
                set.add(item);
            }
        }
        assert set.size() == 1;
        System.out.println(set.iterator().next());
        return set.iterator().next();
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,2,2,8,3,3,4,5,5,5,8,7};
        int[] arr2 = {1,2,2,3,3,4,4,5,8,5};
        findSingle(arr2);
        findSingleElement(arr);
    }
}


