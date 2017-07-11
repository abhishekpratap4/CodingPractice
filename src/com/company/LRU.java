package com.company;

import java.util.HashMap;

/**
 * Created by pratap on 2/3/17.
 */
public class LRU {
    int maxCapacity;
    HashMap<Integer, Node1> cacheMap;
    Node1 cache;
    Node1 front, end;

    public static void main(String[] args) {
        LRU lru = new LRU(7);
        lru.set(2, 1);
        lru.set(1, 10);
        lru.set(8, 13);
        System.out.println(lru.get(12));
        lru.set(2, 8);
        System.out.println(lru.get(11));
        System.out.println(lru.get(7));
        lru.set(14, 7);
        lru.set(12, 9);
        lru.set(7, 10);
        System.out.println(lru.get(11));
        lru.set(9, 3);
        lru.set(14, 15);
        System.out.println(lru.get(15));
        System.out.println(lru.get(9));
        lru.set(4, 13);
        System.out.println(lru.get(3));
        lru.set(13, 7);
        System.out.println(lru.get(2));
        lru.set(5, 9);
        System.out.println(lru.get(6));
        System.out.println(lru.get(13));
        lru.set(4, 5);
        lru.set(3, 2);
        lru.set(4, 12);
        System.out.println(lru.get(13));
        System.out.println(lru.get(7));
        lru.set(9, 7);
        System.out.println(lru.get(3));
        System.out.println(lru.get(6));
        System.out.println(lru.get(2));
        lru.set(8, 4);
        lru.set(8, 9);
        lru.set(1, 4);
        lru.set(2, 9);
        lru.set(8, 8);
        System.out.println(lru.get(13));
        System.out.println(lru.get(3));
        System.out.println(lru.get(13));
        System.out.println(lru.get(6));
        lru.set(3, 8);
        System.out.println(lru.get(14));
        System.out.println(lru.get(4));
        lru.set(5, 6);
        lru.set(10, 15);
        System.out.println(lru.get(12));
        lru.set(13, 5);
        lru.set(10, 9);
        lru.set(3, 12);
        lru.set(14, 15);
        System.out.println(lru.get(4));
        lru.set(10, 5);
        System.out.println(lru.get(5));
        System.out.println(lru.get(15));
        lru.set(7, 6);
        System.out.println(lru.get(1));
        lru.set(5, 12);
        lru.set(1, 6);
        lru.set(11, 8);

    }

    public LRU(int capacity) {
        maxCapacity = capacity;
        cacheMap = new HashMap<>();
        cache = null;
        front = end = null;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            Node1 temp = cacheMap.get(key);
            if (temp.prev == null) {
                return temp.val;
            } else if (temp.next == null) {
                Node1 t = temp.prev;
                t.next = null;
                end = t;
                temp.next = cache;
                cache.prev = temp;
                cache = temp;
                cache.prev = null;
                front = cache;
                return temp.val;
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp.next = cache;
                cache.prev = temp;
                cache = temp;
                cache.prev = null;
                front = cache;
                return temp.val;
            }
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node1 n = cacheMap.get(key);
            n.val = value;
            get(key);
        } else if (cacheMap.size() == 0) {
            Node1 temp = new Node1(key, value);
            cache = temp;
            front = end = cache;
            cacheMap.put(key, temp);
        } else if (cacheMap.size() == maxCapacity) {
            Node1 newNode = new Node1(key, value);
            Node1 temp = end;
            if (cacheMap.size() == 1) {
                cacheMap.remove(temp.key);
                cache = null;
                cache = newNode;
                front = end = cache;
            } else {
                end = end.prev;
                end.next = null;
                cacheMap.remove(temp.key);
                temp = null;
                newNode.next = cache;
                cache.prev = newNode;
                cache = newNode;
                cache.prev = null;
                front = cache;
            }
            cacheMap.put(key, newNode);
        } else {
            Node1 temp = new Node1(key, value);
            temp.next = cache;
            cache.prev = temp;
            cache = temp;
            cache.prev = null;
            front = cache;
            cacheMap.put(key, temp);
        }
    }
}

class Node1 {
    int key, val;
    Node1 next;
    Node1 prev;

    Node1(int k, int value) {
        key = k;
        val = value;
        next = prev = null;
    }
}
