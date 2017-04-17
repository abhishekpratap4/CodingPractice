package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pratap on 10/26/16.
 * https://www.hackerrank.com/challenges/grid-challenge
 */
public class Grid {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            int N = scanner.nextInt();
            char grid[][] = new char[N][N];
            for (int i = 0; i < N; i++) {
                String s = scanner.next();
                char arr[] = s.toCharArray();
                Arrays.sort(arr);
                grid[i] = arr;
            }


            boolean flag = true;
            for (int i = 0; i < N; i++) {
                char arr[] = new char[N];
                for (int j = 0; j < N; j++) {
                    arr[j] = grid[j][i];
                }
                if (isSorted(arr))
                    continue;
                else {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
            T--;
        }
    }

    private static boolean isSorted(char[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1])
                continue;
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
