package com.company;

import java.util.Stack;

/**
 * Created by pratap on 3/30/17.
 */

public class Sudoku {
    class Cell {
        int row;
        int col;

        Cell() {
            row = 0;
            col = 0;
        }

        Cell(int i, int j) {
            row = i;
            col = j;
        }
    }

    Stack<Cell> emptyCellStack = new Stack<>();

    public static void main(String args[]) {
        Sudoku s = new Sudoku();
        char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        //s.solveSudoku(board);
        System.out.println(s.isValidSudoku(board));
    }

    public void solveSudoku(char[][] board) {
        if (board != null) {

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '.') {
                        emptyCellStack.push(new Cell(i, j));
                    }
                }
            }

            solveSudokuUtil(board);
            printBoard(board);
        }
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private boolean solveSudokuUtil(char[][] board) {
        Cell emptyCell = getEmptyCellV2(board);
        if (emptyCell == null) {
            return true;
        }

        for (int k = 1; k <= 9; k++) {
            if (isSafeMove(board, emptyCell, k)) {
                board[emptyCell.row][emptyCell.col] = Character.forDigit(k, 10);
                if (solveSudokuUtil(board))
                    return true;
                else {
                    board[emptyCell.row][emptyCell.col] = '.';
                    emptyCellStack.push(emptyCell);
                }
            }
        }
        return false;
    }

    private Cell getEmptyCell(char[][] board) {
        if (emptyCellStack.size() == 0)
            return null;
        else
            return emptyCellStack.pop();
    }

    private Cell getEmptyCellV2(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.')
                    return new Cell(i, j);
            }
        }
        return null;
    }

    private boolean isSafeMove(char[][] board, Cell cell, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][cell.col] == Character.forDigit(num, 10))
                return false;
        }

        for (int j = 0; j < board.length; j++) {
            if (board[cell.row][j] == Character.forDigit(num, 10))
                return false;
        }

        int rowStartIndex = cell.row - cell.row % 3;
        int colStartIndex = cell.col - cell.col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + rowStartIndex][j + colStartIndex] == Character.forDigit(num, 10))
                    return false;
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (!isCorrect(board, i, j, board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }

    private boolean isCorrect(char[][] board, int row, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num && i != row)
                return false;
        }

        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == num && j != col)
                return false;
        }

        int rowStartIndex = row - row % 3;
        int colStartIndex = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + rowStartIndex][j + colStartIndex] == num && (i + rowStartIndex) != row && (j + colStartIndex) != col)
                    return false;
            }
        }

        return true;
    }
}
