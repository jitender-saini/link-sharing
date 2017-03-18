package javaCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

// Q6 Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.

public class DecresingFrequency {
    public static void main(String[] args) {
        int array[] = new int[]{6, 2 ,6 ,7 ,9, 2,6 ,2, 3, 3, 4, 3, 2, 2, 1, 5, 2, 3, 4, 5, 5};

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (Integer a : array) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        ArrayList<MyObject> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            list.add(new MyObject(m.getKey(), m.getValue()));
        }

        Collections.sort(list);

        printList(list);

    }

    private static void printList(ArrayList<MyObject> list) {
        for (MyObject object : list) {
            System.out.println("Number : " + object.num + "   || Frequency : " + object.freq);
        }
    }


    static class MyObject implements Comparable<MyObject> {

        int num, freq;

        MyObject(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }


        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(MyObject o) {
            return o.freq - this.freq;
        }


        @Override
        public String toString() {
            return " freq : " + freq + " num : " + num;
        }
    }
}