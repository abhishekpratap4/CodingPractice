package com.company;

import java.util.LinkedHashSet;

/**
 * Created by pratap on 10/12/16.
 */

public class MyString {
    public static void removeChars() {
        StringBuilder str1 = new StringBuilder("geeksforgeeks");
        StringBuilder str2 = new StringBuilder("mask");
        StringBuilder str3 = new StringBuilder();


        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                if (str2.charAt(i) == str1.charAt(j)) {
                    str1.deleteCharAt(j);
                }
            }
        }
        System.out.println("String is: " + str1);
    }

    public static void checkIfStringContainsChars() {
        String strArr[] = {"sunday", "monday", "checksunday", "tshujnk"};
        String str = "sun";
        boolean flag = false;
        for (String s : strArr) {
            for (int i = 0; i < str.length(); i++) {
                flag = false;
                for (int j = 0; j < s.length(); j++) {
                    if (str.charAt(i) == s.charAt(j)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println("Not found: " + s);
                    break;
                }
            }
            if (flag) {
                System.out.println("Found: " + s);
            }
        }
    }

    public static void checkIfStringContainsCharsUpdated() {
        String strArr[] = {"sunday", "monday", "checksunday", "tshujnk"};
        String str = "sun";
        boolean flag = false;
        LinkedHashSet set1 = new LinkedHashSet();
        for (int i = 0; i < str.length(); i++) {
            set1.add(str.charAt(i));
        }
        LinkedHashSet set2;
        for (String s : strArr) {
            set2 = new LinkedHashSet();
            for (int j = 0; j < s.length(); j++) {
                set2.add(s.charAt(j));
            }
            if (set2.containsAll(set1)) {
                System.out.println("Found: " + s);
            } else {
                System.out.println("Not Found: " + s);
            }
        }
    }

    public static void getEncoding() {
        String str = "wwwwaaadexxxxxxyyz";
        int c = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i <= str.length() - 2) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    c++;
                } else {
                    System.out.print(str.charAt(i));
                    System.out.print(c);
                    c = 1;
                }
            } else {
                if(str.charAt(i) == str.charAt(i-1)){
                    System.out.print(str.charAt(i));
                    System.out.print(c);
                } else {
                    System.out.print(str.charAt(i));
                    System.out.print(1);
                }
            }
        }
    }

    public static void countWords(){
        String s = "One two          three\n  four\nfive  ";
        int length = s.split("[\\s]+").length;
        System.out.print(length);
    }

}
