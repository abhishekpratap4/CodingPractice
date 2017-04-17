package com.company;

import java.util.*;

/**
 * Created by pratap on 4/2/17.
 */


public class UpdateMatrixII {

    class Cell {
        int i, j;

        Cell(int a, int b) {
            i = a;
            j = b;
        }
    }

    public static void main(String[] args) {
        UpdateMatrixII u = new UpdateMatrixII();
        List<List<Integer>> list = new ArrayList<>();
        Integer[] a1 = {0, 1, 1, 0, 0};
        Integer[] a2 = {0, 1, 1, 0, 0};
        Integer[] a3 = {0, 1, 0, 0, 1};
        Integer[] a4 = {1, 1, 1, 1, 0};
        Integer[] a5 = {1, 0, 0, 1, 0};
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(a1));
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(a2));
        ArrayList<Integer> l3 = new ArrayList<>(Arrays.asList(a3));
        ArrayList<Integer> l4 = new ArrayList<>(Arrays.asList(a4));
        ArrayList<Integer> l5 = new ArrayList<>(Arrays.asList(a5));
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        u.updateMatrix(list);
        System.out.print(list);
    }

    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0)
            return matrix;

        Queue<Cell> queue = new java.util.LinkedList<>();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                if (matrix.get(i).get(j) == 0)
                    queue.add(new Cell(i, j));
                else
                    matrix.get(i).set(j, Integer.MAX_VALUE);
            }
        }

        while (queue.size() > 0) {
            Cell cell = queue.poll();
            int temp[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int t[] : temp) {
                int row = cell.i + t[0];
                int col = cell.j + t[1];
                if (row < 0 || row >= matrix.size() || col < 0 || col >= matrix.get(0).size() || matrix.get(row).get(col) <= matrix.get(cell.i).get(cell.j) + 1)
                    continue;
                queue.add(new Cell(row, col));
                matrix.get(row).set(col, matrix.get(cell.i).get(cell.j) + 1);
            }
        }
        return matrix;
    }
}
