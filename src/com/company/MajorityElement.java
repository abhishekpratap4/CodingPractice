package com.company;

import java.util.HashMap;

/**
 * Created by pratap on 10/8/16.
 * Solved using HashMap
 */
public class MajorityElement {

    public static void getMajorityElement() {
        int[] arr = Utilities.getArray();
        HashMap map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            } else {
                map.replace(arr[i], (int)map.get(arr[i])+1);
            }

            int count = (int) map.get(arr[i]);
            System.out.println("Count is: " + count);
            if (count == (arr.length/2)+1) {
                System.out.println("Majority Element is: " + arr[i]);
                return;
            }
        }
        System.out.println("NO Majority Element present");
    }
}
