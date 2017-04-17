package com.company;

import java.util.Scanner;

/**
 * Created by pratap on 11/9/16.
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 */
public class DP_EditDistance {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();
        int d = editDistance(s1, s2, s1.length(), s2.length());
        System.out.println(d);
        int d2 = editDistanceDP(s1, s2, s1.length(), s2.length());
        System.out.println(d2);
    }

    //recursive - without DP
    private static int editDistance(String s1, String s2, int m, int n) {
        if (m == 0)
            return n; //insert n characters
        else if (n == 0)
            return m; // remove m characters
        else if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return editDistance(s1, s2, m - 1, n - 1);
        else
            return 1 + min(editDistance(s1, s2, m, n - 1), editDistance(s1, s2, m - 1, n), editDistance(s1, s2, m - 1, n - 1));
    }

    private static int min(int i, int i1, int i2) {
        if (i < i1 && i < i2)
            return i;
        else if (i1 < i && i1 < i2)
            return i1;
        else
            return i2;
    }

    // solve with DP
    private static int editDistanceDP(String s1, String s2, int m, int n) {
        int dist[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    dist[i][j] = j;
                else if (j == 0)
                    dist[i][j] = i;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dist[i][j] = dist[i - 1][j - 1];
                else
                    dist[i][j] = 1 + min(dist[i][j - 1], dist[i - 1][j], dist[i - 1][j - 1]);
            }
        }
        return dist[m-1][n-1];
    }


}
