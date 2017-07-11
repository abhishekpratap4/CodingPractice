package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by pratap on 11/30/16.
 */
public class PascalTriangle {
    public static void main(String[] args) {
        //ArrayList<Integer> list = generate(4);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        largestNumber(list);

    }

    public static void largestNumber(List<Integer> list) {
        String strArr[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = list.get(i).toString();
        }

        System.out.println(Arrays.toString(strArr));

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });

        System.out.println(Arrays.toString(strArr));
//        System.out.println(list);
//        list.sort((o1, o2) -> compareString(o1, o2));
//        System.out.println(list);
        String result = "";
        boolean flag = false;
        for (int i = 0; i < strArr.length; i++) {
            result = result + strArr[i];
            if (!strArr[i].equals("0")) {
                flag = true;
            }
        }


//
//        int pos = 0;
//        for(int i =0;i<result.length();i++){
//            if(result.charAt(i)!='0') {
//                flag = true;
//                pos = i;
//                break;
//            }
//        }
//        if(flag && pos !=0){
//            result = result.substring(pos,result.length());
//        }
        if (!flag)
            result = "0";
        System.out.println(result);
    }

    public static int compareString(int x, int y) {
        String xS = Integer.toString(x);
        String yS = Integer.toString(y);

        String xSS = xS + yS;
        String ySS = yS + xS;
        System.out.println(xSS + " -- " + ySS + " -- " + xSS.compareTo(ySS));
        return xSS.compareTo(ySS);
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        if (a == null || a.size() == 0)
            return null;
        boolean flag = false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) >= 0) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return new ArrayList<Integer>();
        int maxSoFar = 0;
        int maxTillNow = 0;
        int start = 0, end = 0;
        int sIndex = 0, eIndex = 0, nEle = 0;
        boolean update = true;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) >= 0) {
                maxTillNow = maxTillNow + a.get(i);
                if (update) {
                    start = i;
                    update = false;
                }
                end = i;
            } else {
                if (maxSoFar < maxTillNow) {
                    maxSoFar = maxTillNow;
                    sIndex = start;
                    eIndex = end;
                } else if (maxSoFar == maxTillNow) {
                    if (end - start + 1 > eIndex - sIndex + 1) {
                        eIndex = end;
                        sIndex = start;
                    }
                }
                update = true;
                maxTillNow = 0;
            }
        }
        if (!update) {
            if (maxSoFar < maxTillNow) {
                maxSoFar = maxTillNow;
                sIndex = start;
                eIndex = end;
            } else if (maxSoFar == maxTillNow) {
                if (end - start + 1 > eIndex - sIndex + 1) {
                    eIndex = end;
                    sIndex = start;
                }
            }
            update = true;
            maxTillNow = 0;
        }
        System.out.println(sIndex + "-" + eIndex);
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(a.subList(sIndex, eIndex + 1));
        return list;
    }

    public static ArrayList<Integer> generate(int a) {
        ArrayList<ArrayList<Integer>> listOfList = new ArrayList<>();
        for (int i = 0; i <= a; i++) {
            ArrayList<Integer> list = new ArrayList<>(i + 1);
            list.add(0, 1);
            if (i >= 1)
                list.add(list.size() - 1, 1);
            if (i >= 2) {
                ArrayList<Integer> prevList = listOfList.get(i - 1);
                for (int j = 0; j < prevList.size() - 1; j++) {
                    list.add(j + 1, prevList.get(j) + prevList.get(j + 1));
                }
            }
            listOfList.add(list);
        }
        return listOfList.get(a);
    }
}
