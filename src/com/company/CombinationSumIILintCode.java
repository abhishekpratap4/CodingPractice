package com.company;

import java.util.*;

/**
 * Created by pratap on 6/2/17.
 */
public class CombinationSumIILintCode {

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0)
            return result;
        Arrays.sort(num);
        List<Integer> temp = new ArrayList<>();
        Set<String> set = new HashSet<>();
        combinationSum2Util(num, target, result, temp, 0, set);
        return result;
    }

    private void combinationSum2Util(int[] num, int target, List<List<Integer>> result, List<Integer> temp, int index, Set<String> set) {
        if (target == 0) {
            String s = temp.toString();
            if (set.contains(s))
                return;
            set.add(s);
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < num.length; i++) {
            if (target < num[i])
                return;
            temp.add(num[i]);
            combinationSum2Util(num, target - num[i], result, temp, i + 1, set);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIILintCode code = new CombinationSumIILintCode();
        int num[] = {7, 1, 2, 5, 1, 6, 10};
        int target = 8;
        System.out.println(code.combinationSum2(num, target));
    }
}
