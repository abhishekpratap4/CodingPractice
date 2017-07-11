package com.company;

/**
 * Created by pratap on 5/18/17.
 */
public class IntersectionPoint {

    public static void main(String[] args) {
        IntersectionPoint i = new IntersectionPoint();
        Node headA = new Node(3);
        headA.next = new Node(6);
        headA.next.next = new Node(9);
        headA.next.next.next = new Node(15);
        headA.next.next.next.next = new Node(30);

        Node headB = new Node(10);
        headB.next = headA.next.next.next;

        System.out.print(i.intersectPoint(headA, headB));
    }

    int intersectPoint(Node headA, Node headB) {
        if (headA == null || headB == null)
            return -1;
        // code here
        int listALength = 0, listBLength = 0;
        Node tempA = headA, tempB = headB;
        while (tempA != null) {
            listALength++;
            tempA = tempA.next;
        }
        tempA = headA;
        while (tempB != null) {
            listBLength++;
            tempB = tempB.next;
        }
        tempB = headB;
        if (listALength > listBLength) {
            int diff = listALength - listBLength;
            while (diff > 0) {
                tempA = tempA.next;
                diff--;
            }
        } else {
            int diff = listBLength - listALength;
            while (diff > 0) {
                tempB = tempB.next;
                diff--;
            }
        }
        while (tempA != null && tempB != null && tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        if (tempA != null && tempB != null && tempA == tempB)
            return tempA.value;
        else
            return -1;
    }
}
