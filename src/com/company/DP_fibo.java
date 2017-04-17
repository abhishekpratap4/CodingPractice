package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pratap on 11/9/16.
 */
public class DP_fibo {
    static int lookUp[];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        lookUp = new int[n + 1];
        Arrays.fill(lookUp, -1);
        System.out.println(fiboNthElement(n));
        System.out.println(fiboNthElementIterative(n));
    }

    //Memoization - Top down
    private static int fiboNthElement(int n) {
        if (lookUp[n] == -1) {
            if (n <= 1)
                lookUp[n] = n;
            else
                lookUp[n] = fiboNthElement(n - 1) + fiboNthElement(n - 2);
        }

        return lookUp[n];
    }

    // Tabular - Bottom up
    private static int fiboNthElementIterative(int n) {
        lookUp[0] = 0;
        lookUp[1] = 1;
        for (int i = 3; i <= n; i++) {
            lookUp[i] = lookUp[i-1] + lookUp[i-2];
        }
        return lookUp[n];
    }
}
