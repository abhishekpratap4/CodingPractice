package com.company;

/**
 * Created by pratap on 5/10/17.
 */
public class RotatedArray {
    public static void main(String[] args) {
        //int arr[] = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        //int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //int arr[] = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        int arr[] = {8, 9, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;

        if (arr.length == 1)
            return arr[0];

        int low = 0;
        int high = arr.length - 1;

        if (arr[low] < arr[high])
            return arr[low];

        while (low <= high) {
            if (high - low == 1) {
                return arr[high];
            }

            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high])
                low = mid;
            else
                high = mid;
        }

        return arr[low];
    }
}
