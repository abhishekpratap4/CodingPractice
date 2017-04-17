package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pratap on 3/29/17.
 */
public class NQueen {

    class Result {
        int count;
        boolean valid;

        Result(){
            count = 0;
            valid = false;
        }
    }

    public static void main(String[] args) {
        NQueen queen = new NQueen();
        int x = 1;
        char c = (char)x;
        System.out.println(Character.forDigit(9,10));
        //queen.solveNQueens(4);
    }

    public void solveNQueens(int n) {
        String boardArray[][] = new String[n][n];
        for (String[] row : boardArray) {
            Arrays.fill(row, ".");
        }
        Result result = new Result();
        solveNQueensUtil(boardArray, 0, result);
        System.out.println(result.count);

    }

    private Result solveNQueensUtil(String board[][], int col, Result result) {
        if (col == board.length){
            List<List<String>> boardList = Arrays.stream(board).map(Arrays::asList).collect(Collectors.toList());
            System.out.println(boardList);
            result.valid = true;
            result.count = result.count + 1;
            return result;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafePosition(i, col, board)) {
                board[i][col] = "Q";
//                For only 1 solution
//                if (solveNQueensUtil(board, col + 1))
//                    return true;
//                else
//                    board[i][col] = ".";

                // For all solutions
                solveNQueensUtil(board, col + 1, result);
                board[i][col] = ".";
            }
        }
        result.valid = false;
        return result;
    }

    private boolean isSafePosition(int row, int col, String[][] board) {
        // check in row
        for (int i = 0; i < col; i++) {
            if (board[row][i].equals("Q"))
                return false;
        }

        // check upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q"))
                return false;
        }

        // check lower diagonal
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j].equals("Q"))
                return false;
        }
        return true;
    }
}
