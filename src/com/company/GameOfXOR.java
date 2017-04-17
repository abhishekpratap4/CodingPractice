package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pratap on 2/25/17.
 */
public class GameOfXOR {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T > 0) {
            int n = s.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            int result = playXORGame(arr);
            System.out.println(result);
            T--;
        }
    }

    private static int playXORGame(int[] arr) {
        int distinctArray[] = Arrays.stream(arr).distinct().toArray();
        int result = 0;
        if (distinctArray.length % 2 != 0) {
            for (int i = 0; i < distinctArray.length; i = i + 2)
                result = result ^ distinctArray[i];
        }
        return result;
    }
}
