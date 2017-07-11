package com.company;

/**
 * Created by pratap on 6/3/17.
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ReverseBetween r = new ReverseBetween();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode t = r.reverseBetween(head, 1, 5);
        System.out.println(t.val);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code
        if (head == null)
            return head;
        int count = 1;
        ListNode prev = null, curr = head, next;
        while (count < m) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        ListNode tPrev = prev;
        ListNode tCurr = curr;
        while (count <= n && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (tCurr != null)
            tCurr.next = curr;

        if (tPrev == null)
            head = prev;
        else {
            ListNode tHead = head;
            int c = 1;
            while (c < m - 1 && tHead != null) {
                tHead = tHead.next;
                c++;
            }
            tHead.next = prev;
            return head;
        }

        return head;
    }
}
