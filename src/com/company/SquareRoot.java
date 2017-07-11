package com.company;

/**
 * Created by pratap on 6/17/17.
 */
public class SquareRoot {
    public String longestPalindrome(String a) {
        String longest = "";
        int length = 0;
        int start = 0;
        for (int i = start, j = a.length(); i < a.length() && j >= 0; ) {
            String substring = a.substring(i, j);
            if (isPalindromeString(substring)) {
                if (substring.length() > length) {
                    longest = substring;
                    length = substring.length();
                }
                start++;
                i = start;
                j = a.length();
            } else {
                j--;
            }
        }
        return longest;
    }

    public boolean isPalindromeString(String str) {
        for (int i = 0, j = str.length() - 1; i < str.length() / 2 && j >= 0; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        SquareRoot s = new SquareRoot();
        System.out.println(s.longestPalindrome("aaaabaaa"));
    }
}
