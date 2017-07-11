package com.company;

import java.util.HashMap;

/**
 * Created by pratap on 5/19/17.
 */
public class LRUCache {

    class CacheNode {
        int key, value;

        CacheNode(int k, int v) {
            key = k;
            value = v;
        }

        public String toString() {
            return this.key + " : " + this.value;
        }
    }

    java.util.LinkedList<CacheNode> list;
    HashMap<Integer, CacheNode> map;
    int capacity;

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        System.out.println(cache.get(73));
        cache.set(74, 38);
        System.out.println(cache.get(80));
        cache.set(10, 62);
        cache.set(11, 58);
        cache.set(67, 47);
        System.out.println(cache.get(79));
        System.out.println(cache.get(42));
        System.out.println(cache.get(26));
        cache.set(4, 70);
        cache.set(26, 25);
        cache.set(85, 8);
        cache.set(70, 32);
        cache.set(90, 5);
        System.out.println(cache.get(66));
        cache.set(8, 52);
        System.out.println(cache.get(63));
        System.out.println(cache.get(7));
        System.out.println(cache.get(61));
        cache.set(55, 69);
        cache.set(12, 46);
        cache.set(70, 1);
        cache.set(27, 27);
        System.out.println(cache.get(63));
        cache.set(32, 36);
        System.out.println(cache.get(41));
        System.out.println(cache.get(50));
        cache.set(1, 24);
        System.out.println(cache.get(33));
        System.out.println(cache.get(96));
        System.out.println(cache.get(43));
        cache.set(63, 76);
        cache.set(61, 80);
        cache.set(61, 1);
        System.out.println(cache.get(98));
        System.out.println(cache.get(25));
        System.out.println(cache.get(1));
//        cache.set(32, 90);
//        System.out.println(cache.get(82));
//        System.out.println(cache.get(80));
//        cache.set(80, 28);
//        cache.set(95, 12);
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(15));
//        cache.set(80, 4);
//        System.out.println(cache.get(64));
//        System.out.println(cache.get(61));
//        cache.set(11, 55);
//        System.out.println(cache.get(79));
//        System.out.println(cache.get(15));
//        System.out.println(cache.get(54));
//        System.out.println(cache.get(81));
//        cache.set(60, 55);
//        System.out.println(cache.get(34));
//        System.out.println(cache.get(38));
//        cache.set(45, 85);
//        cache.set(59, 74);
//        System.out.println(cache.get(29));
//        cache.set(92, 90);
    }

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        //Your code here
        list = new java.util.LinkedList<>();
        map = new HashMap<>(N);
        capacity = N;
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        //Your code here
        int res;
        if (map.containsKey(x)) {
            CacheNode n = map.get(x);
            res = n.value;
            list.remove(n);
            map.remove(x);
            list.add(n);
            map.put(x, n);
        } else {
            res = -1;
        }
        return res;
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        //Your code here
        CacheNode n;
        if (map.containsKey(x)) {
            n = map.get(x);
            list.remove(n);
            map.remove(x);
        } else {
            if (list.size() == capacity) {
                map.remove(list.get(0).key);
                list.remove(0);
            }
        }
        n = new CacheNode(x, y);
        list.add(n);
        map.put(x, n);
        System.out.println(list);
        //System.out.println(map);
    }
}