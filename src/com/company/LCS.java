package com.company;

import java.util.Arrays;

/**
 * Created by pratap on 4/8/17.
 */
public class LCS {
    public static void main(String[] args) {
        String X = "398397970";
        String Y = "3399917206";
        int DP[][] = new int[X.length()][Y.length()];
        //System.out.println(LCS.findLCSLength(X, Y, X.length(), Y.length()));
        int length = LCS.findLCSLengthMemoized(X, Y, X.length(), Y.length(), DP);
        System.out.println(length);

        char result[] = new char[length];
        int index = length - 1;
        int i = X.length() - 1, j = Y.length() - 1;
        while (i >= 0 && j >= 0) {
            if (X.charAt(i) == Y.charAt(j)) {
                result[index] = X.charAt(i);
                i--;
                j--;
                index--;
            } else if (DP[i - 1][j] > DP[i][j - 1]) {
                i = i - 1;
            } else {
                j = j - 1;
            }
        }
        System.out.println(Arrays.toString(result));
    }

    private static int findLCSLength(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        else if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + findLCSLength(X, Y, m - 1, n - 1);

        else
            return Math.max(findLCSLength(X, Y, m, n - 1), findLCSLength(X, Y, m - 1, n));

    }

    private static int findLCSLengthMemoized(String X, String Y, int m, int n, int DP[][]) {
        if (m == 0 || n == 0)
            return 0;

        if (DP[m - 1][n - 1] != 0)
            return DP[m - 1][n - 1];

        if (X.charAt(m - 1) == Y.charAt(n - 1))
            DP[m - 1][n - 1] = 1 + findLCSLengthMemoized(X, Y, m - 1, n - 1, DP);

        else
            DP[m - 1][n - 1] = Math.max(findLCSLengthMemoized(X, Y, m, n - 1, DP), findLCSLengthMemoized(X, Y, m - 1, n, DP));

        int length = DP[m - 1][n - 1];
        return length;
    }


}
