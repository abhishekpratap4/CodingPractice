package com.company;

/**
 * Created by pratap on 5/2/17.
 */
public class Bomber {

//    public static void bomberAlgo(String str) {
//        String s = str, sub = "", output = "";
//        s = s + " ";
//        for (int i = 0; i < s.length(); i++) {
//            try {
//                if (s.charAt(i) != s.charAt(i + 1) && !sub.contains(String.valueOf(s.charAt(i)))) {
//                    output = output + s.charAt(i);
//                }
//            } catch (Exception e) {
//                System.out.println();
//            }
//            sub = sub + s.charAt(i);
//        }
//
//        System.out.println(output);
//
//    }
//
//
//    public static void main(String[] args) {
//        Bomber.bomberAlgo("aabcccdee");
//        Bomber.bomberAlgo("abcdeedcbfgf");
//        Bomber.bomberAlgo("abbabbacc");
//
//
//    }


//    public static void main(String args[]) {
//        String temp2;
//        temp2 = "abbabbacc";
//        while (true) {
//            System.out.println(temp2);
//            temp2 = bomb(temp2);
//
//            if (temp2 == null)
//                break;
//        }
//
//    }
//
//
//    //Returns the string after removing the largest consecutive same character substring
//    public static String bomb(String str) {
//
//        int start = -1, end = -1;
//        int big = 0, temp = 0;
//
//        int i = 0, j = 0;
//        for (int k = 0; k <= str.length() - 2; ) {
//
//            if (str.charAt(k) == str.charAt(k + 1)) {
//                i = k;
//                temp = 0;
//                while (str.charAt(k) == str.charAt(k + 1)) {
//                    temp++;
//                    k++;
//
//                    if (k == str.length() - 1)
//                        break;
//                }
//
//                j = i + temp;
//                if (temp > big) {
//                    big = temp;
//                    start = i;
//                    end = j;
//                }
//
//            } else {
//                k++;
//            }
//        }
//
//        if (big > 0)
//            return str.substring(0, start) + str.substring(end + 1, str.length());
//        else //No bombing happened in this method call. So we can stop bombing the string
//            return null;
//    }

    public void bombString(String input) {
        if (input == null || input.length() == 0)
            return;
        while (true) {
            System.out.println(input);
            input = bombHelper(input);
            if (input == null)
                break;
        }
    }

    public static String bombHelper(String str) {
        int start = -1, end = -1, big = 0, temp = 0;
        int i = 0, j = 0;
        for (int k = 0; k <= str.length() - 2; ) {
            if (str.charAt(k) == str.charAt(k + 1)) {
                i = k;
                temp = 0;
                while (str.charAt(k) == str.charAt(k + 1)) {
                    k++;
                    temp++;
                    if (k == str.length() - 1)
                        break;
                }
                j = i + temp;
                if (temp > big) {
                    big = temp;
                    start = i;
                    end = j;
                }
            } else {
                k++;
            }
        }
        if (big > 0)
            return str.substring(0, start) + str.substring(end + 1, str.length());
        else
            return null;
    }
}
