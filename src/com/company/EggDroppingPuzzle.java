package com.company;

/**
 * Created by pratap on 2/20/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 */
public class EggDroppingPuzzle {
    static int DP[][];

    // Recursive
    static int eggDrop(int eggs, int floors) {
        if (floors == 1 || floors == 0)
            return floors;

        if (eggs == 1)
            return floors;

        int min = Integer.MAX_VALUE, res, x;

        for (x = 1; x <= floors; x++) {
            res = Math.max(eggDrop(eggs - 1, x - 1), eggDrop(eggs, floors - x));
            if (res < min)
                min = res;
        }
        // System.out.print(min + 1);
        return min + 1;
    }

    // Memoized
    static int eggDropMemoized(int eggs, int floors) {
        if (floors == 1 || floors == 0) {
            DP[eggs][floors] = floors;
            return floors;
        }

        if (eggs == 1) {
            DP[eggs][floors] = floors;
            return floors;
        }

        if (DP[eggs][floors] != 0)
            return DP[eggs][floors];

        int min = Integer.MAX_VALUE, x, res;

        for (x = 1; x <= floors; x++) {
            res = Math.max(eggDropMemoized(eggs - 1, x - 1), eggDropMemoized(eggs, floors - x));
            if (res < min) {
                min = res;
            }
            DP[eggs][floors] = min + 1;
        }
        // System.out.print(min + 1);
        return DP[eggs][floors];
    }

    public static void main(String[] args) {
        int n = 5, k = 100;
        DP = new int[n + 1][k + 1];

        System.out.println("Minimum trials required: " + eggDropMemoized(n, k));
        System.out.println("Minimum trials required: " + eggDrop(n, k));
    }
}

