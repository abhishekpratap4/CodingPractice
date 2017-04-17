package com.company;

/**
 * Created by pratap on 11/19/16.
 */
public class RecursiveListReversal {

    static Node head;

    public static void main(String[] args) {

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node t = head;
        while (t != null) {
            System.out.print(t.value + "\t");
            t = t.next;
        }
        Node newHead = recursiveReversal(head, null);
        Node temp = newHead;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        }
    }

    private static Node recursiveReversal(Node curr, Node prev) {
        if (curr.next == null) {
            head = curr;

			/* Update next to prev node */
            curr.next = prev;
            return head;
        }

        recursiveReversal(curr.next, curr);
        curr.next = prev;
        return head;
    }
}
