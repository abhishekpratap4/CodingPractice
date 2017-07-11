package com.company;

import java.util.*;

/**
 * Created by pratap on 6/18/17.
 */
public class HackerWithBits {
    static int maxOnes;

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] num = new int[N];
        boolean hasOne = false, hasZero = false;
        for (int i = 0; i < N; i++) {
            num[i] = s.nextInt();
            if (num[i] == 1)
                hasOne = true;
            if (num[i] == 0)
                hasZero = true;
        }
        if (!hasZero) {
            System.out.println(num.length);
            return;
        }
        if (!hasOne) {
            System.out.println(0);
            return;
        }

        int pos = -1, prev = -1;
        for (int i = 0; i < N; i++) {
            if (num[i] == 0) {
                pos = i;
                bitUtility(pos, prev, num);
                prev = pos;
            }
        }
        System.out.println(maxOnes);
    }

    private static void bitUtility(int pos, int prev, int[] num) {
        int leftCount = 0, rightCount = 0;
        int i;
        for (i = pos - 1; i > prev; i--) {
            if (num[i] == 1) {
                leftCount++;
            } else {
                break;
            }
        }
        while (i >= 0) {
            if (num[i] == 1) {
                leftCount++;
                break;
            }
            i--;
        }
        for (i = pos + 1; i < num.length; i++) {
            if (num[i] == 1) {
                rightCount++;
            } else {
                i++;
                while (i < num.length) {
                    if (num[i] == 1) {
                        rightCount++;
                        break;
                    }
                }
                break;
            }
        }
//        int temp = 0;
//        if (maxOnes != 0)
//            temp = 1;
        maxOnes = Math.max(maxOnes, leftCount + rightCount);
    }
}
