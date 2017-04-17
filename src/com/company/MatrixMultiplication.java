package com.company;

/**
 * Created by pratap on 2/19/17.
 */

/* A naive recursive implementation that simply follows
the above optimal substructure property */
public class MatrixMultiplication {
    static int DP[][];

    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int MatrixChainOrder(int p[], int i, int j) {
        if (i == j)
            return 0;

        int min = Integer.MAX_VALUE;

        // place parenthesis at different places between first
        // and last matrix, recursively calculate count of
        // multiplications for each parenthesis placement and
        // return the minimum count
        for (int k = i; k < j; k++) {
            int count = MatrixChainOrder(p, i, k) +
                    MatrixChainOrder(p, k + 1, j) +
                    p[i - 1] * p[k] * p[j];

            if (count < min)
                min = count;
        }

        // Return minimum count
        return min;
    }

    static int MatrixChainOrderMemoized(int p[], int i, int j) {
        if (i == j)
            return 0;

        if (DP[i][j] != 0)
            return DP[i][j];

        int min = Integer.MAX_VALUE;

        // place parenthesis at different places between first
        // and last matrix, recursively calculate count of
        // multiplications for each parenthesis placement and
        // return the minimum count
        for (int k = i; k < j; k++) {
            int count = MatrixChainOrderMemoized(p, i, k) +
                    MatrixChainOrderMemoized(p, k + 1, j) +
                    p[i - 1] * p[k] * p[j];

            if (count < min) {
                min = count;
            }
            DP[i][j] = min;
        }

        // Return minimum count
        return min;
    }

    // Driver program to test above function
    public static void main(String args[]) {
        int arr[] = new int[]{100, 200, 300, 400, 300, 500, 600, 300, 800, 900, 100, 200, 300, 400, 300, 500, 600, 300, 800, 900,1000};
        int n = arr.length;
        DP = new int[n][n];
        long start = System.currentTimeMillis();
        System.out.println("Minimum number of multiplications is " + MatrixChainOrderMemoized(arr, 1, n - 1));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        start = System.currentTimeMillis();
        System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, 1, n - 1));
        end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
