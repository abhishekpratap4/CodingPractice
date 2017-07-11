package com.company;

/**
 * Created by pratap on 4/9/17.
 */
public class LinkedListQ {

    public static void main(String[] rags) {
        LinkedListQ q = new LinkedListQ();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode newHead = q.reverseList(head);
        System.out.print(newHead.val);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode headNode = head;
        reverseUtil(head, prev, headNode);
        return headNode;
    }

    private void reverseUtil(ListNode head, ListNode prev, ListNode headNode) {
        if (head != null) {
//            headNode = prev;
//            return headNode;
//        } else {
            prev = head;
            head = head.next;
            if (head != null)
                reverseUtil(head.next, head, headNode);
            head.next = prev;
        }
    }
}

