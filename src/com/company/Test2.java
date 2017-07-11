package com.company;

/**
 * Created by pratap on 11/13/16.
 */


import java.util.Scanner;

class gfg {
    // This function should reverse linked list and return
    // head of the modified linked list.
    mNode reverse(mNode head) {
        mNode prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    int getNthFromLast(mNode head, int n) {
        // Your code here
        /*
        int count = 0;
        mNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }

        if(n > count)
            return -1;

        int nodeToFind = count - n + 1;
        temp = head;
        int c = 1;
        int val = -1;
        while(temp!=null){
            if(c == nodeToFind){
                val = temp.data;
                break;
            }
            c++;
            temp = temp.next;
        }
        return val;
        */
        mNode temp = head;
        mNode slow = head;
        int c = 1;
        if (head != null) {
            while (c <= n) {
                if(temp == null)
                    return -1;
                temp = temp.next;
                c++;
            }
            while (temp!=null){
                temp = temp.next;
                slow = slow.next;
            }
        }
        return slow.data;

    }
}

class mNode {
    int data;
    mNode next;

    mNode(int d) {
        data = d;
        next = null;
    }
}

public class Test2 {
    mNode head;  // head of lisl

    /* Linked list Node*/


    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(mNode node) {

        if (head == null) {
            head = node;
        } else {
            mNode temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    /* Function to print linked list */
    void printList() {
        mNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    /* Drier program to test above functions */
    public static void main(String args[]) {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String s = sc.nextLine();
        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s1 = sc.nextLine();
            Test2 llist = new Test2();
            //int n=Integer.parseInt(br.readLine());
            if (n > 0) {
                int a1 = sc.nextInt();
                mNode head = new mNode(a1);
                llist.addToTheLast(head);
            }
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new mNode(a));
            }


            //llist.head = new gfg().reverse(llist.head);
            System.out.println(new gfg().getNthFromLast(llist.head, k));
            llist.printList();

            t--;
        }
    }
}
