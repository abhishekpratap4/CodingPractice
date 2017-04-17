package com.company;

/**
 * Created by pratap on 11/19/16.
 */
public class LargestSumContSubArray {

    public static void main(String[] args) {
        int arr[] = {-2, -3, -4, -1, -20, -10, -5, 0};
        int maxSoFar = arr[0];
        int maxEndHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndHere = Math.max(arr[i], maxEndHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        System.out.println(maxSoFar);
        String str = "abcb";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j <= str.length(); j++) {
                String sub = str.substring(i, j);
                if (checkPalindrome(sub))
                    System.out.print(sub + "\t");
            }
            System.out.println();
        }
    }

    private static boolean checkPalindrome(String sub) {
        for (int i = 0; i < sub.length() && i < sub.length() - i - 1; i++) {
            if (sub.charAt(i) != sub.charAt(sub.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
