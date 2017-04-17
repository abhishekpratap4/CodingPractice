package com.company;

/**
 * Created by pratap on 12/10/16.
 */
public class SQRT {
    public static void main(String[] args) {
        System.out.println(sqrt(930675566));
    }

    public static int sqrt(int a) {
        if (a <= 1)
            return a;
        int num = 0;
        int res = 0, prevRes = 0;
        int low = 0;
        int high = a;
        while (true) {
            num = (low + high) / 2;
            System.out.println("num: " + num);
            res = a / num;
            if (res == num || res == prevRes)
                return num;
            else if (res > num) {
                low = num + 1;
            } else {
                high = num - 1;
            }
            prevRes = res;
        }
    }
}
