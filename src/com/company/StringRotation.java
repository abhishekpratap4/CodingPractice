package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by pratap on 10/22/16.
 */
public class StringRotation {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            String S = reader.readLine();
            System.out.println(findPrice(S));
        }


    }

    private static int findPrice(String s) {
        ArrayList<String> list = new ArrayList<>();
        list.add(s);
        String s1 = s;

        for (int i = 0; i < s.length() - 1; i++) {
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);

            if (s1.equals(s))
                break;

            if (list.contains(s)) {
                continue;
            } else {
                //System.out.println("i = : " + i);
                list.add(s);
            }
        }
        return list.size();

        /*
        HashSet<String> set = new HashSet<>();
        String s1 = s;
        set.add(s);
        for (int i = 0; i < s.length() - 1; i++) {
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);

            if (s1.equals(s))
                break;

            if (set.contains(s)) {
                continue;
            } else {
                //System.out.println("i = : " + i);
                set.add(s);
            }
        }
        return set.size();
        */
    }
}
