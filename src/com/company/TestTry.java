package com.company;

/**
 * Created by pratap on 5/20/17.
 */
public class TestTry {
    public static void main(String[] args) {
        System.out.print(test());
    }

    private static int test() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }
}
