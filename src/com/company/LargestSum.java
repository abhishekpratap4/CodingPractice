package com.company;

import java.util.Scanner;

/**
 * Created by pratap on 10/8/16.
 * Largest sum contiguous sub array.
 */
public class LargestSum {

    public static void findSum() {
        int arr[] = getArray();
        int max_till_now = 0, max_end = 0, s = 0, e = 0;

        for (int i = 0; i < arr.length; i++) {
            max_end = max_end + arr[i];
            if (max_end < 0) {
                max_end = 0;
                s = i + 1;
            } else if (max_till_now < max_end) {
                max_till_now = max_end;
                e = i;
            }
        }

        System.out.println("Sum is : " + max_till_now);
        System.out.println("Array is : ");
        for (int j = s; j < arr.length && j <= e; j++) {
            System.out.print(arr[j]+"\t");
        }
    }

    private static int[] getArray() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
