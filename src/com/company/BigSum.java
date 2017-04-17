package com.company;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pratap on 10/20/16.
 */
public class BigSum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BigInteger N = scanner.nextBigInteger();
        while(!N.equals(new BigInteger("0"))){
            BigInteger a = scanner.nextBigInteger();
            BigInteger b = scanner.nextBigInteger();
            System.out.println(a.add(b));
            N = N.subtract(new BigInteger("1"));
        }
    }
}
