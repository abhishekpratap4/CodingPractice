package com.company;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by pratap on 11/9/16.
 * BST inorder successor
 * BST kth smallest element
 */
public class BST {
    TreeNode root;
    TreeNode prev;
    int size;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    BST() {
        this.root = null;
        this.prev = null;
        this.size = 0;
    }

    public void createBinaryTree() {
        this.root = new TreeNode(4);
        this.root.left = new TreeNode(2);
        this.root.right = new TreeNode(5);
        this.root.left.left = new TreeNode(1);
        this.root.left.right = new TreeNode(3);
        //this.root.right.right = new TreeNode(6);
    }

    public boolean isBST(TreeNode root) {
        if (root != null) {
            if (!isBST(root.left))
                return false;
            System.out.print(root.value + "\t");
            if (prev != null && root.value < prev.value)
                return false;
            prev = root;
            return isBST(root.right);
        }
        return true;
    }

    public void inorderSuccessor(TreeNode root, TreeNode node) {
        if (root == null)
            return;
        else {
            TreeNode succ = null;
            if (node.right != null) {
                succ = minNode(node.right);
            } else {
                while (root != null) {
                    if (node.value < root.value) {
                        succ = root;
                        root = root.left;
                    } else if (node.value > root.value) {
                        root = root.right;
                    } else
                        break;
                }
            }
            System.out.println(succ == null ? "NULL" : succ.value);
        }

    }

    private TreeNode minNode(TreeNode right) {
        TreeNode min = right;
        while (right.left != null) {
            right = right.left;
        }
        return min;
    }

    public void kthSmallestElement(TreeNode root, int k) {
        //TODO
    }

    public String serializeBST(TreeNode root, String s) {
        if (root != null) {
            s = (root.value + "," + serializeBST(root.left, s) + serializeBST(root.right, s));
        }
        return s;
    }

    public TreeNode deserializeBST(String data) {
        String[] split = data.split(",");
        TreeNode root = null;
        if (split.length > 0) {
            root = new TreeNode(Integer.parseInt(split[0]));
        }
        for (int i = 1; i < split.length; i++) {
            int val = Integer.parseInt(split[i]);
            insertInBST(root, val);
        }
        return root;
    }

    private TreeNode insertInBST(TreeNode root, int val) {
        if (root == null)
            root = new TreeNode(val);
        else if (root.value < val)
            root.right = insertInBST(root.right, val);
        else
            root.left = insertInBST(root.left, val);

        return root;

    }

    public String levelOrder(TreeNode root){
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        String s = "";
        while(queue.size()>0){
            TreeNode temp = queue.poll();
            if(temp != null){
                s = s + temp.value + ",";
                queue.add(temp.left);
                queue.add(temp.right);
            } else {
                s = s + "null,";
            }
        }
        return s;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.createBinaryTree();
        //System.out.println(tree.kthSmallest(tree.root,3));
        //System.out.println(tree.isBST(tree.root));
        //tree.inorderSuccessor(tree.root, new TreeNode(1));
        //tree.kthSmallestElement(tree.root, 3);
//        String s = tree.serializeBST(tree.root, "");
//        System.out.println(s);
//        TreeNode r = tree.deserializeBST(s);
//        System.out.println(tree.serializeBST(r, ""));
        System.out.println(tree.levelOrder(tree.root));
    }
}
