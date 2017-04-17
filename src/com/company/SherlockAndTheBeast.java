package com.company;

import java.util.Scanner;

/**
 * Created by pratap on 10/26/16.
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast
 */
public class SherlockAndTheBeast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            int N = scanner.nextInt();
            if (N < 3)
                System.out.print(-1);
            else if (N % 3 == 0) {
                for (int i = 1; i <= N; i++)
                    System.out.print("5");

            } else {
                boolean flag = false;
                int x = N - (N % 3);
                while (x >= 3) {
                    if ((N - x) % 5 == 0) {
                        for (int i = 1; i <= x; i++)
                            System.out.print("5");
                        for (int i = 1; i <= N - x; i++)
                            System.out.print("3");
                        flag = true;
                        break;
                    }
                    x = x - 3;
                }
                if (!flag) {
                    if (N % 5 == 0) {
                        for (int i = 1; i <= N; i++)
                            System.out.print("3");
                    } else
                        System.out.print(-1);
                }

            }
            System.out.println();
            T--;
        }

    }
}
