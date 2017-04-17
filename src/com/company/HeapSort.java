package com.company;

import java.util.*;

/**
 * Created by pratap on 10/14/16.
 */
public class HeapSort {

    public static void sort() {
        int arr [] = {1,4,2,5,14,7,8,9,0,-1};
        Queue queue = new PriorityQueue<>();
        for(int x: arr) {
            queue.add(x);
        }

        while (!queue.isEmpty()){
            System.out.print(queue.poll()+ "\t");
        }

    }
}
