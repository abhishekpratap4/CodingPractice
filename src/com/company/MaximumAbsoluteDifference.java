package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by pratap on 12/2/16.
 */
public class MaximumAbsoluteDifference {
    class Element implements Comparable<Element> {
        int eleValue;
        int eleIndex;

        @Override
        public int compareTo(Element element) {
            return Integer.compare(this.eleValue, element.eleValue);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {55, -8, 43, 52, 8, 59, -91, -79, -18, -94};
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(a));
        System.out.println(maxArr(b));
        System.out.println(new MaximumAbsoluteDifference().maxArrOptimized(b));
    }

    public static int maxArr(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                int x = Math.abs(A.get(i) - A.get(j)) + Math.abs(i - j);
                if (x > max) {
                    max = x;
                    System.out.println("1: Max ele: "+ A.get(i) + " Min Ele: " + A.get(j) + " maxIndex: "+ i + " minIndex: "+ j);
                }
            }
        }
        return max;
    }

    public int maxArrOptimized(ArrayList<Integer> A) {
        PriorityQueue<Element> maxHeap = new PriorityQueue<>((Element e1, Element e2) -> e2.compareTo(e1));
        PriorityQueue<Element> minHeap = new PriorityQueue<>((Element e1, Element e2) -> e1.compareTo(e2));
        for (int i = 0; i < A.size(); i++) {
            Element ele = new Element();
            ele.eleValue = A.get(i);
            ele.eleIndex = i;
            maxHeap.add(ele);
            minHeap.add(ele);
        }

        int max = Integer.MIN_VALUE;
        Element maxHeapEle = maxHeap.peek();
        int maxEle = maxHeapEle.eleValue;
        int maxIndex = maxHeapEle.eleIndex;

        Iterator<Element> it = minHeap.iterator();
        while (it.hasNext()) {
            Element minHeapEle = minHeap.poll();
            int minEle = minHeapEle.eleValue;
            int minIndex = minHeapEle.eleIndex;
            int x = Math.abs(maxEle - minEle) + Math.abs(maxIndex - minIndex);
            if (x > max) {
                max = x;
                System.out.println("2: Max ele: "+ maxEle + " Min Ele: " + minEle + " maxIndex: "+ maxIndex + " minIndex: "+ minIndex);
            }
        }

        return max;
    }
}
