package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by pratap on 1/6/17.
 */
public class DoublePointerProblems {

    public static void main(String[] args) {
        Integer[] arr1 = {0, 1, 1, 1};
        Integer[] arr2 = {3, 3, 5};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr1));
        List<Integer> b = new ArrayList<>(Arrays.asList(arr2));
        System.out.print(maxone(a, 0));
    }

    public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        int i = 0, j = 0;
        ArrayList<Integer> output = new ArrayList<>();
        while (i < a.size() && j < b.size()) {
            if (a.get(i).intValue() == b.get(j).intValue()) {
                output.add(a.get(i));
                i++;
                j++;
            } else if (a.get(i).intValue() < b.get(j).intValue()) {
                i++;
            } else {
                j++;
            }
        }
        return output;
    }

    public static int threeSumClosest(ArrayList<Integer> a, int b) {
        if (a.size() < 3)
            return -1;
        //Collections.sort(a);
        int sum, closeSum = a.get(0) + a.get(1) + a.get(2);
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                for (int k = 0; k < a.size(); k++) {
                    if (i != j && i != k && j != k) {
                        sum = a.get(i) + a.get(j) + a.get(k);
                        if (Math.abs(b - sum) < Math.abs(b - closeSum)) {
                            closeSum = sum;
                        }
                    }
                }
            }
        }
        return closeSum;
    }

    public static int threeSumClosestBetter(ArrayList<Integer> a, int b) {
        if (a.size() < 3)
            return -1;
        Collections.sort(a);
        int sum, closeSum = 1000000000;
        for (int i = 0; i < a.size(); i++) {
            int fixed = a.get(i);
            int j = i + 1, k = a.size() - 1;
            while (j < k) {
                sum = fixed + a.get(j) + a.get(k);
                if (Math.abs(b - sum) < Math.abs(b - closeSum)) {
                    closeSum = sum;
                }

                if (sum > b) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return closeSum;
    }

    public static int removeElement(ArrayList<Integer> a, int b) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b) {
                count++;
            } else {
                a.set(i - count, a.get(i));
            }
        }

        for (int i = 1; i <= count; i++) {
            a.remove(a.size() - 1);
        }
        //System.out.println(a.size());
        return a.size();
    }

    public static ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        int leftIndex = 0, rightIndex = 0, bestLeftIndex = 0, bestRightIndex = 0, bestLength = 0, zeroCount = 0;
        while (rightIndex < a.size()) {
            if (zeroCount <= b) {
                if (a.get(rightIndex) == 0)
                    zeroCount++;
                rightIndex++;
            }

            if (zeroCount > b) {
                if (a.get(leftIndex) == 0)
                    zeroCount--;
                leftIndex++;
            }

            if (rightIndex - leftIndex > bestLength) {
                bestLength = rightIndex - leftIndex;
                bestLeftIndex = leftIndex;
                bestRightIndex = rightIndex - 1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = bestLeftIndex; i <= bestRightIndex; i++) {
            list.add(i);
        }
        return list;
    }
}
