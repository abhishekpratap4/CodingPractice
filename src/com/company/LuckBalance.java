package com.company;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by pratap on 10/26/16.
 * https://www.hackerrank.com/challenges/luck-balance
 */
public class LuckBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i <= N; i++) {
            int L = scanner.nextInt();
            int T = scanner.nextInt();

            if (T == 0) {
                System.out.println("Added to sum : " + L);
                sum = sum + L;
            } else if (T == 1) {
                queue.add(L);
            }
        }

        for (int i = 1; i <= K; i++) {
            if(queue.size() > 0) {
                int p = queue.poll();
                sum = sum + p;
                System.out.println("Added to sum : " + p);
            }
        }

        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()){
            int q = it.next();
            sum = sum - q;
            System.out.println("Subtracted from sum : " + q);
        }

        System.out.println(sum);
    }
}
