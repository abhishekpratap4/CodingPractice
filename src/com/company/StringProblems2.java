package com.company;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by pratap on 12/29/16.
 */
public class StringProblems2 {

    public static void main(String[] args) {
//        System.out.println(reverseWords("   the        sky        is      blue "));
//        System.out.println(countAndSay(5));
//        System.out.println(isPalindrome("1a2"));
//        System.out.println(intToRoman(romanToInt("MMXIV")));
//        System.out.println(addBinary("1010110111001101101000", "1000011011000000111100110"));
//        System.out.println(power("01253"));
//        System.out.println(reverse(3));
//        System.out.println(numSetBits(11));
//        System.out.print(findSingle());
//        System.out.println(isNumber("0"));
//        System.out.println(isNumber(" 0.1 "));
//        System.out.println(isNumber("abc"));
//        System.out.println(isNumber("1 a"));
//        System.out.println(isNumber("2e10"));
//        System.out.println(isNumber("0.1e10"));
//        System.out.println(isNumber("-0.1e-10"));
//        System.out.println(isNumber("3e0.1"));
//        System.out.println(isNumber("008"));
//        System.out.println(isNumber("1.e1"));
//        System.out.println(strStr("haystackneedlegigu", "needles"));
//        System.out.println(longestPalindrome(""));

//        String[] arr = {
//                "abcdefghijk",
//                "abcesfghijk",
//                "abcedfghijk"
//        };
//        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
//        System.out.println(commonPrefix(list));

        System.out.println(zigZagString("ABCDEFGHIJKLMNOPQRS", 6));
    }

