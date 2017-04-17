package com.company;

import java.util.Scanner;

/**
 * Created by pratap on 10/23/16.
 * Prim's MST for undirected graph
 */
public class MinSpanningTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        Graph1 g = new Graph1(N, M);
        for (int i = 0; i < 2 * M; i = i + 2) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int r = scanner.nextInt();
            g.edgeList[i].src = x;
            g.edgeList[i].dest = y;
            g.edgeList[i].weight = r;

            g.edgeList[i + 1].src = y;
            g.edgeList[i + 1].dest = x;
            g.edgeList[i + 1].weight = r;
        }
        int S = scanner.nextInt();

        primsMST(g, S);
    }

    private static void primsMST(Graph1 g, int s) {
        int parentList[] = new int[g.V + 1];
        int keyList[] = new int[g.V + 1];// stores weight of edges
        boolean mstList[] = new boolean[g.V + 1]; // to check if node is visited
        for (int i = 1; i <= g.V; i++) {
            keyList[i] = Integer.MAX_VALUE;
            mstList[i] = false;
        }
        keyList[s] = 0;
        parentList[s] = -1;
        int sum = 0;
        for (int i = 1; i <= g.V; i++) {
            int u = min(keyList, mstList);
            mstList[u] = true;
            for (int j = 0; j < 2 * g.E; j++) {
                if (g.edgeList[j].src == u) {
                    int v = g.edgeList[j].dest;
                    int w = g.edgeList[j].weight;

                    if (mstList[v] == false && w < keyList[v]) {
                        keyList[v] = w;
                        parentList[v] = u;
                    }
                }
            }
        }

        for (int i = 1; i < keyList.length; i++) {
            sum = sum + keyList[i];
        }
        System.out.println(sum);

        // TODO: print MST
    }

    private static int min(int[] keyList, boolean[] mstList) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int i = 1; i < keyList.length; i++) {
            if (mstList[i] == false && keyList[i] < min) {
                min = keyList[i];
                min_index = i;
            }
        }
        return min_index;
    }
}

class Graph1 {
    int V, E;
    Edge1 edgeList[];

    Graph1(int v, int e) {
        this.V = v;
        this.E = e;
        edgeList = new Edge1[2 * e];// 2e because it is an undirected graph, so create opposite edge also
        for (int i = 0; i < 2 * e; i++) {
            edgeList[i] = new Edge1();
        }
    }
}

class Edge1 {
    int src, dest, weight;

    Edge1() {
        src = dest = weight = 0;
    }
}
