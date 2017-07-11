package com.company;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pratap on 10/15/16.
 */
public class XORMatrixString {

    public static void main(String[] args) {
        int n;
        BigInteger m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextBigInteger();
        String baseStr = "";
        for (int j = 0; j < n; j++) {
            baseStr = baseStr + scanner.nextInt() + " ";
        }

        for (BigInteger i = new BigInteger("1"); i.compareTo(m) == -1; i = i.add(new BigInteger("1"))) {
            String newStr = "";
            for (int j = 0; j < n; j++) {
                String str[] = baseStr.split(" ");
                if (j == n - 1) {
                    newStr = newStr + (Integer.parseInt(str[n - 1]) ^ Integer.parseInt(str[0])) + " ";
                    //arr[i.intValue()][n-1] = arr[i.intValue()-1][n-1] ^ arr[i.intValue()-1][0];
                } else {
                    newStr = newStr + (Integer.parseInt(str[j]) ^ Integer.parseInt(str[j + 1])) + " ";
                    //arr[i.intValue()][j] = arr[i.intValue()-1][j] ^ arr[i.intValue()-1][j+1];
                }
            }
            baseStr = newStr;
        }
        System.out.print(baseStr);
    }
}
