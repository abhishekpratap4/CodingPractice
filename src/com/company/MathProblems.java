package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by pratap on 1/1/17.
 */
public class MathProblems {
    public static void main(String[] args) {
        //int x = 71045970, n = 41535484, d = 64735492;
        //int x = 0, n = 0, d = 1;
        //System.out.println(pow(x, n, d));
        Integer[] arr = {2, 0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0, 2, 2, 2, 3, 2, 3, 1, 2, 1, 2, 2, 3, 2, 3, 0, 3, 0, 2, 1, 2, 0, 0, 3, 2, 3, 0, 3, 0, 2, 3, 2, 2, 3, 1, 3, 3, 0, 3, 3, 0, 3, 3, 2, 0, 0, 0, 0, 1, 3, 0, 3, 1, 3, 1, 0, 2, 3, 3, 3, 2, 3, 3, 2, 2, 3, 3, 3, 1, 3, 2, 1, 0, 0, 0, 1, 0, 3, 2, 1, 0, 2, 3, 0, 2, 1, 1, 3, 2, 0, 1, 1, 3, 3, 0, 1, 2, 1, 2, 2, 3, 1, 1, 3, 0, 2, 2, 2, 2, 1, 0, 2, 2, 2, 1, 3, 1, 3, 1, 1, 0, 2, 2, 0, 2, 3, 0, 1, 2, 1, 1, 3, 0, 2, 3, 2, 3, 2, 0, 2, 2, 3, 2, 2, 0, 2, 1, 3, 0, 2, 0, 2, 1, 3, 1, 1, 0, 0, 3, 0, 1, 2, 2, 1, 2, 0, 1, 0, 0, 0, 1, 1, 0, 3, 2, 3, 0, 1, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 3, 2, 2, 0, 0, 1, 2, 0, 3, 0, 3, 3, 3, 0, 3, 3, 1, 0, 1, 2, 1, 0, 0, 2, 3, 1, 1, 3, 2};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        int x = removeElement(list, 2);
        System.out.println(x);
    }

    public static int pow(int x, int n, int d) {
        long p = power(x, n, d);
        System.out.println(p);
        if (p >= 0)
            return (int) p;
        else {
            return (int) (d + p);
        }

    }

    public static long power(int x, int n, int d) {
        long temp;
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        temp = power(x, n / 2, d);
        if (n % 2 == 0) {
            return ((temp % d) * (temp % d)) % d;
            //return (temp) * (temp);
        } else {
            return ((((temp % d) * (temp % d)) % d) * (x % d)) % d;
//            if (n > 0) {
//                return ((x % d) * (temp % d) * (temp % d)) % d;
//                //return x * (temp) * (temp);
//            } else {
//                //return ((temp % d) * (temp % d)) / (x % d);
//                return (temp) * (temp) / x;
//            }
        }
    }

    public static int threeSumClosest(ArrayList<Integer> a, int b) {
        if (a.size() < 3)
            return -1;
        Collections.sort(a);
        int sum, closeSum = a.get(0) + a.get(1) + a.get(2);
        for (int i = 0, j = i + 1; i < a.size(); i++) {
            for (; j < a.size(); j++) {
                for (int k = a.size() - 1; k >= 0; k--) {
                    if (i != j && i != k && j != k) {
                        sum = a.get(i) + a.get(j) + a.get(k);
                        if (Math.abs(b - sum) < Math.abs(b - closeSum)) {
                            closeSum = sum;
                        }
                        if (sum < b) {
                            break;
                        }
                    }
                }
            }
        }
        return closeSum;
    }

    public static int removeElement(ArrayList<Integer> a, int b) {
        if (a == null || a.size() == 0)
            return -1;
        int count = 0;
        for (int i = 0, j = a.size() - 1; i < a.size() && j >= 0 && i <= j; i++, j--) {
            if (a.get(i) == b) {
                count++;
                a.set(i, -786);
            }
            if (a.get(j) == b) {
                count++;
                a.set(j, -786);
            }
        }
        int x = a.size() - count;
        int size = a.size();
        for (int i = 0, j = a.size() - 1; i < size && j >= 0 && i <= j; i++, j--) {
            if (a.get(i) == -786) {
                a.remove(i);
                j--;
                i--;
            }
            if (j >= 0 && a.get(j) == -786)
                a.remove(j);

            size = a.size();

        }

        System.out.println(count);
        System.out.println(a);
        return x;
    }
}
