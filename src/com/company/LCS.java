package com.company;

/**
 * Created by pratap on 4/8/17.
 */
public class LCS {
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "AGGTAB";
        int DP[][] = new int[X.length()][Y.length()];
        System.out.println(LCS.findLCSLength(X, Y, X.length(), Y.length()));
        System.out.println(LCS.findLCSLengthMemoized(X, Y, X.length(), Y.length(), DP));
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

        else if (X.charAt(m - 1) == Y.charAt(n - 1))
            DP[m-1][n-1] = 1 + findLCSLength(X, Y, m - 1, n - 1);

        else
            DP[m-1][n-1] = Math.max(findLCSLength(X, Y, m, n - 1), findLCSLength(X, Y, m - 1, n));

        return DP[m-1][n-1];
    }
}
