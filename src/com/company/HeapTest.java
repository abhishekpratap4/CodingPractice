package com.company;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by pratap on 11/16/16.
 */
public class HeapTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(5);

        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(4);
        maxHeap.add(5);

        System.out.println(minHeap.peek());
        System.out.println(maxHeap.peek());

    }
}
