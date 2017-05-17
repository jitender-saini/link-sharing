// Q6 There is an array with every element repeated twice except one. Find that element?

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SearchSingleElement {
    public static ArrayList findSingleElements(ArrayList<Integer> arr) { // this method will display every single element in the array
        int distinct = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int anArr : arr) {
            for (int anArr1 : arr) {
                if (anArr == anArr1)
                    distinct++;
            }
            if (distinct == 1) {
                list.add(anArr);
            }
            distinct = 0;
        }
        return list;
    }

    public static int findSingle(ArrayList<Integer> array) {  //displaying array with every element repeated twice except one.
        Set<Integer> set = new HashSet<>();
        for (int item : array) {
            if (!set.remove(item)) {
                set.add(item);
            }
        }
        assert set.size() == 1;
        return set.iterator().next();
    }

    public static int findSingleElement(ArrayList<Integer> arr) {
        int xor = 0;

        for (int i = 0; i < arr.size(); i++) {
            xor ^= arr.get(i);
        }
        return xor;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list =new  ArrayList<>();
        list.add(2);
        list.add(10);
        list.add(3);
        list.add(10);
        list.add(3);

        ArrayList<Integer> list3 =new  ArrayList<>();
        list3.add(3);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);
        list3.add(6);
        list3.add(7);

        //System.out.println("Single element in array using Sets : "+findSingle(list));

        ArrayList<Integer> list2 = findSingleElements(list3);
        for (Object aList : list2)
            System.out.println("Element which appears only once in array is : " + aList);

        System.out.println("Single element in array using XOR Operator : "+findSingleElement(list));
    }
}

