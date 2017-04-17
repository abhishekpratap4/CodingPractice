package com.company;

import java.util.PriorityQueue;

/**
 * Created by pratap on 4/1/17.
 */
public class MatrixZeroes {
    public static void main(String[] args) {
        MatrixZeroes m = new MatrixZeroes();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        m.kthSmallest(matrix,8);
        //m.setZeroes(matrix);

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + "\t");
//            }
//            System.out.println();
//        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null)
            return -1;
        int rows = matrix.length;
        int cols = -1;
        if (rows > 0)
            cols = matrix[0].length;
        else
            return -1;
        if (cols <= 0)
            return -1;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                minHeap.add(matrix[i][j]);
            }
        }

        for(int t = 1;t<k;t++){
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null)
            return;
        int rows = matrix.length;
        int cols = -1;
        if (rows > 0) {
            cols = matrix[0].length;
        }
        if (cols <= 0)
            return;

        int i_row = -1, j_col = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    i_row = i;
                    j_col = j;
                    break;
                }
            }
        }
        if (i_row == -1 && j_col == -1)
            return;
        for (int c = 0; c < cols; c++) {
            matrix[i_row][c] = 0;
        }
        for (int r = 0; r < rows; r++) {
            matrix[r][j_col] = 0;
        }
    }
}
