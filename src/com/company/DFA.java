package com.company;

/**
 * Created by pratap on 5/27/17.
 */
public class DFA {

    public static void main(String[] args) {
        int n = 5;
        int[][] table = new int[n][2];

        for (int state = 0; state < n; state++) {
            int tran0 = state << 1;
            System.out.println("tran0: " + tran0);
            table[state][0] = tran0 < n ? tran0 : tran0 - n;

            int tran1 = (state << 1) + 1;
            System.out.println("tran1: " + tran1);
            table[state][1] = tran1 < n ? tran1 : tran1 - n;
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }

        int A = 5;
        System.out.println(Integer.toBinaryString(A));

        System.out.println(A >> 1);
        System.out.println(A);
    }
}
