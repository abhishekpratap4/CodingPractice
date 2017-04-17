package com.company;

import java.util.*;

/**
 * Created by pratap on 2/5/17.
 */
public class GreedyProblems {
    public static void main(String[] args) {
        GreedyProblems g = new GreedyProblems();
        Integer a[] = {1, 2, 3, 4, 5};
        Integer b[] = {5, 4, 3, 2, 1};
        ArrayList<Integer> gas = new ArrayList<>(Arrays.asList(a));
        ArrayList<Integer> cost = new ArrayList<>(Arrays.asList(b));
        //System.out.print(g.maxp3(list));
        System.out.println(g.canCompleteCircuit(gas, cost));
    }

    // https://www.interviewbit.com/problems/highest-product/
    public int maxp3(ArrayList<Integer> a) {
        if (a == null || a.size() < 3)
            return -1;
        Collections.sort(a);
        int size = a.size();
        int max1 = a.get(size - 1);
        int max2 = a.get(size - 2);
        int max3 = a.get(size - 3);

        int min1 = a.get(0);
        int min2 = a.get(1);

        if (max1 < 0) {
            return max1 * max2 * max3;
        } else {
            if (max2 * max3 > min1 * min2)
                return max1 * max2 * max3;
            else
                return max1 * min1 * min2;
        }
    }

    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        if (gas == null || cost == null || cost.size() != gas.size() || cost.size() == 0 || gas.size() == 0)
            return -1;

        int startPos = 0;

        while (startPos < gas.size()) {
            int gasAmt = 0;
            int i = startPos;
            boolean flag = true;
            do {
                gasAmt += gas.get(i);
                if (gasAmt < cost.get(i)) {
                    startPos++;
                    flag = false;
                    break;
                } else {
                    gasAmt = gasAmt - cost.get(i);
                }

                if (i == gas.size() - 1)
                    i = 0;
                else if (i < gas.size())
                    i++;

            } while (i != startPos);
            if (flag)
                return startPos;
        }
        return -1;
    }

    public int majorityElement(final List<Integer> a) {
        if(a == null || a.size() == 0)
            return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<a.size();i++){
            if(map.containsKey(a.get(i))){
                map.put(a.get(i),map.get(a.get(i))+1);
            }else{
                map.put(a.get(i),1);
            }
        }
        int max = 0, max_ele = 0;
        for(Integer key : map.keySet()){
            if(map.get(key) > max){
                max = key;
                max_ele = map.get(key);
            }
        }
        return max_ele;
    }

}
