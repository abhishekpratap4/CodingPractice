package com.company;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pratap on 10/15/16.
 */
public class XORMatrix {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        BigInteger m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextBigInteger();
        int arr[][] = new int[m.intValue()][n];
        for(int j =0;j<n;j++){
            arr[0][j] = scanner.nextInt();
        }

        for(BigInteger i = new BigInteger("1"); i.compareTo(m)==-1; i=i.add(new BigInteger("1"))){
            for(int j =0; j<n; j++){
                if(j==n-1){
                    arr[i.intValue()][n-1] = arr[i.intValue()-1][n-1] ^ arr[i.intValue()-1][0];
                } else {
                    arr[i.intValue()][j] = arr[i.intValue()-1][j] ^ arr[i.intValue()-1][j+1];
                }
            }
        }

        for(int j =0; j<n; j++){
            System.out.print(arr[m.intValue()-1][j]+" ");
        }
    }
}