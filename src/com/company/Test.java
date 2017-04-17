package com.company;

import java.util.HashSet;

/**
 * Created by pratap on 10/25/16.
 */
public class Test {
    public static void main(String[] args) {
        int arr[] = {582740017, 954896345, 590538156, 298333230, 859747706, 155195851, 331503493, 799588305, 164222042, 563356693, 80522822, 432354938, 652248359};
        int arr2[] = {582740017, 954896345, 590538156, 298333230, 859747706, 155195851, 331503493, 799588305, 164222042, 563356693, 80522822, 432354938, 652248359};

        int k = 11;
        for (int i = 0; i < arr.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);
            for (int j = 0; j < arr2.length; j++) {
                if (j == i)
                    continue;
                else {
                    if ((arr[i] % k + arr2[j] % k) % k == 0)
                        set.add(arr2[j]);
                }
            }
            System.out.println(set);
        }
    }
}
