package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by pratap on 10/16/16.
 */
public class SherlockAnagrams {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            String str = scanner.next();
            LinkedList<String> list = new LinkedList<>();
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    //System.out.println(str.substring(j, i + 1));
                    list.add(str.substring(j, i + 1));
                }
            }
            for (int i = 0; i < list.size(); i++) {
                char ch[] = list.get(i).toString().toCharArray();
                Arrays.sort(ch);
                list.set(i, String.valueOf(ch));
            }
            list.sort(Comparator.comparing(e -> e.length()));
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size() && list.get(i).length() == list.get(j).length(); j++) {
                    if (list.get(j).equals(list.get(i))) {
                        count++;
                    }
                }
            }
            System.out.println(count);
            t--;
        }

    }
}
