package com.company;

import java.util.List;

/**
 * Created by pratap on 4/2/17.
 */
public class UpdateMatrix {

    public static void main(String[] args) {
        UpdateMatrix u = new UpdateMatrix();
        int matrix[][] = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        u.longestIncreasingPath(matrix);
//        Integer[] a1 = {0, 1, 1, 0, 0};
//        Integer[] a2 = {0, 1, 1, 0, 0};
//        Integer[] a3 = {0, 1, 0, 0, 1};
//        Integer[] a4 = {1, 1, 1, 1, 0};
//        Integer[] a5 = {1, 0, 0, 1, 0};
//        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(a1));
//        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(a2));
//        ArrayList<Integer> l3 = new ArrayList<>(Arrays.asList(a3));
//        ArrayList<Integer> l4 = new ArrayList<>(Arrays.asList(a4));
//        ArrayList<Integer> l5 = new ArrayList<>(Arrays.asList(a5));
//        list.add(l1);
//        list.add(l2);
//        list.add(l3);
//        list.add(l4);
//        list.add(l5);
//        u.updateMatrix(list);
//        System.out.print(list);
    }

    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0)
            return matrix;

        int dp[][] = new int[matrix.size()][matrix.get(0).size()];

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                updateMatrixUtil(-1, -1, i, j, matrix, dp);
            }
        }
        return matrix;
    }

    private int updateMatrixUtil(int p_i, int p_j, int i, int j, List<List<Integer>> matrix, int dp[][]) {
        if (i < 0 || i >= matrix.size() || j < 0 || j >= matrix.get(0).size()) {
            System.out.println("( " + i + "," + j + ") " + Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

        if (matrix.get(i).get(j) == 0) {
            System.out.println("( " + i + "," + j + ") " + 0);
            dp[i][j] = 0;
            return 0;
        } else {
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, m3 = Integer.MAX_VALUE, m4 = Integer.MAX_VALUE;
            if (i - 1 != p_i && j != p_j)
                m1 = updateMatrixUtil(i, j, i - 1, j, matrix, dp);
            if (i + 1 != p_i && j != p_j)
                m2 = updateMatrixUtil(i, j, i + 1, j, matrix, dp);
            if (i != p_i && j - 1 != p_j)
                m3 = updateMatrixUtil(i, j, i, j - 1, matrix, dp);
            if (i != p_i && j + 1 != p_j)
                m4 = updateMatrixUtil(i, j, i, j + 1, matrix, dp);
            dp[i][j] = (1 + Math.min(Math.min(m1, m2), Math.min(m3, m4)));
            //int ans = (1 + Math.min(Math.min(m1, m2), Math.min(m3, m4)));
            matrix.get(i).set(j, dp[i][j]);
            //matrix.get(i).set(j, ans);
            System.out.println("( " + i + "," + j + ") " + dp[i][j]);
            return dp[i][j];
            //return ans;
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null)
            return 0;
        int rows = matrix.length;
        int cols = 0;
        if (rows > 0)
            cols = matrix[0].length;

        int dp[][] = new int[rows][cols];
        int maxLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int temp_max = dfs(matrix, i, j, dp, Integer.MIN_VALUE);
                maxLength = Math.max(temp_max, maxLength);
            }
        }
        return maxLength;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp, int prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return 0;
        if (prev >= matrix[i][j])
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];
        else {
            int d1 = dfs(matrix, i - 1, j, dp, matrix[i][j]);
            int d2 = dfs(matrix, i + 1, j, dp, matrix[i][j]);
            int d3 = dfs(matrix, i, j - 1, dp, matrix[i][j]);
            int d4 = dfs(matrix, i, j + 1, dp, matrix[i][j]);
            dp[i][j] = (1 + Math.max(Math.max(d1, d2), Math.max(d3, d4)));
            return dp[i][j];
        }
    }
}
