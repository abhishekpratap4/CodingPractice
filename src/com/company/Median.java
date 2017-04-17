package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by pratap on 10/8/16.
 */
public class Median {

    public static void getMedian() {
        int arr1[] = {1, 12, 15, 26, 38}; //Utilities.getArray();
        int arr2[] = {2, 13, 17, 30, 45}; //Utilities.getArray();
        int size = arr1.length + arr2.length;
        int arr3[] = new int[size];

        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        int j = arr1.length;
        for (int i = 0; i < arr2.length; i++) {
            arr3[j] = arr2[i];
            j++;
        }

        Arrays.sort(arr3);
        int median = (arr3[arr3.length/2] + arr3[(arr3.length/2)-1])/2;
        System.out.print(median);
    }
}
