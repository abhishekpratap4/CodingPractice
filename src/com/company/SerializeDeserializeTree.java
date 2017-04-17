package com.company;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by pratap on 2/23/17.
 */


class BinTreeNode {
    int val;
    BinTreeNode left;
    BinTreeNode right;

    BinTreeNode(int x) {
        val = x;
    }
}

public class SerializeDeserializeTree {

    // Encodes a tree to a single string.
    public String serialize(BinTreeNode root) {
        if (root == null)
            return "";
        String s = levelOrder(root);
        //System.out.println(s.substring(0,s.length()-1));
        return s.substring(0, s.length() - 1);
    }

    public String levelOrder(BinTreeNode root) {
        Queue<BinTreeNode> queue = new LinkedList<>();
        queue.add(root);
        String s = "";
        while (queue.size() > 0) {
            BinTreeNode temp = queue.poll();
            if (temp != null) {
                s = s + temp.val + ",";
                queue.add(temp.left);
                queue.add(temp.right);
            } else {
                s = s + "null,";
            }
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public BinTreeNode deserialize(String data) {
        if (data.length() <= 0)
            return null;
        String[] split = data.split(",");
        BinTreeNode root = null;
        root = insert(root, split, 0, split.length - 1);
        return root;
    }

    public BinTreeNode insert(BinTreeNode root, String[] split, int start, int end) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;

        if (left > end || right > end)
            return null;

        if (root == null)
            root = split[start].equals("null") ? null : new BinTreeNode(Integer.parseInt(split[start]));

        if (root != null && root.left == null && root.right == null) {
            if (left < end)
                root.left = split[left].equals("null") ? null : new BinTreeNode(Integer.parseInt(split[left]));
            if (right < end)
                root.right = split[right].equals("null") ? null : new BinTreeNode(Integer.parseInt(split[right]));
        }
        if (root != null) {
            insert(root.left, split, left, end);
            insert(root.right, split, right, end);
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeDeserializeTree tree = new SerializeDeserializeTree();
        BinTreeNode root = tree.deserialize("5,2,3,null,null,2,4,3,1");
        System.out.print(root);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));