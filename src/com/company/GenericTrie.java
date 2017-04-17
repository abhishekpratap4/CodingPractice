package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pratap on 1/19/17.
 */
class GenericTrieNode {
    char c;
    HashMap<Character, GenericTrieNode> children = new HashMap<>();
    boolean isLeaf;

    public GenericTrieNode() {
    }

    public GenericTrieNode(char c) {
        this.c = c;
    }
}

public class GenericTrie {
    private GenericTrieNode root;

    public GenericTrie() {
        root = new GenericTrieNode();
    }


    public static void main(String[] args) {
        GenericTrie t = new GenericTrie();
        String str[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};

        for (int i = 0; i < str.length; i++) {
            t.insert(str[i]);
        }

        System.out.println(t.search("the") == true ? "Present" : "Absent");
        System.out.println(t.search("these") == true ? "Present" : "Absent");
        System.out.println(t.search("their") == true ? "Present" : "Absent");
        System.out.println(t.search("thaw") == true ? "Present" : "Absent");
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, GenericTrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            GenericTrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new GenericTrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            //set leaf node
            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        GenericTrieNode t = searchNode(word);

        if (t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public GenericTrieNode searchNode(String str) {
        Map<Character, GenericTrieNode> children = root.children;
        GenericTrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }
}
