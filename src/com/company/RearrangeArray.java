package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pratap on 12/9/16.
 */
public class RearrangeArray {
    public static void main(String[] arsg) {

        Integer arr[] = {6, 4, 3, 2, 5, 1, 7, 0};
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arr));
        rearrange(arrList);
        //recursiveRearrange(arr);
    }

    public static void rearrange(ArrayList<Integer> arr) {
        if (arr.size() <= 0)
            return;

        System.out.print(arr+"\n");

        for(int i = 0;i<arr.size();i++){
            arr.set(i, arr.get(i) + (arr.get(arr.get(i)) % arr.size()) * arr.size());
        }

        System.out.print(arr+"\n");

        for(int i = 0;i<arr.size();i++){
            arr.set(i,arr.get(i)/arr.size());
        }

        System.out.print(arr+"\n");

    }

    public static int recursiveRearrange(int arr[]) {
        return 0;
    }
}
