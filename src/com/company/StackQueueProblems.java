package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pratap on 1/8/17.
 */
public class StackQueueProblems {
    public static void main(String[] args) {
//        String path = "/home/./../bkp/check/./..";
//        System.out.println(simplifyPath(path));
//        System.out.println(simplifyPath2(path));


        Integer[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));

        System.out.println(slidingMaximum(list, 9));
    }

    public static String simplifyPath(String path) {
        if (!path.startsWith("/"))
            return "";
        else {
            ArrayList<String> stack = new ArrayList<>();
            for (int i = 0; i < path.length() && i >= 0; ) {
                // Below 3 lines leads to TLE
                // check below method for correct approach
                path = path.substring(i + 1);
                String str = path.substring(0, path.indexOf('/') == -1 ? path.length() : path.indexOf('/'));
                i = path.indexOf('/');
                if (str.equals("."))
                    continue;
                else if (str.equals("..") && stack.size() > 0) {
                    stack.remove(stack.size() - 1);
                } else if (!str.equals("") && !str.equals(".") && !str.equals(".."))
                    stack.add(str);
            }
            StringBuilder simplifiedPath = new StringBuilder("/");
            for (int i = 0; i < stack.size(); i++) {
                simplifiedPath = simplifiedPath.append(stack.get(i));
                if (i != stack.size() - 1)
                    simplifiedPath = simplifiedPath.append("/");
            }
            return simplifiedPath.toString();
        }
    }

    public static String simplifyPath2(String path) {
        if (!path.startsWith("/"))
            return "";
        else {
            ArrayList<String> stack = new ArrayList<>();
            String pathArray[] = path.split("/");
            for (int i = 0; i < pathArray.length; i++) {
                String str = pathArray[i];
                if (str.equals("."))
                    continue;
                else if (str.equals("..") && stack.size() > 0) {
                    stack.remove(stack.size() - 1);
                } else if (!str.equals("") && !str.equals(".") && !str.equals(".."))
                    stack.add(str);
            }
            StringBuilder simplifiedPath = new StringBuilder("/");
            for (int i = 0; i < stack.size(); i++) {
                simplifiedPath = simplifiedPath.append(stack.get(i));
                if (i != stack.size() - 1)
                    simplifiedPath = simplifiedPath.append("/");
            }
            return simplifiedPath.toString();
        }
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        ArrayList<Integer> maxList = new ArrayList<>();
        if ( b > a.size()){
            maxList.add(findMax(a));
            return maxList;
        } else {
            int i =0, j = b;
            while(j <= a.size()){
                List<Integer> sublist = a.subList(i,j);
                maxList.add(findMax(sublist));
                i++;
                j++;
            }
        }
        return maxList;
    }

    public static int findMax(List<Integer> list){
        int max = list.get(0);
        for(int i = 1;i<list.size();i++){
            if (max < list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }
}
