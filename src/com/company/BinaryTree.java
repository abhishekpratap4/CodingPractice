package com.company;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by pratap on 10/14/16.
 */
class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class BinaryTree {
    TreeNode root;
    int size;
    static int maxSubtreeHeight;
    static TreeNode maxSubtreeParent;

    BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public void createBinaryTree() {
        this.root = new TreeNode(1);
        this.root.left = new TreeNode(2);
        this.root.right = new TreeNode(3);
        this.root.left.left = new TreeNode(4);
        this.root.left.right = new TreeNode(5);
        this.root.right.left = new TreeNode(6);
        this.root.right.right = new TreeNode(7);
        this.root.left.left.left = new TreeNode(8);
        this.root.left.left.right = new TreeNode(9);
        this.root.left.right.left = new TreeNode(10);
        this.root.left.right.right = new TreeNode(11);
        this.root.right.left.left = new TreeNode(12);
        this.root.right.left.right = new TreeNode(13);
        this.root.right.right.left = new TreeNode(14);
        this.root.right.right.right = new TreeNode(15);
    }

    public void preOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.value + "\t");
        size++;
        preOrder(node.left);
        preOrder(node.right);
    }

    public void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        while (node != null) {
            System.out.print(node.value + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            node = queue.poll();
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        } else if (root.left == null && root.right == null) {
            return 0;
        } else {
            int c1 = height(root.left);
            int c2 = height(root.right);
            if (c1 >= c2) {
                return c1 + 1;
            } else {
                return c2 + 1;
            }
        }
    }

    void top_view(TreeNode root) {
        if (root != null) {
            helper_left(root.left);
            System.out.print(root.value + " ");
            helper_right(root.right);
        }
    }

    void helper_left(TreeNode root) {
        if (root != null) {
            helper_left(root.left);
            System.out.print(root.value + " ");
        }
    }

    void helper_right(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            helper_right(root.right);
        }
    }

    boolean checkBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder_BST(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (!(list.get(i) < list.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    void inorder_BST(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            inorder_BST(root.left, list);
            list.add(root.value);
            inorder_BST(root.right, list);
        }
    }

    boolean checkBST2(TreeNode root) {
        TreeNode prev = null;
        return checkBSTUtil(root, prev);
    }

    boolean checkBSTUtil(TreeNode root, TreeNode prev) {
        if (root != null) {
            if (!checkBSTUtil(root.left, prev)) {
                return false;
            }

            if (prev != null && root.value <= prev.value)
                return false;

            prev = root;
            return checkBSTUtil(root.right, prev);
        }
        return true;
    }

    // LCA for BST
    static TreeNode lca(TreeNode root, int v1, int v2) {
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        BSTtraverse(root, v1, s1);
        BSTtraverse(root, v2, s2);
        //System.out.println(s1.size());
        //System.out.println(s2.size());

        if (s1.size() > s2.size()) {
            while (s1.size() != s2.size())
                s1.pop();
        } else if (s1.size() < s2.size()) {
            while (s1.size() != s2.size())
                s2.pop();
        }

        while (s1.peek().value != s2.peek().value) {
            s1.pop();
            s2.pop();
        }

        return s1.peek();

    }

    static void BSTtraverse(TreeNode root, int n, Stack s) {
        if (root != null) {
            if (root.value == n)
                return;
            else if (n < root.value) {
                s.add(root);
                BSTtraverse(root.left, n, s);
            } else if (n > root.value) {
                s.add(root);
                BSTtraverse(root.right, n, s);
            }
        }
    }


    // LCA Binary Tree
    static int BinaryTreeLCA(TreeNode root, int n1, int n2) {
        // Find path for n1
        ArrayList<Integer> path1 = new ArrayList<>();
        findPath(root, path1, n1);
        // Find path for n2
        ArrayList<Integer> path2 = new ArrayList<>();
        findPath(root, path2, n2);
        // Get common ancestor
        if (path1.size() > path2.size()) {
            while (path1.size() != path2.size()) {
                path1.remove(0);
            }
        } else if (path2.size() > path1.size()) {
            while (path2.size() != path1.size()) {
                path2.remove(0);
            }
        }

        for (int i = 0; i < path1.size(); i++) {
            if (path1.get(i).equals(path2.get(i))) {
                //System.out.println(path1.get(i));
                return path1.get(i);
            }
        }
        return -1;
    }

    static boolean findPath(TreeNode root, ArrayList<Integer> list, int n) {
        if (root == null)
            return false;
        else if (root.value == n) {
            list.add(root.value);
            return true;
        } else {
            if ((root.left != null && findPath(root.left, list, n)) || (root.right != null && findPath(root.right, list, n))) {
                list.add(root.value);
                return true;
            }
        }
        return false;
    }


    public TreeNode traverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = traverse(node.left);
        TreeNode parent = node;
        TreeNode right = traverse(node.right);
        if (left != null && right != null && left.value == right.value) {
            int m = compareSubtree(left, right);
            //System.out.println("Height is: " + m);
            if (m >= BinaryTree.maxSubtreeHeight) {
                BinaryTree.maxSubtreeHeight = m;
                BinaryTree.maxSubtreeParent = parent;
            }
        }
        return parent;
    }

    public int compareSubtree(TreeNode left, TreeNode right) {
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        inorder_BST(left, leftList);
        inorder_BST(right, rightList);
        boolean flag = false;
        if (leftList.size() == rightList.size()) {
            for (int i = 0; i < leftList.size(); i++) {
                if (leftList.get(i) == rightList.get(i)) {
                    continue;
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(leftList);
                int h = height(left);
                return h;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public int isBalanced(TreeNode root) {
        if (root == null || root.value == -1)
            return 1;
        int lh = height2(root.left);
        int rh = height2(root.right);
        //System.out.println(lh + ":" + rh);
        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) == 1 && isBalanced(root.right) == 1) {
            return 1;
        }
        return 0;
    }

    public static int height2(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(height2(root.left), height2(root.right));
    }

    public static TreeNode constructBSTFromSortedArray(final List<Integer> list) {
        if (list == null || list.size() == 0)
            return null;
        TreeNode root = new TreeNode(list.get(list.size() / 2));
        //System.out.println(root.value);
        List<Integer> leftList = list.subList(0, list.size() / 2);
        List<Integer> rightList = list.subList(list.size() / 2 + 1, list.size());
        root.left = constructBSTFromSortedArray(leftList);
        root.right = constructBSTFromSortedArray(rightList);
        return root;
    }

    public static TreeNode buildCartesianTree(ArrayList<Integer> list) {
        if (list == null || list.size() == 0)
            return null;
        int maxElePos = maxElementPos(list);
        TreeNode root = new TreeNode(list.get(maxElePos));
        //System.out.println(root.value);
        ArrayList<Integer> leftList = new ArrayList<>(list.subList(0, maxElePos));
        ArrayList<Integer> rightList = new ArrayList<>(list.subList(maxElePos + 1, list.size()));
        if (maxElePos == list.size() - 1) {
            root.left = buildCartesianTree(leftList);
        } else {
            root.left = buildCartesianTree(leftList);
            root.right = buildCartesianTree(rightList);
        }
        return root;
    }

    public static int maxElementPos(List<Integer> list) {
        int maxPos = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(maxPos)) {
                maxPos = i;
            }
        }
        return maxPos;
    }

    public static int KthSmallestEleBST(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        getInorderTraversal(root, list);
        if (list != null && list.size() >= k) {
            return list.get(k - 1);
        }
        return -1;
    }

    public static ArrayList<Integer> recoverTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> outputList = new ArrayList<>();
        getInorderTraversal(root, list);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i + 1 < list.size() && list.get(i) > list.get(i + 1)) {
                    if (outputList.size() == 0) {
                        outputList.add(list.get(i + 1));
                        outputList.add(list.get(i));
                    } else
                        outputList.add(list.get(i + 1));
                } else {
                    continue;
                }
            }
            if (outputList.size() == 3) {
                outputList.remove(0);
            }
        }
        Collections.sort(outputList);
        System.out.println(outputList);
        return outputList;
    }

    public static void getInorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            getInorderTraversal(root.left, list);
            list.add(root.value);
            getInorderTraversal(root.right, list);
        }
    }

    public static TreeNode flattenTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null) {
            if (temp.right != null)
                stack.push(temp.right);

            if (temp.left != null) {
                temp.right = temp.left;
                temp.left = null;
            } else if (!stack.empty()) {
                temp.right = stack.pop();
            }
            temp = temp.right;
        }
        return root;
    }

    public static TreeNode invert(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            invert(root.left);
            invert(root.right);
        }
        return root;
    }

    public static void specialTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return;
        System.out.print(root.value + "\t");

        if (root.left == null)
            return;

        System.out.print(root.left.value + "\t" + root.right.value + "\t");

        if (root.left.left == null)
            return;

        queue.add(root.left);
        queue.add(root.right);

        while (queue.size() > 0) {
            TreeNode first = queue.peek();
            queue.remove();
            TreeNode second = queue.peek();
            queue.remove();

            System.out.print(first.left.value + "\t" + second.right.value + "\t");
            System.out.print(first.right.value + "\t" + second.left.value + "\t");

            if (first.left.left != null) {
                queue.add(first.left);
                queue.add(second.right);
                queue.add(first.right);
                queue.add(second.left);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree();
        //tree.preOrder(tree.root);
        //tree.levelOrder(tree.root);
        //System.out.println("Size is : " + tree.size);
        //System.out.println("Height is : " + tree.height(tree.root));
        //tree.top_view(tree.root);
        //System.out.print(tree.checkBST(tree.root));
        //System.out.print(tree.checkBST2(tree.root));
        //TreeNode n = lca(tree.root, 1, 7);
        //System.out.print(n.eleValue);
        //tree.traverse(tree.root);
        //System.out.println("Root of subtree : " + maxSubtreeParent.eleValue);
        //System.out.println(BinaryTreeLCA(tree.root, 50, 50));
        //System.out.println(height2(tree.root));
        //Integer[] list = {1, 2, 3, 4, 7, 5, 6};
//        ArrayList<Integer> arrList = new ArrayList<>();
//        arrList.add(1);
//        arrList.add(2);
//        arrList.add(3);
//        arrList.add(4);
//        arrList.add(7);
//        arrList.add(5);
//        arrList.add(6);
        //TreeNode root = constructBSTFromSortedArray(Arrays.asList(list));
        //System.out.print(root.value);
        //TreeNode root = buildCartesianTree(arrList);
        //tree.levelOrder(root);
        //System.out.print(recoverTree(tree.root));
        //TreeNode r = tree.flattenTree(tree.root);
//        TreeNode r = tree.invert(tree.root);
//        tree.levelOrder(r);
        
        tree.specialTraversal(tree.root);
    }
}


