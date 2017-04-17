package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by pratap on 10/22/16.
 */
public class Combinations {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Scanner scanner = new Scanner(System.in);
        //int N = Integer.parseInt(scanner.nextLine());
        //String foodStyle = scanner.nextLine();
        //String sleepStyle = scanner.nextLine();

        int N = Integer.parseInt(reader.readLine());
        String foodStyle = reader.readLine();
        String sleepStyle = reader.readLine();

        int Q = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= Q; i++) {
            String s[] = reader.readLine().split("\\s");
            int L = Integer.parseInt(s[0]);
            int R = Integer.parseInt(s[1]);
            int count = 0;

            for (int c = L - 1; c < R; c++) {
                for (int j = c + 1; j < R; j++) {
                    if (foodStyle.charAt(c) == foodStyle.charAt(j) || sleepStyle.charAt(c) == sleepStyle.charAt(j)) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }


    }

    private static int findCombinationsEfficiently(int count) {
        if (count == 1) {
            return 1;
        } else if (count == 2) {
            return 2;
        }
        int r = 2;
        int C[] = new int[3];
        C[0] = 1;
        for (int i = 1; i <= count; i++) {
            for (int j = Math.min(i, r); j > 0; j--)
                C[j] = (C[j] + C[j - 1]) % 1000000007;
        }
        return C[r];
    }

    private static long findCombinations(long count) {
        if (count == 1) {
            return 1;
        } else if (count == 2) {
            return 2;
        }
        long comb = factorial(count) / ((2 * factorial(count - 2)) % 1000000007);
        return comb;
    }

    private static long factorial(long num) {
        long fact = 1;
        for (long i = 1; i <= num; i++) {
            fact = (fact * i) % 1000000007;
        }
        return fact;
    }
}
