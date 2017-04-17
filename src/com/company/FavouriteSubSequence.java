package com.company;

import com.sun.tools.jdi.DoubleValueImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pratap on 2/25/17.
 */
public class FavouriteSubSequence {
    public static void main(String args[]) throws Exception {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        double powerSet = Math.pow(2, str.length());
        String pattern = "^a+b+c+";
        int count = 0;

        Set<StringBuilder> set = new HashSet<>();

        Pattern r = Pattern.compile(pattern);
        for (double i = 1; i < powerSet; i++) {
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j < str.length(); j++) {
                System.out.println(Double.doubleToRawLongBits(i));
                System.out.println(Double.doubleToRawLongBits(1<<j));
                if(Double.longBitsToDouble(Double.doubleToRawLongBits(i) & Double.doubleToRawLongBits(1 << j)) != 0.0){
                    sb.append(str.charAt(j));
                }
            }
            System.out.println(sb);
            Matcher m = r.matcher(sb);
            if(m.find()){
                set.add(sb);
            }
        }
        System.out.println(set.size());
    }
}

