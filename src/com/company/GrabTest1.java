package com.company;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by pratap on 5/21/17.
 */
public class GrabTest1 {
    public static void main(String[] args) {
        GrabTest1 g = new GrabTest1();
        //System.out.println(g.solution("09:42", "11:42"));
        //int[] A = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        //System.out.println(g.totalCost(A));
        int[] T = {9, 1, 4, 9, 0, 4, 8, 9, 0, 1};
        System.out.println(Arrays.toString(g.getDistance(T)));
    }

    public int solution(String E, String L) {
        if (E == null || L == null || E.isEmpty() || L.isEmpty())
            return 0;

        String[] E_parts = E.split(":");
        String[] L_parts = L.split(":");

        int startHours = Integer.parseInt(E_parts[0]);
        int startMins = Integer.parseInt(E_parts[1]);

        int endHours = Integer.parseInt(L_parts[0]);
        int endMins = Integer.parseInt(L_parts[1]);

        if (startHours < 0 || startHours > 23 || startMins < 0 || startMins > 59 || endHours < 0 || endHours > 23 || endMins < 0 || endMins > 59)
            return 0;

        int total_cost = 2;
        int total_time_spent_mins = (endHours * 60 + endMins) - (startHours * 60 + startMins);
        int counter = 1;
        while (total_time_spent_mins > 0) {
            if (counter == 1) {
                total_cost += 3;
            } else {
                total_cost += 4;
            }
            total_time_spent_mins -= 60;
            counter++;
        }
        return total_cost;
    }

    public int totalCost(int[] A) {
        int totalCost = 0;
        if (A == null || A.length == 0)
            return totalCost;

        int count, start, end, i, j;
        for (i = 0; i < A.length; ) {
            start = A[i];
            end = start + 6;
            count = 1;
            for (j = i + 1; j < A.length; j++) {
                if (A[j] > start && A[j] <= end)
                    count++;
                else
                    break;
            }
            if (count > 3) {
                totalCost += 7;
                i = j;
            } else {
                totalCost += 2;
                i++;
            }
        }

        if (totalCost > 25) {
            totalCost = 25;
        }
        return totalCost;
    }

    class City {
        int val;
        HashSet<Integer> adjList[];

        City(int v) {
            val = v;
            adjList = new HashSet[val];
            for (int i = 0; i < v; i++)
                adjList[i] = new HashSet<>();
        }

        void addEdge(int v, int w) {
            adjList[v].add(w);
        }
    }

    public int[] getDistance(int[] T) {
        if (T == null || T.length == 0 || T.length == 1)
            return new int[0];
        int distance[] = new int[T.length - 1];
        City cityGraph = new City(T.length);
        int capital = 0;

        for (int i = 0; i < T.length; i++) {
            if (i == T[i]) {
                capital = i;
                continue;
            }
            cityGraph.addEdge(i, T[i]);
            cityGraph.addEdge(T[i], i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(capital);
        boolean visited[] = new boolean[T.length];
        visited[capital] = true;
        distance[0] = cityGraph.adjList[capital].size();
        int index = 1;
        while (queue.size() > 0) {
            capital = queue.poll();
            int size = cityGraph.adjList[capital].size();

            Iterator<Integer> it = cityGraph.adjList[capital].iterator();
            int childCount = 0;
            while (it.hasNext()) {
                int ele = it.next();
                if (!visited[ele]) {
                    visited[ele] = true;
                    queue.add(ele);
                    childCount += cityGraph.adjList[ele].size() - 1;
                }
            }
            if (index < T.length - 1) {
                distance[index] = childCount;
                index++;
            }
        }

        return distance;
    }
}
