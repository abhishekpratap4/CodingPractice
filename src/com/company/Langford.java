package com.company;

import java.util.Arrays;

/**
 * Created by pratap on 6/22/17.
 */
public class Langford {
    static int counter = 0;

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        int n = 4;
        int[] a = new int[2 * n];
        findLangford(a, n);
        System.out.println("Counter : " + counter);
    }

    static boolean findLangford(int[] arr, int n) {
        if (n == 0) {
            System.out.println(Arrays.toString(arr));
            return true;
        }
        for (int i = 0; i < arr.length - n - 1; i++) {
            if (arr[i] == 0 && arr[i + n + 1] == 0) { //empty slot
                counter++;
                arr[i] = n;
                arr[i + n + 1] = n;
//                findLangford(arr, n - 1);
                if (findLangford(arr, n - 1))
                    return true;
                arr[i] = 0;
                arr[i + n + 1] = 0; //undo
            }
        }
        return false;
    }
}