    public static String reverseWords(String a) {
        a = a.trim().replaceAll("\\s+", " ");
        String[] arr = a.split(" ");
        StringBuilder newStr = new StringBuilder("");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == 0)
                newStr.append(arr[i]);
            else
                newStr.append(arr[i] + " ");
        }
        return newStr.toString();
    }

    public static String countAndSay(int a) {
        if (a <= 0)
            return "";

        String str = "1";
        while (a > 1) {
            str = countNumbers(str);
            a--;
        }
        return str;
    }

    public static String countNumbers(String str) {

        // str = "111221";
        if (str.isEmpty())
            return "";

        char start = str.charAt(0);
        int count = 1;
        StringBuilder countSeq = new StringBuilder("");
        for (int i = 1; i < str.length(); i++) {
            if (start == str.charAt(i)) {
                count++;
            } else {
                countSeq.append(count + Character.toString(start));
                count = 1;
                start = str.charAt(i);
            }
        }

        countSeq.append(count + Character.toString(start));

        return countSeq.toString();

    }

    public static int isPalindrome(String a) {
        a = a.toLowerCase();
        boolean flag = true;
        for (int i = 0, j = a.length() - 1; i < a.length() && j >= 0; ) {
            if (a.charAt(i) == a.charAt(j)) {
                i++;
                j--;
                continue;
            } else if (!Character.isLetterOrDigit(a.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(a.charAt(j))) {
                j--;
            } else {
                flag = false;
                break;
            }
        }
        if (flag)
            return 1;
        else
            return 0;
    }

    public static int romanToInt(String a) {
        //a = "MMXIV"
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char start = a.charAt(0);
        int num = map.get(start);
        for (int i = 1; i < a.length(); i++) {
            if (map.get(start) < map.get(a.charAt(i))) {
                num = num - map.get(start) + (map.get(a.charAt(i)) - map.get(start));
            } else {
                num = num + map.get(a.charAt(i));
            }
            start = a.charAt(i);
        }

        return num;
    }

    public static String intToRoman(int a) {
        int x = a;
        int i = 1;
        ArrayList<String> arr = new ArrayList<>();
        while (a != 0) {
            int rem = (a % 10) * i;
            i = i * 10;
            arr.add(_int2Roman(rem, i));
            a = a / 10;
        }
        StringBuilder roman = new StringBuilder("");
        for (int j = arr.size() - 1; j >= 0; j--) {
            roman = roman.append(arr.get(j));
        }
        return roman.toString();
    }

    public static String _int2Roman(int x, int i) {
        if (x == 0)
            return "";
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(20, "XX");
        map.put(30, "XXX");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXXX");
        map.put(90, "LC");
        map.put(100, "C");
        map.put(200, "CC");
        map.put(300, "CCC");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(600, "DC");
        map.put(700, "DCC");
        map.put(800, "DCCC");
        map.put(900, "CM");
        map.put(1000, "M");
        map.put(2000, "MM");
        map.put(3000, "MM");
        int arr[] = {1, 5, 10, 50, 100, 500, 1000};
        if (map.get(x) != null)
            return map.get(x).toString();
        return "";
    }

    public static String addBinary(String a, String b) {
        int diff = 0;
        StringBuilder diffString = new StringBuilder("");
        if (a.length() > b.length()) {
            diff = a.length() - b.length();
            while (diff > 0) {
                diffString.append(0);
                diff--;
            }
            b = diffString.toString() + b;
        } else {
            diff = b.length() - a.length();
            while (diff > 0) {
                diffString.append(0);
                diff--;
            }
            a = diffString.toString() + a;
        }


        char sum = '0';
        char carry = '0';
        StringBuilder sumString = new StringBuilder("");
        for (int i = a.length() - 1; i >= 0; i--) {
            char a1 = a.charAt(i);
            char b1 = b.charAt(i);

            if (a1 == '1' && b1 == '1' && carry == '1') {
                sum = '1';
                carry = '1';
            } else if (a1 == '1' && b1 == '1' && carry == '0') {
                sum = '0';
                carry = '1';
            } else if (a1 == '0' && b1 == '0' && carry == '1') {
                sum = '1';
                carry = '0';
            } else if (a1 == '0' && b1 == '0' && carry == '0') {
                sum = '0';
                carry = '0';
            } else if ((a1 == '1' && b1 == '0' && carry == '1') || (a1 == '0' && b1 == '1' && carry == '1')) {
                sum = '0';
                carry = '1';
            } else if ((a1 == '1' && b1 == '0' && carry == '0') || (a1 == '0' && b1 == '1' && carry == '0')) {
                sum = '1';
                carry = '0';
            } else {
                sum = '1';
                carry = '0';
            }

            sumString.append(Character.toString(sum));
        }

        if (carry == '1')
            sumString.append(carry);

        sumString = sumString.reverse();
        return sumString.toString();
    }

    public static int power(String a) {
        a = a.replaceFirst("^0+(?!$)", "");
        boolean flag = false;
        while (a.length() >= 1) {
            int rem = 0;
            int div = 0;
            StringBuilder dividend = new StringBuilder("");
            for (int i = 0; i < a.length(); i++) {
                int num = Integer.parseInt(Integer.toString(rem) + Character.toString(a.charAt(i)));
                rem = num % 2;
                div = num / 2;
                dividend.append(div);
            }
            a = dividend.toString();
            //System.out.println(a);
            if (rem != 0) {
                flag = true;
                break;
            }
            a = a.replaceFirst("^0+(?!$)", "");
            if (rem == 0 && a.equals("1"))
                return 1;

        }
        return 0;
    }

    public static int numSetBits(long a) {
//        String bStr = Long.toBinaryString(a);
//        int count = 0;
//        for (int i = 0; i < bStr.length(); i++) {
//            if (bStr.charAt(i) == '1')
//                count++;
//        }
//        return count;

        int count = 0;
        for (int i = 0; i < 32; i++) {
            long bit = (a >> i) & 1;
            System.out.println(bit);
            if (bit == 1) {
                count++;
            }
        }
        return count;
    }

    public static long reverse(long a) {
//        if (a == 0)
//            return 0;
//
//        StringBuilder bStr = new StringBuilder(Long.toBinaryString(a));
//        int diff = 32 - bStr.length();
//        StringBuilder padString = new StringBuilder();
//        while (diff > 0) {
//            padString.append('0');
//            diff--;
//        }
//        bStr = padString.append(bStr);
//        bStr.reverse();
//        BigInteger big = new BigInteger(bStr.toString(), 2);
//        return big.longValue();

        if (a == 0)
            return 0;

        for (int i = 0, j = 31 - i; i < 16; i++, j--) {
            long x = ((a >> i) & 1);
            long y = ((a >> j) & 1);
            if ((x ^ y) == 1) {
                a = a ^ ((1L << i) | (1L << j));
            }
        }

        return a;

    }

    public static int findSingle() {
        Integer[] a = {1, 2, 2, 3, 1};
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(a));
        if (arr == null || arr.size() == 0)
            return -1;
        int res = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            res = res ^ arr.get(i);
        }
        return res;
    }

    public static int isNumber(final String str) {
        if (str.charAt(str.length() - 1) == '.')
            return 0;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == '.' && str.charAt(i + 1) == 'e')
                return 0;
        }

        try {
            Integer.parseInt(str);
            return 1;
        } catch (NumberFormatException e1) {
            try {
                Long.parseLong(str);
                return 1;
            } catch (NumberFormatException e2) {
                try {
                    Float.parseFloat(str);
                    return 1;
                } catch (NumberFormatException e3) {
                    try {
                        Double.parseDouble(str);
                        return 1;
                    } catch (NumberFormatException e4) {
                        return 0;
                    }
                }
            }
        }
    }

    public static int strStr(final String haystack, final String needle) {
        if (haystack.isEmpty() || needle.isEmpty())
            return -1;

        int start = 0;
        int pos = -1;

        for (int i = start, j = 0; i < haystack.length() && j < needle.length() && haystack.length() - start >= needle.length(); ) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                if (pos == -1)
                    pos = i;
                i++;
                j++;
            } else {
                j = 0;
                start++;
                i = start;
                pos = -1;
            }
        }
        return pos;
    }

    public static String longestPalindrome(String a) {
        String longest = "";
        int length = 0;
        int start = 0;
        for (int i = start, j = a.length(); i < a.length() && j >= 0; ) {
            String substring = a.substring(i, j);
            if (isPalindromeString(substring)) {
                if (substring.length() > length) {
                    longest = substring;
                    length = substring.length();
                }
                start++;
                i = start;
                j = a.length();
            } else {
                j--;
            }
        }
        return longest;
    }

    public static boolean isPalindromeString(String str) {
        for (int i = 0, j = str.length() - 1; i < str.length() / 2 && j >= 0; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }

    public static String commonPrefix(ArrayList<String> list) {
        if (list == null || list.size() == 0)
            return "";
        int minSize = list.get(0).length();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() < minSize)
                minSize = list.get(i).length();
        }
        boolean flag = false;
        StringBuilder maxPrefix = new StringBuilder("");
        StringBuilder prefix = new StringBuilder("");
        char toCheck;
        for (int i = 0; i < minSize; i++) {

            flag = false;
            toCheck = list.get(0).charAt(i);

            for (int j = 0; j < list.size() && j + 1 < list.size(); j++) {
                if (list.get(j).charAt(i) != list.get(j + 1).charAt(i)) {
                    flag = true;
                    prefix = new StringBuilder("");
                    break;
                }
            }
            if (flag == false) {
                prefix = prefix.append(Character.toString(toCheck));
            } else {
                break;
            }

            if (prefix.length() > maxPrefix.length())
                maxPrefix = prefix;

        }
        return maxPrefix.toString();
    }

    public static String zigZagString(String str, int N) {
        if (N >= str.length() || N == 1)
            return str;
        int diff;
        StringBuilder output = new StringBuilder("");
        StringBuilder temp;
        for (int i = 0; i < N; i++) {
            if (i != N - 1) {
                diff = (N - (i + 1) - 1) * 2 + 1;
            } else {
                diff = (N - (0 + 1) - 1) * 2 + 1;
            }
            temp = new StringBuilder("");
            for (int j = i; j < str.length(); j = j + diff + 1) {
                temp.append(str.charAt(j));
            }
            output.append(temp);
        }
        return output.toString();
    }
}
