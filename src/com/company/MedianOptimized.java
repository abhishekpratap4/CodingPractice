package com.company;

/**
 * Created by pratap on 4/16/17.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MedianOptimized {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n = 11;
        int arr[] = {11, 9, 8, 6, 4, 1, 3, 2, 5, 7, 10};

        int start = 0, end = n - 1, index = n / 2, p;
        if (n == 1)
            System.out.println(arr[0]);

        while (start < end) {
            p = MedianOptimized.partition(arr, start, end);
            if (p == index) {
                System.out.println(arr[p]);
                return;
            } else if (p < index)
                start = p + 1;
            else
                end = p - 1;
        }
        System.out.println(arr[start]);
    }

    private static int partition(int[] arr, int low, int high) {
        if (low == high)
            return arr[low];
        int i = low - 1, pivot = arr[high];
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}