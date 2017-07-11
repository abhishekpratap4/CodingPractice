package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratap on 4/1/17.
 */
public class SpiralOrder {

    public static void main(String[] args) {
        SpiralOrder s = new SpiralOrder();
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(s.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null)
            return list;
        int rows = matrix.length;
        if (rows == 0)
            return list;
        int cols = matrix[0].length;
        if (cols == 0)
            return list;

        int r = 0, c = 0;
        
        while (r < rows && c < cols) {
            for (int i = c; i < cols; i++) {
                list.add(matrix[r][i]);
            }
            r++;

            for (int i = r; i < rows; i++) {
                list.add(matrix[i][cols - 1]);
            }
            cols--;

            if (r < rows) {
                for (int i = cols - 1; i >= c; i--) {
                    list.add(matrix[rows - 1][i]);
                }
                rows--;
            }

            if (c < cols) {
                for (int i = rows - 1; i >= r; i--) {
                    list.add(matrix[i][c]);
                }
                c++;
            }
        }
        return list;
    }
}
