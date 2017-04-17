package com.company;

/**
 * Created by pratap on 10/17/16.
 */
public class SuffixArray {
    public static void main(String[] args) {
        String text = "banana";
        buildSuffixArray(text);
    }

    public static void buildSuffixArray(String text) {
        Suffix suffColl[] = new Suffix[text.length()];
        for (int i = 0; i < text.length(); i++) {
            Suffix s = new Suffix();
            s.index = i;
            s.suff = text.substring(i, text.length());
            suffColl[i] = s;
        }

        for(Suffix s : suffColl){
            System.out.println(s.suff);
        }
    }
}

class Suffix {
    int index;
    String suff;
}
