package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by pratap on 11/17/16.
 * http://www.geeksforgeeks.org/merge-k-sorted-arrays/
 * Time Complexity: O(nklogk)
 */
public class MergeKSortedArrays {
    public static void main(String[] args) {
        int arrays[][] = {
                {
                        2, 6, 12, 34
                },
                {
                        1, 9, 20, 1000
                },
                {
                        23, 34, 90, 2000
                }
        };
        mergeArrays(arrays);
    }

    private static void mergeArrays(int[][] arrays) {
        PriorityQueue<Element> eleQueue = new PriorityQueue<>(new ElementComparator());
        for (int i = 0; i < arrays.length; i++) {
            eleQueue.add(new Element(arrays[i][0], i, 1));
        }

        int l = arrays.length * arrays[0].length;
        int outputArray[] = new int[l];
        for (int i = 0; i < l; i++) {
            Element e = eleQueue.poll();
            outputArray[i] = e.value;
            if (e.nextEleIndex < arrays[e.arrIndex].length) {
                e.value = arrays[e.arrIndex][e.nextEleIndex];
                e.nextEleIndex += 1;
                eleQueue.add(e);
            }
        }
        for (int k = 0; k < l; k++) {
            System.out.print(outputArray[k] + "\t");
        }
    }
}

class Element {
    int value, arrIndex, nextEleIndex;

    Element(int v, int i, int j) {
        value = v;
        arrIndex = i;
        nextEleIndex = j;
    }
}

class ElementComparator implements Comparator<Element> {

    @Override
    public int compare(Element o1, Element o2) {
        return o1.value > o2.value ? 1 : o1.value == o2.value ? 0 : -1;
    }
}
