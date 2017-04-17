package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by pratap on 12/2/16.
 */
public class WaveArray {
    public static void main(String[] args) {
        Integer[] a = {1,3,2,4};
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(a));
        System.out.println(wave(b));
    }

    public static ArrayList<Integer> wave(ArrayList<Integer> a) {
        if (a == null || a.size() <= 0)
            return a;
        Collections.sort(a);
        ArrayList<Integer> b = new ArrayList<>();
        for (int j = 0, i = 1; i < a.size() || j < a.size(); i = i + 2, j = j + 2) {
            if(i == a.size()) {
                b.add(j,a.get(j));
                continue;
            }
            if(i<a.size())
                b.add((i - 1), a.get(i));
            if(j<a.size())
                b.add((j + 1), a.get(j));
        }
        return b;
    }
}
