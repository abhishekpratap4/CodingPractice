package com.company;

/**
 * Created by pratap on 4/9/17.
 */

import java.util.HashMap;

public class ConvertNumToENWords {

    HashMap<Integer, String> suffixMap;
    HashMap<Integer, String> onesMap;
    HashMap<Integer, String> tensMap;

    public static void main(String[] args) {
        ConvertNumToENWords convertNumToENWords = new ConvertNumToENWords();
        System.out.println(convertNumToENWords.numberToWords(1000010));
    }

    private void init() {
        suffixMap = new HashMap<>();
        suffixMap.put(1, "");
        suffixMap.put(2, "Thousand ");
        suffixMap.put(3, "Million ");
        suffixMap.put(4, "Billion ");

        onesMap = new HashMap<>();
        onesMap.put(0, "");
        onesMap.put(1, "One ");
        onesMap.put(2, "Two ");
        onesMap.put(3, "Three ");
        onesMap.put(4, "Four ");
        onesMap.put(5, "Five ");
        onesMap.put(6, "Six ");
        onesMap.put(7, "Seven ");
        onesMap.put(8, "Eight ");
        onesMap.put(9, "Nine ");

        tensMap = new HashMap<>();
        tensMap.put(10, "Ten ");
        tensMap.put(11, "Eleven ");
        tensMap.put(12, "Twelve ");
        tensMap.put(13, "Thirteen ");
        tensMap.put(14, "Fourteen ");
        tensMap.put(15, "Fifteen ");
        tensMap.put(16, "Sixteen ");
        tensMap.put(17, "Seventeen ");
        tensMap.put(18, "Eighteen ");
        tensMap.put(19, "Nineteen ");
        tensMap.put(20, "Twenty ");
        tensMap.put(30, "Thirty ");
        tensMap.put(40, "Fourty ");
        tensMap.put(50, "Fifty ");
        tensMap.put(60, "Sixty ");
        tensMap.put(70, "Seventy ");
        tensMap.put(80, "Eighty ");
        tensMap.put(90, "Ninety ");
    }

    public String numberToWords(int num) {
        init();
        if (num == 0)
            return "Zero";
        else {
            String numString = Integer.toString(num);
            int arr[] = new int[numString.length()];
            int i = arr.length - 1;
            while (num > 0) {
                arr[i] = num % 10;
                num = num / 10;
                i--;
            }
            StringBuilder word = new StringBuilder("");
            int remainingDigits = arr.length;
            int start = 0, end = arr.length - 1;

            if (remainingDigits >= 3) {
                end = arr.length - 1;
                start = arr.length - 3;
            } else if (remainingDigits == 2) {
                end = arr.length - 1;
                start = arr.length - 2;
            } else if (remainingDigits == 1) {
                end = arr.length - 1;
                start = arr.length - 1;
            } else
                return "";

            int section = 1;
            while (true) {
                StringBuilder temp = convertUtil(arr, start, end);
                temp = temp.toString().isEmpty() ? temp : temp.append(suffixMap.get(section));
                word = temp.toString().isEmpty() ? word : temp.append(word);
                section++;
                remainingDigits = remainingDigits - (end - start + 1);
                if (remainingDigits >= 3) {
                    end = start - 1;
                    start = start - 3;
                } else if (remainingDigits == 2) {
                    end = start - 1;
                    start = start - 2;
                } else if (remainingDigits == 1) {
                    end = start - 1;
                    start = start - 1;
                } else
                    break;
            }
            return word.toString().trim();
        }
    }

    private StringBuilder convertUtil(int arr[], int start, int end) {
        StringBuilder str = new StringBuilder("");
        if (start >= 0 && end < arr.length) {
            if (start == end)
                str = new StringBuilder(onesMap.get(arr[start]));
            else if (end - start == 2) {
                StringBuilder temp = convertUtil(arr, start + 1, end);
                if (arr[start] == 0) {
                    str = temp;
                } else {
                    str = new StringBuilder(onesMap.get(arr[start]) + "Hundred ").append(temp);
                }
            } else if (end - start == 1) {
                if (arr[start] == 0) {
                    str = new StringBuilder(onesMap.get(arr[end]));
                } else {
                    int num = arr[start] * 10 + arr[end];
                    if (tensMap.containsKey(num)) {
                        str = new StringBuilder(tensMap.get(num));
                    } else {
                        str = new StringBuilder(tensMap.get(arr[start] * 10) + onesMap.get(arr[end]));
                    }
                }
            }
        }
        return str;
    }
}