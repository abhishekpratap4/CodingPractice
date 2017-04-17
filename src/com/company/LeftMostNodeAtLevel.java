package com.company;

/**
 * Created by pratap on 11/26/16.
 */

class NewTreeNode {
    int value;
    int level;
    NewTreeNode left;
    NewTreeNode right;

    NewTreeNode(int v, int l) {
        value = v;
        left = right = null;
        level = l;
    }
}

public class LeftMostNodeAtLevel {

    public static void main(String[] args) {
        NewTreeNode root = new NewTreeNode(2, 1);
        root.left = new NewTreeNode(4, 2);
        root.right = new NewTreeNode(5, 2);
        root.left.left = new NewTreeNode(11, 3);
        root.left.right = new NewTreeNode(8, 3);
        root.right.right = new NewTreeNode(10, 3);
        //root.left.right.right = new NewTreeNode(7, 4);
        root.right.right.left = new NewTreeNode(3, 4);
        root.right.right.right = new NewTreeNode(6, 4);

        NewTreeNode n = getLeftMostNodeAtLevel(root, 4);
        System.out.println(n.value + " - " + n.level);
    }

    private static NewTreeNode getLeftMostNodeAtLevel(NewTreeNode root, int i) {
        if (root != null && root.level <= i) {
            if (root.level == i) {
                return root;
            } else {
                NewTreeNode l = getLeftMostNodeAtLevel(root.left, i);
                if(l == null) {
                    NewTreeNode r = getLeftMostNodeAtLevel(root.right, i);
                    return r;
                } else {
                    return l;
                }

                //return (l != null ? l : r);
            }
        } else {
            return null;
        }
    }
}
