package com.company;

import java.util.*;

/**
 * Created by pratap on 4/7/17.
 */
public class GenerateP {

    public static void main(String[] args) {
        GenerateP p = new GenerateP();
        System.out.println(p.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0)
            return result;

        dfs(result, new StringBuilder(""), n, n);
        return result;

    }

    private void dfs(List<String> result, StringBuilder str, int left, int right) {

        if (left > right)
            return;
        if (left == 0 && right == 0) {
            result.add(str.toString());
            return;
        }
        System.out.println("DFS");
        if (left > 0) {
            dfs(result, str.append('('), left - 1, right);
            str.deleteCharAt(str.length() - 1);
        }
        if (right > 0) {
            dfs(result, str.append(')'), left, right - 1);
            str.deleteCharAt(str.length() - 1);
        }

        //System.out.println();
    }
}
