package com.company;

import java.util.Scanner;

/**
 * Created by pratap on 4/27/17.
 */
public class SpecialInteger {
    static int m_digits, b_digits;

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long x;
        while (T > 0) {
            x = sc.nextLong();
            getMultiple(x);
            T--;
        }
    }

    private static void getMultiple(long x) {
        long multiple = 0, res;
        for (int i = 1; i <= 9; i++) {
            res = x * i;
            if (Long.toString(res).matches("4+0*")) {
                multiple = res;

                if (multiple != 0) {
                    long temp = multiple;
                    long rem;
                    int a = 0, b = 0;
                    while (temp > 0) {
                        rem = temp % 10;
                        if (rem == 0) {
                            b++;
                        } else if (rem == 4) {
                            a++;
                        }
                        temp = temp / 10;
                    }
                    System.out.println(2 * a + b);
                }
                return;
            }
        }

        long big = getNextBigNumber(x);
        long rem;
        while (big > 0) {
            System.out.println(big);
            rem = big % x;
            if(rem == 0)
                break;
            if (rem != 0) {
                if ((rem * 10) % x == 0) {
                    b_digits++;
                    big = 0;
                } else {
                    big = rem * 10 + 4;
                    m_digits++;
                }
            }
        }
        //System.out.println("a: " + m_digits + "b: " + b_digits);
        System.out.println(2*m_digits + b_digits);
        m_digits = 0;
        b_digits = 0;
    }

    private static long getNextBigNumber(long x) {
        int digits = 0;
        long temp = x, rem;
        while (temp > 0) {
            digits++;
            temp = temp / 10;
        }
        StringBuilder s = new StringBuilder("");
        for (int i = 1; i <= digits; i++) {
            s.append('4');
        }
        long num = Long.parseLong(s.toString());
        if (num > x) {
            m_digits = digits;
            return num;
        } else {
            m_digits = digits + 1;
            return (num * 10 + 4);
        }
    }
}
