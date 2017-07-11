package com.company;

import java.util.Arrays;

/**
 * Created by pratap on 5/16/17.
 */
public class MultiplicationProblem {
    public static void main(String[] args) {
        int[] A = {10, 2, 3, 4};
        //int[] A = {10, 2, -3, 4, 100};
        //int[] A = {10, 2, -3, 0, 100};

        generateMultiplicativeArray(A);
    }

    private static void generateMultiplicativeArray(int[] a) {
        int[] B = new int[a.length];

        // initialize initial value as 1 at all indices
        Arrays.fill(B, 1);

        int leftCumulativeProduct = 1, rightCumulativeProduct = 1;

        for (int i = 0; i < a.length; i++) {
            B[i] = leftCumulativeProduct;
            leftCumulativeProduct = leftCumulativeProduct * a[i];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            B[i] = B[i] * rightCumulativeProduct;
            rightCumulativeProduct = rightCumulativeProduct * a[i];
        }

        System.out.print(Arrays.toString(B));
    }
}
