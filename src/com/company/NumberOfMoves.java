package com.company;

import java.util.Scanner;

/**
 * Created by pratap on 5/16/17.
 */
public class NumberOfMoves {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = Math.max(x, p) + 1;
        int c = Math.max(y, q) + 1;

        System.out.println(countWays(r, c, x, y, p, q));
    }

    private static int countWays(int r, int c, int x, int y, int p, int q) {
        int DP[][] = new int[r][c];
        for (int i = x; i < r; i++)
            DP[i][y] = 1;

        for (int j = y; j < c; j++)
            DP[x][j] = 1;

        for (int i = x + 1; i < r; i++) {
            for (int j = y + 1; j < c; j++) {
                DP[i][j] = DP[i - 1][j] + DP[i][j - 1];
            }
        }
        return DP[p][q] == 0 ? -1 : DP[p][q];
    }
}