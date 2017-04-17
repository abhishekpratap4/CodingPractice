package com.company;

import java.util.ArrayList;

/**
 * Created by pratap on 12/11/16.
 */
public class StringProblems {
    public static void main(String[] args) {
        //System.out.println(lengthOfLastWord("     d    "));
//        String jsonString = "{\"A\":\"B\",\"C\":{\"D\":\"E\",\"F\":{\"G\":\"H\",\"I\":\"J\"}}}";
//        ArrayList<String> list = prettyJSON(jsonString);
//        for (String i : list) {
//            System.out.println(i);
//        }
        System.out.print(compareVersionNumbers("1.12", "1.16"));
    }

    public static int lengthOfLastWord(String s) {
        ArrayList<String> arr = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (!temp.equals(""))
                    arr.add(temp);
                temp = "";
            } else if (i == s.length() - 1) {
                temp = temp + s.charAt(i);
                if (!temp.equals(""))
                    arr.add(temp);
                temp = "";
            } else {
                temp = temp + s.charAt(i);
            }
        }
        System.out.println(arr);
        if (arr.size() == 0)
            return 0;
        else
            return arr.get(arr.size() - 1).length();
    }

    public static ArrayList<String> prettyJSON(String json) {
        ArrayList<String> jsonList = new ArrayList<>();
        int tabSpaceCount = 0;
        int startIndex = 0;
        int endIndex = json.length();

        for (int i = 0; i < json.length(); i++) {
            if (json.charAt(i) == '{' || json.charAt(i) == '[') {
                String temp = "";
                for (int k = 0; k < tabSpaceCount; k++) {
                    temp = temp + "\t";
                }
                String t1 = temp + json.substring(startIndex, i);
                if (t1.trim().length() > 0)
                    jsonList.add(t1);
                temp = temp + json.charAt(i);
                jsonList.add(temp);
                tabSpaceCount++;
                startIndex = i + 1;
            } else if (json.charAt(i) == '}' || json.charAt(i) == ']') {
                String temp = "";
                for (int k = 0; k < tabSpaceCount; k++) {
                    temp = temp + "\t";
                }
                String t1 = temp + json.substring(startIndex, i);
                if (t1.trim().length() > 0)
                    jsonList.add(t1);
                tabSpaceCount--;
                if (i + 1 < json.length() && json.charAt(i + 1) == ',') {
                    startIndex = i + 1;
                    continue;
                }

                temp = "";
                for (int k = 0; k < tabSpaceCount; k++) {
                    temp = temp + "\t";
                }
                temp = temp + json.charAt(i);
                jsonList.add(temp);
                startIndex = i + 1;
            } else if (json.charAt(i) == ',') {
                String temp = "";
                if (i - 1 >= 0 && (json.charAt(i - 1) == '}' || json.charAt(i - 1) == ']')) {
                    for (int k = 0; k < tabSpaceCount; k++) {
                        temp = temp + "\t";
                    }
                    temp = temp + json.charAt(i - 1) + json.charAt(i);
                    jsonList.add(temp);
                    startIndex = i + 1;
                    continue;
                }
                endIndex = i;
                for (int k = 0; k < tabSpaceCount; k++) {
                    temp = temp + "\t";
                }
                String t1 = json.substring(startIndex, endIndex + 1);
                temp = temp + t1;
                jsonList.add(temp);
                startIndex = endIndex + 1;
            }
        }

        return jsonList;
    }

    public static int compareVersionNumbers(String v1, String v2) {

        String v1Arr[] = v1.split("\\.");
        String v2Arr[] = v2.split("\\.");

        for (int i = 0; i < v1Arr.length && i < v2Arr.length; i++) {
            if (v1Arr[i].replaceFirst("^0+(?!$)", "").equals(v2Arr[i].replaceFirst("^0+(?!$)", "")))
                continue;
            else {
                int res = v1Arr[i].replaceFirst("^0+(?!$)", "").length() - v2Arr[i].replaceFirst("^0+(?!$)", "").length();
                if (res < 0)
                    return -1;
                else if (res > 0)
                    return 1;
            }
        }
        if (v1Arr.length == v2Arr.length)
            return 0;
        else if (v1Arr.length < v2Arr.length) {
            int index = v1Arr.length;
            while (index < v2Arr.length) {
                if (!v2Arr[index].replaceFirst("^0+(?!$)", "").equals("0")) {
                    return -1;
                }
                index++;
            }
            return 0;
        } else if (v1Arr.length > v2Arr.length) {
            int index = v2Arr.length;
            while (index < v1Arr.length) {
                if (!v1Arr[index].replaceFirst("^0+(?!$)", "").equals("0")) {
                    return -1;
                }
                index++;
            }
            return 0;
        }
        return 0;
    }
}
