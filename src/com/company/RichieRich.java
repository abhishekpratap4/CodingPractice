package com.company;

import java.util.Scanner;

/**
 * Created by pratap on 10/14/16.
 */
public class RichieRich {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        StringBuilder str = new StringBuilder(number);
        int diff = findDiff(str, k);
        if (k < diff) {
            System.out.println(-1);
        } else if (k == diff) {
            findPalindromeWhenKEqualDiff(str, k, diff);
        } else {
            findPalindromeWhenKNotEqualDiff(str, k, diff);
        }
    }

    public static int findDiff(StringBuilder number, int k) {
        int len = number.length();
        int diff = 0;
        for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
            if (number.charAt(i) != number.charAt(j)) {
                diff++;
            }
        }
        return diff;
    }

    public static void findPalindromeWhenKEqualDiff(StringBuilder number, int k, int diff) {
        int len = number.length();
        for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
            if (Character.getNumericValue(number.charAt(i)) > Character.getNumericValue(number.charAt(j))) {
                number.setCharAt(j, number.charAt(i));
            } else if (Character.getNumericValue(number.charAt(i)) < Character.getNumericValue(number.charAt(j))) {
                number.setCharAt(i, number.charAt(j));
            }
        }
        System.out.println(number);
    }

    public static void findPalindromeWhenKNotEqualDiff(StringBuilder number, int k, int diff) {
        int len = number.length();
        for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
            if (k >= diff && k > 0) {
                if ((k - diff) % 2 == 0) {
                    if (number.charAt(i) == '9' && number.charAt(j) != '9') {
                        number.setCharAt(j, number.charAt(i));
                        k--;
                    } else if (number.charAt(i) != '9' && number.charAt(j) == '9') {
                        number.setCharAt(i, number.charAt(j));
                        k--;
                    }
                    else if (number.charAt(i) != '9' && number.charAt(j) != '9') {
                        number.setCharAt(i, '9');
                        number.setCharAt(j, '9');
                        k = k - 2;
                    } else {
                        if (Character.getNumericValue(number.charAt(i)) > Character.getNumericValue(number.charAt(j))) {
                            number.setCharAt(j, number.charAt(i));
                            k--;
                        } else if (Character.getNumericValue(number.charAt(i)) < Character.getNumericValue(number.charAt(j))) {
                            number.setCharAt(i, number.charAt(j));
                            k--;
                        }
                    }
                } else {
                    if (number.charAt(i) != '9' && number.charAt(j) != '9') {
                        number.setCharAt(i, '9');
                        number.setCharAt(j, '9');
                        k = k - 2;
                    } else if (number.charAt(i) == '9' && number.charAt(j) != '9') {
                        number.setCharAt(j, number.charAt(i));
                        k--;
                    } else if (number.charAt(i) != '9' && number.charAt(j) == '9') {
                        number.setCharAt(i, number.charAt(j));
                        k--;
                    } else {
                        if (Character.getNumericValue(number.charAt(i)) > Character.getNumericValue(number.charAt(j))) {
                            number.setCharAt(j, number.charAt(i));
                            k--;
                        } else if (Character.getNumericValue(number.charAt(i)) < Character.getNumericValue(number.charAt(j))) {
                            number.setCharAt(i, number.charAt(j));
                            k--;
                        }
                    }
                }
                diff = findDiff(number, k);
            }
        }

        System.out.println(number);
    }
}
