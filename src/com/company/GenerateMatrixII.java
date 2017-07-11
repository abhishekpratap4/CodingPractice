package com.company;

import java.util.*;

/**
 * Created by pratap on 6/15/17.
 */
public class GenerateMatrixII {
    public static void main(String[] args) {
        GenerateMatrixII g = new GenerateMatrixII();
        System.out.println(g.generateMatrix(3));
    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(a);
        for (int i = 0; i < a; i++) {
            ArrayList<Integer> temp = new ArrayList<>(a);
            for (int j = 0; j < a; j++) {
                temp.add(0);
            }
            list.add(temp);
        }
        int rows = a;
        int cols = a;
        int r = 0, c = 0, count = 1;
        while (rows > r && cols > c && count <= a * a) {
            for (int j = c; j < cols; j++) {
                list.get(r).set(j, count);
                count++;
            }
            r++;
            for (int i = r; i < rows; i++) {
                list.get(i).set(cols - 1, count);
                count++;
            }
            cols--;
            if (r < rows) {
                for (int j = cols - 1; j >= c; j--) {
                    list.get(rows - 1).set(j, count);
                    count++;
                }
                rows--;
            }
            if (c < cols) {
                for (int i = rows - 1; i >= r; i--) {
                    list.get(i).set(c, count);
                    count++;
                }
                c++;
            }
        }
        return list;
    }
}
