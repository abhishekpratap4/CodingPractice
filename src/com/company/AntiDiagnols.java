package com.company;

import java.util.ArrayList;

/**
 * Created by pratap on 12/18/16.
 */
public class AntiDiagnols {
    public static void main(String[] args) {
        //int a[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        int i = 0;
        ArrayList<ArrayList<Integer>> ArrOfArr = new ArrayList<>();
        int k = 0;
        for (int j = 0; j < a.size(); j++) {
            ArrayList<Integer> arr = new ArrayList<>();

            while (i < a.size() && k >= 0) {
                arr.add(a.get(i).get(k));
                i++;
                k--;
            }
            ArrOfArr.add(arr);
            k = i;
            i = 0;

        }


        k = a.size() - 1;
        i = 1;
        int retain_i = i;
        for (int j = a.size() - 1; j > 0; j--) {
            ArrayList<Integer> arr = new ArrayList<>();

            while (i < a.size() && k >= 0) {
                arr.add(a.get(i).get(k));
                i++;
                k--;
            }
            ArrOfArr.add(arr);
            i = retain_i + 1;
            retain_i = i;
            k = a.size() - 1;

        }

        System.out.print(ArrOfArr);

    }
}
