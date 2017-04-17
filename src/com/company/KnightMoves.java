package com.company;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by pratap on 2/4/17.
 * https://www.interviewbit.com/problems/knight-on-chess-board/
 */
public class KnightMoves {

    public static void main(String[] args) {
        System.out.print("\n" + knight(8, 8, 1, 1, 8, 8));
    }

    public static int knight(int N, int M, int x1, int y1, int x2, int y2) {
        // create a graph with valid edges
        KnightGraph graph = createKnightMovementGraph(N, M);

        //find the shortest path from source to destination
        int sourceNode = (x1 - 1) * M + y1 - 1;
        int destNode = (x2 - 1) * M + y2 - 1;
        if (sourceNode == destNode)
            return 0;
        return traverseGraphUsingBFS(graph, sourceNode, destNode);
    }

    private static int traverseGraphUsingBFS(KnightGraph graph, int s, int d) {
        HashMap<Integer, Boolean> visitedMap = new HashMap<>();
        int[] predecessor = new int[graph.V];
        Arrays.fill(predecessor, -1);

        Queue<Integer> queue = new LinkedList<>();
        visitedMap.put(s, true);
        queue.add(s);
        while (queue.size() > 0) {
            int node = queue.poll();
            LinkedList<Integer> neighbour = graph.adj[node];
            Iterator<Integer> it = neighbour.iterator();
            while (it.hasNext()) {
                int temp = it.next();
                if (!visitedMap.containsKey(temp)) {
                    visitedMap.put(temp, true);
                    predecessor[temp] = node;
                    queue.add(temp);
                }
            }
        }

        if (predecessor[d] == -1)
            return -1;

        int i = predecessor[d];
        int count = 1;
        System.out.print(d + "<--");
        while (i != s) {
            System.out.print(i + "<--");
            count++;
            i = predecessor[i];
        }
        System.out.print(i + "\t");
        return count;
    }

    static KnightGraph createKnightMovementGraph(int N, int M) {
        KnightGraph graph = new KnightGraph(N * M);

        for (int k = 0; k < graph.V; k++) {
            int i = k / M;
            int j = k % M;

            if (i + 2 < N && j + 1 < M) {
                graph.adj[k].add((i + 2) * M + (j + 1));
            }
            if (i + 2 < N && j - 1 >= 0) {
                graph.adj[k].add((i + 2) * M + (j - 1));
            }
            if (i - 2 >= 0 && j + 1 < M) {
                graph.adj[k].add((i - 2) * M + (j + 1));
            }
            if (i - 2 >= 0 && j - 1 >= 0) {
                graph.adj[k].add((i - 2) * M + (j - 1));
            }
            if (i + 1 < N && j + 2 < M) {
                graph.adj[k].add((i + 1) * M + (j + 2));
            }
            if (i + 1 < N && j - 2 >= 0) {
                graph.adj[k].add((i + 1) * M + (j - 2));
            }
            if (i - 1 >= 0 && j + 2 < M) {
                graph.adj[k].add((i - 1) * M + (j + 2));
            }
            if (i - 1 >= 0 && j - 2 >= 0) {
                graph.adj[k].add((i - 1) * M + (j - 2));
            }
        }


        return graph;
    }
}

class KnightGraph {
    int V;
    LinkedList<Integer> adj[];

    KnightGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }
}
