package com.company;

/**
 * Created by pratap on 4/9/17.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

class Graph2 {
    int V;
    LinkedList<Integer> adj[];

    Graph2(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
}

public class DFSApplication {
    public static void main(String args[]) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            int M = s.nextInt();
            Graph2 g = new Graph2(N);
            for (int j = 1; j <= M; j++) {
                int u = s.nextInt();
                int v = s.nextInt();
                g.adj[u - 1].add(v - 1);
            }
            if (checkCycle(g, N))
                System.out.println(0);
            else
                System.out.println(1);
        }
    }

    private static boolean checkCycle(Graph2 g, int N) {
        boolean visited[] = new boolean[N];
        Set<Integer> recStack = new HashSet<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (isCycleHelper(i, visited, recStack, g))
                    return true;
            }
        }
        return false;
    }

    private static boolean isCycleHelper(int v, boolean visited[], Set<Integer> recStack, Graph2 g) {
        if (!visited[v]) {
            visited[v] = true;
            recStack.add(v);
            for (int i : g.adj[v]) {
                if (!visited[i]) {
                    if (isCycleHelper(i, visited, recStack, g))
                        return true;
                } else if (recStack.contains(i))
                    return true;
            }
        }
        recStack.remove(v);
        return false;
    }
}
