package com.company;

/**
 * Created by pratap on 3/3/17.
 */

//  class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//  }
//
//
//  class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root;
        if (head == null)
            root = null;
        else if (head.next == null)
            root = new TreeNode(head.val);
        else
            root = createTree(null, head, null, null);
        return root;
    }

    public TreeNode createTree(TreeNode root, ListNode head, ListNode end, ListNode prevMid) {
        if (head != null && head != end) {
            ListNode mid = findMidNode(head, end);
            if (mid == prevMid)
                return null;
            TreeNode node = new TreeNode(mid.val);
            if (root == null) {
                root = node;
            }
            root.left = createTree(node, head, mid, mid);
            root.right = createTree(node, mid.next, end, mid);
            return root;
        }
        return null;
    }

    public ListNode findMidNode(ListNode head, ListNode end) {
        ListNode t1 = head;
        ListNode t2 = head;

        while (t1 != end && t2 != end) {
            t1 = t1.next;
            if (t2.next != null)
                t2 = t2.next.next;
        }
        return t1;
    }

    public static void main(String[] args) {
        SortedListToBST operation = new SortedListToBST();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        //head.next.next = new ListNode(3);
        TreeNode root = operation.sortedListToBST(head);
        System.out.print(root.value);
    }
}