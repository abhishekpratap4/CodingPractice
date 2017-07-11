package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pratap on 10/15/16.
 */
public class Game {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int arr[];
        while (t > 0) {
            int n = scanner.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(getPoints(arr));
            t--;
        }
    }

    public static int getPoints(int arr[]) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println("Sum: "+sum);
        if (sum % 2 != 0 || arr.length == 1) {
            return 0;
        } else {
            long halfSum = 0;
            int pos = 0;
            boolean flag = false;
            int subArray1[], subArray2[];
            for (int i = 0; i < arr.length; i++) {
                halfSum = halfSum + arr[i];
                if (halfSum == sum / 2) {
                    pos = i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return 0;
            }
            subArray1 = Arrays.copyOfRange(arr, 0, pos + 1);
            subArray2 = Arrays.copyOfRange(arr, pos + 1, arr.length);

            int p1 = getPoints(subArray1);
            int p2 = getPoints(subArray2);
            int point = 0;
            if (p1 == 0 && p2 == 0) {
                return 1;
            } else if (p1 >= p2) {
                point = p1;
                Utilities.printArray(subArray1);
            } else {
                point = p2;
                Utilities.printArray(subArray2);
            }
            return point + 1;
        }
    }
}