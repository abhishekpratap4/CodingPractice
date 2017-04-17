package com.company;

/**
 * Created by pratap on 4/8/17.
 */
public class MinCostPath {

    static int DP[][] = new int[3][3];

    public static void main(String[] rags) {
        int matrix[][] = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        System.out.println(MinCostPath.minCost(matrix, 2, 2));
        System.out.println(MinCostPath.minCostMemoized(matrix, 2, 2));
    }

    private static int minCost(int cost[][], int m, int n) {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] + Math.min(minCost(cost, m - 1, n - 1),
                    Math.min(minCost(cost, m - 1, n), minCost(cost, m, n - 1)));
    }

    private static int minCostMemoized(int cost[][], int m, int n) {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            DP[m][n] = cost[m][n];
        else if (DP[m][n] != 0)
            return DP[m][n];
        else
            DP[m][n] = cost[m][n] + Math.min(minCostMemoized(cost, m - 1, n - 1),
                    Math.min(minCostMemoized(cost, m - 1, n), minCostMemoized(cost, m, n - 1)));
        return DP[m][n];
    }
}
