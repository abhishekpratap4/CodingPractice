package com.company;

/**
 * Created by pratap on 5/16/17.
 */
public class KadaneAlgo {
    public static void main(String[] args) {
        int[] A = {-2, -3, 4, -1, -2, 1, 5, 2};
        getMaxSum(A);
    }

    private static void getMaxSum(int[] A) {
        int overallMax = A[0], currentMax = A[0];
        int start = 0, temp_start = 0, end = 0;
        for (int i = 1; i < A.length; i++) {
            if (currentMax + A[i] > A[i]) {
                currentMax = currentMax + A[i];
            } else {
                currentMax = A[i];
                temp_start = i;
            }
            if (overallMax < currentMax) {
                overallMax = currentMax;
                start = temp_start;
                end = i;
            }
        }
        System.out.println("Max sum: " + overallMax);
        System.out.println("start index: " + start + " and end index: " + end);
    }
}
