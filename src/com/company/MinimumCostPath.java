package com.company;

/**
 * Created by pratap on 2/20/17.
 */
/* Java program for Dynamic Programming implementation
of Min Cost Path problem */

import java.util.*;

class MinimumCostPath {

    static int DP[][];

    /* A utility function that returns minimum of 3 integers */
    private static int min(int x, int y, int z) {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

    private static int minCost(int cost[][], int m, int n) {
        int i, j;
        int tc[][] = new int[m + 1][n + 1];

        tc[0][0] = cost[0][0];

		/* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i - 1][0] + cost[i][0];

		/* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j - 1] + cost[0][j];

		/* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i - 1][j - 1],
                        tc[i - 1][j],
                        tc[i][j - 1]) + cost[i][j];

        return tc[m][n];
    }

    //Recursive approach
    public static int minCostRecursive(int cost[][], int m, int n) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;

        if (m == 0 && n == 0)
            return cost[0][0];
        else {
            return cost[m][n] + min(minCostRecursive(cost, m, n - 1), minCostRecursive(cost, m - 1, n - 1), minCostRecursive(cost, m - 1, n));
        }

    }

    //Recursive approach - Memoized
    public static int minCostRecursiveMemoized(int cost[][], int m, int n) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;

        if (m == 0 && n == 0)
            return cost[0][0];

        if (DP[m][n] != 0)
            return DP[m][n];
        else {
            DP[m][n] = cost[m][n] + min(minCostRecursiveMemoized(cost, m, n - 1), minCostRecursiveMemoized(cost, m - 1, n - 1), minCostRecursiveMemoized(cost, m - 1, n));
            return DP[m][n];
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        int cost[][] = {
                {1, 2, 3, 4, 5},
                {4, 8, 2, 22, 3},
                {1, 5, 13, 6, 7},
                {1, 15, 3, 6, 7},
                {1, 5, 3, 16, 67},
        };
        System.out.println("minimum cost to reach (2,2) = " +
                minCost(cost, 4, 4));
        System.out.println("minimum cost to reach (2,2) = " +
                minCostRecursive(cost, 4, 4));

        DP = new int[cost.length][cost[0].length];
        System.out.println("minimum cost to reach (2,2) = " +
                minCostRecursiveMemoized(cost, 4, 4));
    }
}