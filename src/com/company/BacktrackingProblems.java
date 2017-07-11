package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by pratap on 1/14/17.
 */
public class BacktrackingProblems {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
//        System.out.println(combinationSum(list, 21));
//        System.out.println("*********************");
//        System.out.println(combinationSum2(list, 21));
        System.out.print(KthpermuteSeq(3, 3));
    }


    public static String KthpermuteSeq(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permutationHelper2(n, new ArrayList<Integer>(), result, k, false);
        ArrayList<Integer> list = result.get(result.size() - 1);
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i));
        }
        return str.toString();
    }

    public static boolean permutationHelper2(int n, ArrayList<Integer> tempList, ArrayList<ArrayList<Integer>> result, int k, boolean found) {
        if (tempList.size() == n) {
            result.add(new ArrayList<Integer>(tempList));
            if (result.size() == k) {
                return true;
            } else
                return false;
        } else {
            for (int i = 1; i <= n; i++) {
                if (tempList.contains(i))
                    continue;
                else {
                    tempList.add(i);
                    found = permutationHelper2(n, tempList, result, k, found);
                    if (found)
                        break;
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
        return found;
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permutationHelper(a, new ArrayList<Integer>(), result);
        return result;
    }

    public static void permutationHelper(ArrayList<Integer> list, ArrayList<Integer> tempList, ArrayList<ArrayList<Integer>> result) {
        if (tempList.size() == list.size())
            result.add(new ArrayList<Integer>(tempList));
        else {
            for (int i = 0; i < list.size(); i++) {
                if (tempList.contains(list.get(i)))
                    continue;
                else {
                    tempList.add(list.get(i));
                    permutationHelper(list, tempList, result);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(a);
        // Since number can be used again, remove duplicates from original list
        for (int i = 0; i < a.size() && i + 1 < a.size(); ) {
            if (a.get(i).equals(a.get(i + 1))) {
                a.remove(i + 1);
            } else
                i++;
        }
        combinationHelper(a, b, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public static void combinationHelper(ArrayList<Integer> num, int target, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = start; i < num.size(); i++) {
                temp.add(num.get(i));
                combinationHelper(num, target - num.get(i), i, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // sort list
        Collections.sort(a);
        combinationHelper2(a, b, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public static void combinationHelper2(ArrayList<Integer> num, int target, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
        if (target < 0)
            return;
        else if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = start; i < num.size(); i++) {
                if (i > start && num.get(i).equals(num.get(i - 1)))
                    continue;
                temp.add(num.get(i));
                combinationHelper2(num, target - num.get(i), i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }
}