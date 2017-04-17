package com.company;

import java.util.*;

/**
 * Created by pratap on 10/25/16.
 */
public class Subset {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int arr[] = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        //HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt() % k;
            //set.add(arr[i]);
            if (!map.containsKey(arr[i]))
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }


        Set<Integer> set2 = map.keySet();
        //System.out.print(set2);
        Object[] arr2 = set2.toArray();

        for (int i = 0; i < arr2.length; i++) {
            for (int j = i + 1; j < arr2.length; j++) {
                if ((int) arr2[i] + (int) arr2[j] == k) {
                    int min;
                    if (map.get(arr2[i]) < map.get(arr2[j])) {
                        min = (int) arr2[i];
                    } else {
                        min = (int) arr2[j];
                    }
                    //System.out.println("Removing: " + min);
                    map.remove(min);
                }
            }
        }
        Collection<Integer> c = map.values();
        Iterator<Integer> it = c.iterator();
        int sum = 0;
        while (it.hasNext()) {
            sum = sum + it.next();
        }
        System.out.println(sum);
    }
}
