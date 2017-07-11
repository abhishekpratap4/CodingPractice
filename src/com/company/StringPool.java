package com.company;

/**
 * Created by pratap on 5/7/17.
 */

public class StringPool implements Cloneable {
    int val;

    public StringPool(int v) {
        val = v;
    }

    public static void main(String[] args) {
        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");

        System.out.println("s1 == s2 :" + (s1 == s2));
        System.out.println("s1 == s3 :" + (s1 == s3));

        s3 = s3.intern();
        System.out.println("s1 == s3 :" + (s1 == s3));

        System.out.println(Runtime.getRuntime().availableProcessors());

        StringPool p1 = new StringPool(10);
        try {
            StringPool p2 = (StringPool) p1.clone();
            System.out.print("Cloned value: " + p2.val);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
