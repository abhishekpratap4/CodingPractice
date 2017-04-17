package com.company;

import java.util.LinkedList;

/**
 * Created by pratap on 10/8/16.
 */
public class RangeGenerator {
    public static void getRange() {
        LinkedList<String> list = new LinkedList<String>();
        int[] arr = {1,2,3,4,5,8,9,10,11,13,15,16,19}; //Utilities.getArray();
        int start = arr[0], end = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                end = arr[i - 1];
                list.add(start == end ? start + "" : start + " - " + end );
                //System.out.print(start + " - " + end + "\t");
                start = end = arr[i];
            }
        }
        end = arr[arr.length - 1];
        list.add(start == end ? start + "" : start + " - " + end);

        System.out.print(list);
    }
}
