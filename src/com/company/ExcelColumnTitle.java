package com.company;

import java.util.HashMap;

/**
 * Created by pratap on 6/16/17.
 */
public class ExcelColumnTitle {
    public static void main(String[] args) {
        int a = 943566;
        StringBuilder result = new StringBuilder();
        while(a > 0){
            int rem = a % 26;
            if(rem == 0){
                result.append("Z");
                a = (a/26) - 1;
            }else{
                result.append((char)('A' + rem - 1));
                a = a/26;
            }
        }
        System.out.println(result.reverse().toString());
    }
}
