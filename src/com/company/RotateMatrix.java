package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by pratap on 12/3/16.
 */
public class RotateMatrix {

    public static void main(String[] args) {

        //Integer[] arr1 = {0, 0};
        //Integer[] arr2 = {1, 1};
        //Integer[] arr3 = {1,1,1};


        Integer[] arr1 =  {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1};
        Integer[] arr2 =  {0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0};
        Integer[] arr3 =  {0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0};
        Integer[] arr4 =  {0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0};
        Integer[] arr5 =  {0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0};
        Integer[] arr6 =  {0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1};
        Integer[] arr7 =  {0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0};
        Integer[] arr8 =  {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
        Integer[] arr9 =  {1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0};
        Integer[] arr10 =  {0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1};
        Integer[] arr11 =  {0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0};
        Integer[] arr12 =  {0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1};
        Integer[] arr13 =  {1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1};
        Integer[] arr14 =  {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1};
        Integer[] arr15 =  {1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0};
        Integer[] arr16 =  {0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0};
        Integer[] arr17 =  {1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1};
        Integer[] arr18 =  {0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1};
        Integer[] arr19 =  {0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        Integer[] arr20 =  {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1};
        Integer[] arr21 =  {0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1};
        Integer[] arr22 =  {0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1};
        Integer[] arr23 =  {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1};
        Integer[] arr24 =  {1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1};
        Integer[] arr25 =  {0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1};

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(arr1));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(arr2));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(arr3));
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(arr4));
        ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(arr5));
        ArrayList<Integer> list6 = new ArrayList<>(Arrays.asList(arr6));
        ArrayList<Integer> list7 = new ArrayList<>(Arrays.asList(arr7));
        ArrayList<Integer> list8 = new ArrayList<>(Arrays.asList(arr8));
        ArrayList<Integer> list9 = new ArrayList<>(Arrays.asList(arr9));
        ArrayList<Integer> list10 = new ArrayList<>(Arrays.asList(arr10));
        ArrayList<Integer> list11 = new ArrayList<>(Arrays.asList(arr11));
        ArrayList<Integer> list12 = new ArrayList<>(Arrays.asList(arr12));
        ArrayList<Integer> list13 = new ArrayList<>(Arrays.asList(arr13));
        ArrayList<Integer> list14 = new ArrayList<>(Arrays.asList(arr14));
        ArrayList<Integer> list15 = new ArrayList<>(Arrays.asList(arr15));
        ArrayList<Integer> list16 = new ArrayList<>(Arrays.asList(arr16));
        ArrayList<Integer> list17 = new ArrayList<>(Arrays.asList(arr17));
        ArrayList<Integer> list18 = new ArrayList<>(Arrays.asList(arr18));
        ArrayList<Integer> list19 = new ArrayList<>(Arrays.asList(arr19));
        ArrayList<Integer> list20 = new ArrayList<>(Arrays.asList(arr20));
        ArrayList<Integer> list21 = new ArrayList<>(Arrays.asList(arr21));
        ArrayList<Integer> list22 = new ArrayList<>(Arrays.asList(arr22));
        ArrayList<Integer> list23 = new ArrayList<>(Arrays.asList(arr23));
        ArrayList<Integer> list24 = new ArrayList<>(Arrays.asList(arr24));
        ArrayList<Integer> list25 = new ArrayList<>(Arrays.asList(arr25));

        //ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(arr3));

        ArrayList<ArrayList<Integer>> parentList = new ArrayList<>();
        parentList.add(list1);
        parentList.add(list2);
        parentList.add(list3);
        parentList.add(list4);
        parentList.add(list5);
        parentList.add(list6);
        parentList.add(list7);
        parentList.add(list8);
        parentList.add(list9);
        parentList.add(list10);
        parentList.add(list11);
        parentList.add(list12);
        parentList.add(list13);
        parentList.add(list14);
        parentList.add(list15);
        parentList.add(list16);
        parentList.add(list17);
        parentList.add(list18);
        parentList.add(list19);
        parentList.add(list20);
        parentList.add(list21);
        parentList.add(list22);
        parentList.add(list23);
        parentList.add(list24);
        parentList.add(list25);
        //parentList.add(list3);

        //rotate(parentList);
        setZeroes(parentList);


    }

    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0 && !rows.contains(i) && !cols.contains(j)) {
                    for (int p = 0; p < a.get(i).size(); p++) {
                        if (a.get(i).get(p) != 0) {
                            a.get(i).set(p, 0);

                        }
                    }

                    for (int q = 0; q < a.size(); q++) {
                        if (a.get(q).get(j) != 0) {
                            a.get(q).set(j, 0);

                        }
                    }
                    rows.add(i);
                    cols.add(j);
//                    for (int ii = 0; ii < a.size(); ii++) {
//                        ArrayList<Integer> temp = a.get(ii);
//                        System.out.println(temp);
//                    }
//                    System.out.println("*********************************************************************");

                    break;
                }

            }
        }
        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> temp = a.get(i);
            System.out.println(temp);
        }
    }

    private static void _setZeroes(ArrayList<ArrayList<Integer>> a, int i, int j) {
    }

    public static void rotate(ArrayList<ArrayList<Integer>> a) {

        for (int i = 0; i < a.size(); i++) {
            for (int j = i; j < a.size(); j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(j).get(i));
                a.get(j).set(i, temp);
            }
        }

        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> temp = a.get(i);
            System.out.println(temp);
        }

        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> temp = a.get(i);
            for (int j = 0, k = a.size() - 1; j < temp.size() / 2; j++, k--) {
                int t = temp.get(j);
                temp.set(j, temp.get(k));
                temp.set(k, t);
            }
        }

        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> temp = a.get(i);
            System.out.println(temp);
        }

    }
}
