package com.company;

/**
 * Created by pratap on 12/10/16.
 */
public class GridUniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(4,4));
    }

    public static int uniquePaths(int a, int b) {
        if (a <= 0 || b <= 0)
            return 0;
        int res[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 && j == 0)
                    res[i][j] = 1;
                else if(i == 0)
                    res[i][j] = res[i][j-1];
                else if(j == 0)
                    res[i][j] = res[i-1][j];
                else
                    res[i][j] = res[i][j-1] + res[i-1][j];
            }
        }
        return res[a-1][b-1];
    }
}
