package com.company;

/**
 * Created by pratap on 10/17/16.
 */
// Java program to print DFS traversal from a given given graph

import java.util.*;
import java.util.LinkedList;

// This class represents a directed graph using adjacency list
// representation
class Graph {
    private int V; // No. of vertices

    // Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    // A function used by DFS
    //    void DFSUtil(int v, boolean visited[]) {
    //        // Mark the current node as visited and print it
    //        visited[v] = true;
    //        System.out.print(v + " ");
    //
    //        // Recur for all the vertices adjacent to this vertex
    //        Iterator<Integer> i = adj[v].listIterator();
    //        while (i.hasNext()) {
    //            int n = i.next();
    //            if (!visited[n])
    //                DFSUtil(n, visited);
    //        }
    //    }

    // The function to do DFS traversal.
    void DFS(int s) {
        // Mark all the vertices as not visited(set as false by default in java)
        boolean visited[] = new boolean[V];

        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.add(s);
        while (stack.size() != 0) {
            s = stack.pop();
            System.out.print(s + " ");
            Iterator<Integer> it = adj[s].iterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    stack.add(n);
                }
            }
        }

        // Call the recursive helper function to print DFS traversal
        //DFSUtil(v, visited);
    }

    // prints BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited(By default // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public boolean isCyclic() {
        //@visited array to keep track of visited nodes
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        //@recStack recursion stack, to check which all nodes are present
        //on the stack
        Set<Integer> recStack = new HashSet<>();
        //System.out.println(V);
        //loop through all the vertices in the graph
        for (int i = 0; i < V; i++) {
            if (helper(i, visited, recStack))
                return true;
        }
        return false;
    }

    //@v : current vertex
    public boolean helper(int v, boolean[] visited, Set<Integer> recStack) {
        //System.out.println("v: " + v + " set: " + recStack);
        //if we have not visited the vertex v yet
        //then visit the vertex v and all its adjacent vertices
        if (!visited[v]) {
            //mark the vertex v to be visited
            visited[v] = true;
            //add v in the recursion stack
            recStack.add(v);
            //for all adjacent vertices
            for (int i : adj[v]) {
                //if the adjacent node is not visited yet
                if (!visited[i]) {
                    if (helper(i, visited, recStack))
                        return true;
                }
                //if the node is already present on the recursion stack
                //then there is cycle add return true
                else if (recStack.contains(i))
                    return true;
            }
        }
        //remove the node from the recursion stack
        recStack.remove(v);
        return false;
    }

    public static void main(String args[]) {
        Graph g = new Graph(3);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        //g.addEdge(2, 0);
        //g.addEdge(2, 3);
        //g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        g.DFS(0);

        System.out.println("\nFollowing is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(0);

        System.out.print("\nIs graph cyclic: " + g.isCyclic());
    }
}

/**
 * InterviewBit Graph problems
 * https://www.interviewbit.com/problems/clone-graph/
 */
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

class GraphProblem {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        HashMap<UndirectedGraphNode, Boolean> clonedMap = new HashMap<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> newOldNodeMapping = new HashMap<>();

        queue.add(node);
        UndirectedGraphNode newGraphNode = new UndirectedGraphNode(node.label);
        newOldNodeMapping.put(node, newGraphNode);

        while (queue.size() > 0) {
            UndirectedGraphNode temp = queue.poll();
            //check if already cloned the node
            if (clonedMap.containsKey(temp) == true)
                continue;

            UndirectedGraphNode head = newOldNodeMapping.get(temp);
            Iterator<UndirectedGraphNode> it = temp.neighbors.listIterator();

            while (it.hasNext()) {
                UndirectedGraphNode temp1 = it.next();
                queue.add(temp1);
                UndirectedGraphNode neighbourNode;
                // If node is already present, use it, else create a new node
                if (newOldNodeMapping.containsKey(temp1)) {
                    neighbourNode = newOldNodeMapping.get(temp1);
                } else {
                    neighbourNode = new UndirectedGraphNode(temp1.label);
                    newOldNodeMapping.put(temp1, neighbourNode);
                }
                head.neighbors.add(neighbourNode);
            }
            clonedMap.put(temp, true);
        }
        return newGraphNode;
    }
}

