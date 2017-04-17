package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pratap on 12/28/16.
 */
public class MedianOfSortedArrays {
    public static void main(String[] args) {
        Integer[] a = {1, 4, 5};
        Integer[] b = {1, 2, 3, 4};
        ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(a));
        ArrayList<Integer> bList = new ArrayList<>(Arrays.asList(b));
        //System.out.println(sort(aList, bList));
        System.out.println(getMedian(aList));
        System.out.println(getMedian(bList));
    }

    public static double sort(ArrayList<Integer> aList, ArrayList<Integer> bList) {
        double m1 = getMedian(aList);
        double m2 = getMedian(bList);

        if (m1 == m2) {
            return m1;
        } else if (m1 < m2) {

        } else {

        }

        return 0.0;
    }

    public static double getMedian(ArrayList<Integer> list) {
        int size = list.size();
        if (size % 2 == 0) {
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
        } else {
            return list.get(size / 2);
        }
    }
}
