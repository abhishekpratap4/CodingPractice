package com.company;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pratap on 4/15/17.
 */
public class ElementFrequency {
    class ArrNode {
        int count;
        int first_Index;

        ArrNode(int c, int i) {
            count = c;
            first_Index = i;
        }

        public String toString() {
            return this.count + " - " + this.first_Index;
        }
    }

    public static void main(String[] args) {
        ElementFrequency e = new ElementFrequency();
        int arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
        e.sortByFrequency(arr);
    }

    private void sortByFrequency(int[] arr) {
        HashMap<Integer, ArrNode> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                ArrNode node = map.get(arr[i]);
                node.count += 1;
                map.put(arr[i], node);
            } else {
                map.put(arr[i], new ArrNode(1, i));
            }
        }
        ArrayList<Map.Entry<Integer, ArrNode>> list = (ArrayList<Map.Entry<Integer, ArrNode>>) map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o1.count > o2.count ? -1
                        : (o1.count < o2.count ? 1 : o1.first_Index < o2.first_Index ? -1 : 1)))
                .collect(Collectors.toList());
        System.out.print(list.stream().map(ele -> ele.getKey()).collect(Collectors.toList()));
    }
}
