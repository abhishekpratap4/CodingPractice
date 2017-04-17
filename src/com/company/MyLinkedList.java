package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by pratap on 10/11/16.
 */
public class MyLinkedList {

    Node head;
    static boolean setHead = false;
    static Node tempHead;

    public void createLinkedList() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int i = 1;
        while (i <= size) {
            // add new node at start
            Node node = new Node(scanner.nextInt());
            node.next = head;
            head = node;
            i++;
        }
    }

    public void displayLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        }
    }

    public void printNthNode(int n) {
        if (head == null)
            System.out.print("Empty list");
        else {
            Node temp = head;
            int i = 1;
            while (temp != null) {
                if (i == n) {
                    System.out.print("Node is: " + temp.value);
                    return;
                }
                temp = temp.next;
                i++;
            }
        }
    }

    public int addOne(Node node, int carry) {
        int sum;
        if (node.next != null) {
            sum = (node.value + addOne(node.next, 0));
        } else {
            sum = node.value + 1;
        }
        node.value = sum % 10;
        return (sum / 10);
    }

    public void reverseAltKNodes(Node node, int k) {
        Node temp = node;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int it = length / k;
        Node tempNode = node;
        int count = 1; Node prev = null;
        while (count <= it) {
            tempNode = reverseKNodes(tempNode, prev, k);
            tempNode.next = tempHead;
            for (int i = 1; i <= k + 1 && tempNode != null; i++) {
                prev = tempNode;
                tempNode = tempNode.next;
            }
            count = count + 2;
            displayLinkedList();
            System.out.println();
        }
    }

    private Node reverseKNodes(Node curr, Node prev, int k) {
        if (curr.next == null || k == 1) {
            if (!setHead) {
                head = curr;
                tempHead = curr.next;
                curr.next = prev;
                setHead = true;
                return head;
            } else {
                tempHead = curr.next == null ? curr : curr.next;
                curr.next = prev;
                return curr;
            }
        }

        reverseKNodes(curr.next, curr, --k);
        curr.next = prev;
        return curr;

    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}