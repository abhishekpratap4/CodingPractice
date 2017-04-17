package com.company;

/**
 * Created by pratap on 10/8/16.
 */
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test > 0) {
            int arr[] = getArray(scanner);
            int cont_sum = findSum(arr);
            int discont_sum = findDiscontSum(arr);
            System.out.print(cont_sum + " " + discont_sum);
            test --;
        }
    }

    public static int findDiscontSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum = sum + arr[i];
            }
        }
        return sum;
    }

    public static int findSum(int[] arr) {
        int max_till_now = 0, max_end = 0;

        for (int i = 0; i < arr.length; i++) {
            max_end = max_end + arr[i];
            if (max_end < 0) {
                max_end = 0;
            } else if (max_till_now < max_end) {
                max_till_now = max_end;
            }
        }
        return max_till_now;
    }

    private static int[] getArray(Scanner scanner) {
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
