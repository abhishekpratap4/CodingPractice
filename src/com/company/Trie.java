package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pratap on 1/18/17.
 */
class TrieNode {
    TrieNode[] arr;
    boolean isEnd;
    char ch;
    int frequency; //added for count number of times node is visited during insert operation. Not required for basic Trie.

    // Initialize your data structure here.
    public TrieNode() {
        this.arr = new TrieNode[26];
        this.frequency = 1;
    }

}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        String str[] = {"zebra", "dog", "duck", "dove"};

        for (int i = 0; i < str.length; i++) {
            t.insert(str[i]);
        }

//        System.out.println(t.search("the") == true ? "Present" : "Absent");
//        System.out.println(t.search("these") == true ? "Present" : "Absent");
//        System.out.println(t.search("their") == true ? "Present" : "Absent");
//        System.out.println(t.search("thaw") == true ? "Present" : "Absent");

        t.shortestUniquePrefix(str);
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.arr[index] == null) {
                TrieNode temp = new TrieNode();
                temp.ch = c;
                p.arr[index] = temp;
                p = temp;
            } else {
                p = p.arr[index];
                p.frequency++;
            }
        }
        p.isEnd = true;
    }

    public void shortestUniquePrefix(String[] str) {
        for (int i = 0; i < str.length; i++) {
            System.out.println(searchNodeForPrefix(str[i]));
        }
    }

    public String searchNodeForPrefix(String s) {
        TrieNode p = root;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (p.arr[index] != null) {
                if (p != root && p.frequency == 1) {
                    break;
                } else {
                    p = p.arr[index];
                    str = str.append(c);
                }
            }
        }
        return str.toString();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if (p == null) {
            return false;
        } else {
            if (p.isEnd)
                return true;
        }

        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if (p == null) {
            return false;
        } else {
            return true;
        }
    }

    public TrieNode searchNode(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (p.arr[index] != null) {
                p = p.arr[index];
            } else {
                return null;
            }
        }

        if (p == root)
            return null;

        return p;
    }
}
