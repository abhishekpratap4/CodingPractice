package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pratap on 1/1/17.
 */
public class RotatedSortedArray {
    public static void main(String[] args) {
        Integer[] arr = {3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2};
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(search(list, 2));
    }

    public static int search(final List<Integer> list, int n) {
        int pivotIndex = 0;

        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < high && list.get(mid) > list.get(mid + 1)) {
                pivotIndex = mid;
                break;
            } else if (mid > low && list.get(mid) < list.get(mid - 1)) {
                pivotIndex = mid;
                break;
            } else if (list.get(low) >= list.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        System.out.println("PivotIndex: " + pivotIndex);

        if (pivotIndex == 0) {
            return binarySearch(list, n, 0, list.size() - 1);
        } else if (n >= list.get(0) && n <= list.get(pivotIndex - 1)) {
            return binarySearch(list, n, 0, pivotIndex - 1);
        } else {
            return binarySearch(list, n, pivotIndex, list.size() - 1);
        }
    }

    public static int binarySearch(List<Integer> list, int n, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
//            System.out.println("low: " + low + " & high: " + high);
//            System.out.println("mid: " + mid);
            if (list.get(mid) == n) {
                return mid;
            } else if (list.get(mid) > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


}
