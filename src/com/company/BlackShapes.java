package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Created by pratap on 2/5/17.
 * https://www.interviewbit.com/problems/black-shapes/
 */
public class BlackShapes {
    public static void main(String[] args) {
        BlackShapes shapes = new BlackShapes();
        String[] arr = {"0000000", "XXXX0XX", "0000000"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        System.out.print(shapes.black(list));
    }

    public int black(ArrayList<String> a) {
        if (a == null || a.size() == 0)
            return 0;
        //create a graph
        int[][] graph = createGraph(a);
        //traverse graph to find shape
        return findShape(graph, a.size(), a.get(0).length());
    }

    private int findShape(int[][] graph, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    traverse(graph, visited, i, j, N, M);
                    count++;
                }
            }
        }
        return count;
    }

    private void traverse(int[][] graph, boolean[][] visited, int i, int j, int N, int M) {
        if (i < 0 || i >= N)
            return;
        if (j < 0 || j >= M)
            return;
        if (graph[i][j] == 0 || visited[i][j])
            return;

        visited[i][j] = true;
        traverse(graph, visited, i - 1, j, N, M);
        traverse(graph, visited, i + 1, j, N, M);
        traverse(graph, visited, i, j - 1, N, M);
        traverse(graph, visited, i, j + 1, N, M);
    }

    private int[][] createGraph(ArrayList<String> a) {
        int graph[][] = new int[a.size()][a.get(0).length()];
        int N = a.size();
        int M = a.get(0).length();
        for (int i = 0; i < N; i++) {
            String s = a.get(i);
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == 'X')
                    graph[i][j] = 1;
                else
                    graph[i][j] = 0;
            }
        }
        return graph;
    }
}
