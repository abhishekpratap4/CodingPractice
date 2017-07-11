package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pratap on 2/5/17.
 * https://www.interviewbit.com/problems/capture-regions-on-board/
 */
public class CaptureRegions {
    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        Character[] a1 = {'O'};
        //Character[] a2 = {'X', '0', 'X'};
        //Character[] a3 = {'X', 'X', 'X'};
        a.add(new ArrayList<>(Arrays.asList(a1)));
        //a.add(new ArrayList<>(Arrays.asList(a2)));
        //a.add(new ArrayList<>(Arrays.asList(a3)));

        CaptureRegions c = new CaptureRegions();

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                System.out.print(a.get(i).get(j) + "\t");
            }
            System.out.println();
        }
        System.out.println();

        c.solve(a);

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                System.out.print(a.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

    public void solve(ArrayList<ArrayList<Character>> a) {
        if (a == null || a.size() == 0)
            return;
        //create a graph
        int M = a.size();
        int N = a.get(0).size();
        char[][] graph = createGraph(a, M, N);

        for (int j = 0; j < N; j++) {
            if (graph[0][j] == 'O')
                bfs(graph, M, N, 0, j);
        }
        for (int j = 0; j < N; j++) {
            if (graph[M - 1][j] == 'O')
                bfs(graph, M, N, M - 1, j);
        }

        for (int i = 0; i < M; i++) {
            if (graph[i][0] == 'O')
                bfs(graph, M, N, i, 0);
        }
        for (int i = 0; i < M; i++) {
            if (graph[i][N - 1] == 'O')
                bfs(graph, M, N, i, N - 1);
        }

        for (int i = 0; i < M; i++) {
            ArrayList<Character> a1 = a.get(i);
            a1.clear();
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'O' || graph[i][j] == 'X')
                    a1.add('X');
                else if (graph[i][j] == '1')
                    a1.add('O');
            }
        }
    }

    void bfs(char[][] graph, int M, int N, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        int index = i * N + j;
        graph[i][j] = '1';
        queue.add(index);
        while (queue.size() > 0) {
            int temp = queue.poll();
            i = temp / N;
            j = temp % N;
            if (i - 1 >= 0 && graph[i - 1][j] == 'O') {
                graph[i - 1][j] = '1';
                queue.add((i - 1) * N + j);
            }
            if (i + 1 < M && graph[i + 1][j] == 'O') {
                graph[i + 1][j] = '1';
                queue.add((i + 1) * N + j);
            }

            if (j - 1 >= 0 && graph[i][j - 1] == 'O') {
                graph[i][j - 1] = '1';
                queue.add((i) * N + j - 1);
            }
            if (j + 1 < N && graph[i][j + 1] == 'O') {
                graph[i][j + 1] = '1';
                queue.add((i) * N + j + 1);
            }
        }
    }

    char[][] createGraph(ArrayList<ArrayList<Character>> a, int M, int N) {
        char[][] graph = new char[M][N];
        for (int i = 0; i < M; i++) {
            ArrayList<Character> list = a.get(i);
            for (int j = 0; j < N; j++) {
                graph[i][j] = list.get(j);
            }
        }
        return graph;
    }
}
