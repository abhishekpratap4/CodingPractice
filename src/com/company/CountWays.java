package com.company;
import java.util.*;

/**
 * Created by pratap on 2/20/17.
 * http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 */
public class CountWays {
    static int DP[];

    // Simple recursion no memoization
    static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    // A simple recursive program to find n'th fibonacci number
    static int fibMemoized(int n) {
        if (DP[n] != 0)
            return DP[n];
        else {
            if (n <= 1)
                return n;

            int f = fibMemoized(n - 1) + fibMemoized(n - 2);
            DP[n] = f;
            return f;
        }
    }

    // Returns number of ways to reach s'th stair
    static int countWaysMemoized(int s) {
        return fibMemoized(s + 1);
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s) {
        return fib(s + 1);
    }

    /* Driver program to test above function */
    public static void main(String args[]) {
        int s = 10;
        DP = new int[s + 2]; // s+2 will create array with index till s+1
        System.out.println("Number of ways = " + countWaysMemoized(s));
        System.out.println("Number of ways = " + countWays(s));
    }
}

