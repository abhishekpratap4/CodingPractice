package com.company;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pratap on 6/22/17.
 */
public class TrapRainWater {
    public static void main(String[] args) {
        int a[] = {3, 0, 0, 2, 0, 4};
        TrapRainWater.trapWater(a);
        TrapRainWater.trapWaterUpgrade(a);
    }

    private static void trapWater(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            int lMax = arr[i], rMax = arr[i];
            sum += Math.min(TrapRainWater.getMaxLeft(lMax, i, arr), TrapRainWater.getMaxRight(rMax, i, arr)) - arr[i];
        }
        System.out.println(sum);
    }

    private static int getMaxLeft(int max, int i, int[] arr) {
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] > max)
                max = arr[j];
        }
        return max;
    }

    private static int getMaxRight(int max, int i, int[] arr) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] > max)
                max = arr[j];
        }
        return max;
    }

    private static void trapWaterUpgrade(int[] arr) {
        int leftArr[] = new int[arr.length];
        int rightArr[] = new int[arr.length];
        leftArr[0] = arr[0];
        rightArr[rightArr.length - 1] = arr[arr.length - 1];
        int sum = 0;

        for (int i = 1; i < arr.length; i++) {
            leftArr[i] = Math.max(arr[i], leftArr[i - 1]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            rightArr[i] = Math.max(arr[i], rightArr[i + 1]);
        }
        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(leftArr[i], rightArr[i]) - arr[i];
        }
        System.out.println(sum);
    }

}
