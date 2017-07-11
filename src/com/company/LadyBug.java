package com.company;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Created by pratap on 10/15/16.
 */
public class LadyBug {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for (int a0 = 0; a0 < Q; a0++) {
            int n = in.nextInt();
            String b = in.next();
            isHappy(b);
        }
    }

    public static void isHappy(String b) {
        HashMap map = new HashMap();
        boolean contains_ = false;
        boolean isNeighbourSame = true;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '_') {
                contains_ = true;
                continue;
            }
            map.put(b.charAt(i), map.get(b.charAt(i)) == null ? 1 : (int) map.get(b.charAt(i)) + 1);
            if (i < b.length() - 1 && b.charAt(i) != b.charAt(i + 1)) {
                isNeighbourSame = false;
            }
        }
        Collection<Integer> list = map.values();
        boolean flag = false;

        for (int i : list) {
            if (i == 1) {
                flag = true;
                break;
            }
        }

        if (!contains_ && !isNeighbourSame) {
            System.out.println("NO");
        }
        else if (list.isEmpty() || !flag) {
            System.out.println("YES");
        } else if (flag) {
            System.out.println("NO");
        }
    }
}
