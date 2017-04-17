package com.company;

import java.util.Scanner;

/**
 * Created by pratap on 10/20/16.
 */
public class GraphShortestReach {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        while (Q > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            MyGraph g = new MyGraph(n, m);
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                g.EdgeList[i].src = u;
                g.EdgeList[i].dest = v;
            }
            int s = scanner.nextInt();
            BellmanFord(g, s);
            Q--;
        }
    }

    public static void Dijkstra(MyGraph g, int s) {
        int dist[] = new int[g.V + 1];
        boolean shortSet[] = new boolean[g.V + 1];
        for (int i = 1; i <= g.V; i++) {
            dist[i] = Integer.MAX_VALUE;
            shortSet[i] = false;
        }
        dist[s] = 0;

        for (int i = 1; i <= g.V; i++) {
            int u = min(dist, shortSet);
            shortSet[u] = true;
            for (int j = 1; j <= g.V; j++) {
                if(!shortSet[j] && g.EdgeList[j].src == u){
                    //TODO: complete this function
                }
            }
        }

    }

    public static int min(int[] dist, boolean shortSet[]) {
        int min = dist[0];
        int min_index = 0;
        for (int i = 0; i < dist.length; i++) {
            if (!shortSet[i] && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static void BellmanFord(MyGraph g, int s) {
        int dist[] = new int[g.V + 1];
        for (int i = 1; i <= g.V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;

        for (int i = 1; i <= g.V; i++) {
            for (int j = 0; j < g.E; j++) {
                int u = g.EdgeList[j].src;
                int v = g.EdgeList[j].dest;
                int w = g.EdgeList[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        //print dist array
        for (int i = 1; i < dist.length; i++) {
            if (i != s) {
                int x = dist[i] == Integer.MAX_VALUE ? -1 : dist[i];
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }
}

class MyGraph {
    int V;
    int E;
    Edge EdgeList[];

    MyGraph(int v, int e) {
        V = v;
        E = e;
        EdgeList = new Edge[e];
        for (int i = 0; i < e; i++) {
            EdgeList[i] = new Edge();
        }
    }
}

class Edge {
    int src, dest, weight;

    Edge() {
        src = dest = weight = 6;
    }
}
