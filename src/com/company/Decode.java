package com.company;

import java.util.Arrays;

/**
 * Created by pratap on 4/29/17.
 */
public class Decode {
    public static void main(String[] args) {
        String s = "1226#24#";
        int count[] = frequency(s);
        System.out.print(Arrays.toString(count));
    }

    static int[] frequency(String s) {
        int count[] = new int[26];
        if (s == null || s.isEmpty())
            return count;

        int start = 0, end = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            start = 0;
            end = 0;
            c = 0;
            if (i + 2 < s.length() && s.charAt(i + 2) != '#') {
                if (s.charAt(i + 1) != '(') {
                    int index = Integer.parseInt(Character.toString(s.charAt(i))) - 1;
                    count[index]++;
                } else {
                    start = i + 1;
                    end = s.indexOf(')', start + 1);
                    c = Integer.parseInt(s.substring(start + 1, end));
                    int index = Integer.parseInt(Character.toString(s.charAt(i))) - 1;
                    count[index] = count[index] + c;
                    i = end;
                }
            } else {
                if (s.charAt(i + 3) != '(') {
                    int index = Integer.parseInt(s.substring(i, i + 2)) - 1;
                    count[index]++;
                    i = i + 3;
                } else {
                    start = i + 3;
                    end = s.indexOf(')', start + 3);
                    c = Integer.parseInt(s.substring(start + 1, end));
                    int index = Integer.parseInt(Character.toString(s.charAt(i))) - 1;
                    count[index] = count[index] + c;
                    i = end;
                }
            }
        }

        return count;
    }
}
