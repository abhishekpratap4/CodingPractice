package com.company;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //PowerProblem.checkIfYCanBeExpressedInPowerOfX();
        //LargestSum.findSum();
        //MajorityElement.getMajorityElement();
        //RangeGenerator.getRange();
        //Median.getMedian();
        MyLinkedList list = new MyLinkedList();
        list.createLinkedList();
        list.displayLinkedList();
        System.out.println();
        list.reverseAltKNodes(list.head,3);
        //list.addOne(list.head, 0);
        //list.displayLinkedList();
        //list.printNthNode(4);
        //MyString.removeChars();
        //MyHeap.createMinMaxHeap();
        //MyHeap.createMinHeap();
        //MyString.checkIfStringContainsChars();
        //MyString.checkIfStringContainsCharsUpdated();
        //MyString.getEncoding();
        //MyString.countWords();
        //HeapSort.sort();

    }
}
