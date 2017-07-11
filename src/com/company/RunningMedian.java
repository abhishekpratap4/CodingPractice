package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by pratap on 10/15/16.
 */
public class RunningMedian {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
            calculateMedian(list);
        }
    }

    public static void calculateMedian(ArrayList list) {
        Collections.sort(list);
        if (list.size() % 2 == 0) {
            System.out.println(((int) list.get(list.size() / 2) + (int) list.get(list.size() / 2 - 1)) / 2.0);
        } else {
            System.out.println((int) (list.get(list.size() / 2)) + 0.0);
        }
    }
}
