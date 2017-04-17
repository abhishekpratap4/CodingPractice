package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by pratap on 10/15/16.
 */
public class RunningMedianHeap {

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        double median = 0.0;

        for (int i = 0; i < n; i++) {
            median = calculateMedian(scanner.nextInt(), median, maxHeap, minHeap);
            System.out.println(median);
        }
    }

    public static double calculateMedian(int ele, double median, PriorityQueue maxH, PriorityQueue minH) {
        if (maxH.size() - minH.size() > 0) {
            if (ele < median) {
                minH.add(maxH.poll());
                maxH.add(ele);
            } else {
                minH.add(ele);
            }
            median = (((Integer) maxH.peek()).intValue() + ((Integer) minH.peek()).intValue()) / 2.0;
        } else if (maxH.size() - minH.size() == 0) {
            if (ele < median) {
                maxH.add(ele);
                median = (double) ((Integer) maxH.peek()).intValue();
            } else {
                minH.add(ele);
                median = (double) ((Integer) minH.peek()).intValue();
            }
        } else {
            if (ele < median) {
                maxH.add(ele);
            } else {
                maxH.add(minH.poll());
                minH.add(ele);
            }
            median = (((Integer) maxH.peek()).intValue() + ((Integer) minH.peek()).intValue()) / 2.0;
        }
        return median;
    }
}
