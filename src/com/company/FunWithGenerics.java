package com.company;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by pratap on 1/2/17.
 */
public class FunWithGenerics {
    public static void main(String[] args) {
        /**
         * Not allowed: add method takes argument of type ?, which is unknown
         * so adding element is not allowed
         * Collection<?> c = new ArrayList<String>();
         * c.add("Test");
         */

        Collection<String> c = new ArrayList<>();
        c.add("test");
        Object[] a = {};
        fromArrayToCollection(a,c);

    }

    static void fromArrayToCollection(Object[] a, Collection<?> c) {
//        for (Object o : a) {
//            c.add(o); // compile-time error
//        }
    }

}
