package com.company;

/**
 * Created by pratap on 5/10/17.
 */
public class CustomPowerCalculator {
    public static void main(String[] args) {
        System.out.print(power(2, 10));
    }

    private static int power(int x, int y) {
        int temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else
            return x * temp * temp;
    }
}
