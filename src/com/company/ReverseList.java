package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratap on 1/3/17.
 */

//Definition for singly-linked list.
class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseList {

    public static void main(String[] arsg) {
        ReverseList r = new ReverseList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);
        //head.next.next.next.next.next.next = new ListNode(7);

        //System.out.println(r.reverse(head).val);
        //System.out.println(r.reverseV2(head, 1, 3).val);
        TreeNode t = sortedListToBST(head);
        System.out.print(t.value);
    }

    public int lPalin(ListNode A) {
        if (A == null)
            return 0;

        ListNode slow = A, fast = A, mid = null, prev = null, second_half = null;
        while (slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (fast != null) {
            //odd
            mid = slow;
            slow = slow.next;
        }
        if (prev != null)
            prev.next = null;
        second_half = slow;
        second_half = reverse(second_half);

        int res = compareList(A, second_half);
        if (mid != null) {
            if (prev != null)
                prev.next = mid;
            mid.next = second_half;
        } else {
            prev.next = second_half;
        }
        return res;
    }

    public ListNode reverse(ListNode A) {
        ListNode prev = null, curr = A, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        A = prev;
        return A;
    }

    public ListNode reverseV2(ListNode A, int m, int n) {
        if (A == null)
            return null;
        int c = 1;
        ListNode prev = null, curr = A, next = null, start = null;

        while (c < m) {
            prev = curr;
            curr = curr.next;
            c++;
        }

        while (c <= n) {
            next = curr.next;
            curr.next = start;
            start = curr;
            curr = next;
            c++;
        }

        ListNode temp;

        if (prev != null) {
            prev.next = start;
            temp = prev;
        } else {
            A = start;
            temp = A;
        }

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = next;

        return A;
    }

    public int compareList(ListNode A, ListNode B) {
        ListNode temp1 = A, temp2 = B;
        while (temp1 != null && temp2 != null) {
            if (temp1.val != temp2.val)
                return 0;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if (temp1 == null && temp2 == null)
            return 1;

        if (A != null && A.next == null && B == null)
            return 1;

        return 0;
    }

    public static TreeNode sortedListToBST(ListNode a) {
        if (a == null)
            return null;

        ListNode temp = a;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] arr = new int[size];
        temp = a;
        int i = 0;
        while (temp != null) {
            arr[i] = temp.val;
            temp = temp.next;
            i++;
        }
        return sortedListToBST(arr, 0, arr.length);
    }

    public static TreeNode sortedListToBST(int[] a, int start, int end) {
        if (start > end)
            return null;
        int midIndex = (start + end) / 2;
        if (midIndex >= a.length)
            return null;
        TreeNode root = new TreeNode(a[midIndex]);
        root.left = sortedListToBST(a, start, midIndex - 1);
        root.right = sortedListToBST(a, midIndex + 1, end);
        return root;
    }
}
