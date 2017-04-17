package com.company;

import java.util.*;

/**
 * Created by pratap on 4/14/17.
 */


public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku v = new ValidSudoku();
        List<String> list = new ArrayList<>();
        list.add("..5.....6");
        list.add("....14...");
        list.add(".........");
        list.add(".....92..");
        list.add("5....2...");
        list.add(".......3.");
        list.add("...54....");
        list.add("3.....42.");
        list.add("...27.6..");
        System.out.println(v.isValidSudoku(list));
    }

    public int isValidSudoku(final List<String> a) {
        if (a == null || a.size() == 0)
            return 0;

        for (int i = 0; i < a.size(); i++) {
            String row = a.get(i);
            for (int j = 0; j < row.length(); j++) {
                char ch = row.charAt(j);
                if (ch == '.')
                    continue;
                if (!isValid(ch, a, i, j))
                    return 0;
            }
        }
        return 1;
    }

    private boolean isValid(char ch, List<String> a, int r, int c) {
        int rows = a.size();
        int cols = a.get(0).length();
        for (int i = 0; i < rows; i++) {
            if (i != r) {
                if (a.get(i).charAt(c) == ch) {
                    System.out.print("Row : " + (i + 1) + "Col : " + (c + 1) + "Char : " + ch + "\n");
                    return false;
                }
            }
        }

        for (int j = 0; j < cols; j++) {
            if (j != c) {
                if (a.get(r).charAt(j) == ch) {
                    System.out.print("Row : " + (r + 1) + "Col : " + (j + 1) + "Char : " + ch + "\n");
                    return false;
                }
            }
        }

        int temp_r = r - r % 3;
        int temp_c = c - c % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i + temp_r != r && j + temp_c != c) {
                    if (a.get(i + temp_r).charAt(j + temp_c) == ch) {
                        System.out.print("Row : " + (i + 1) + "Col : " + (j + 1) + "Char : " + ch + "\n");
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
