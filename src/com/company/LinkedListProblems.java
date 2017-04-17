package com.company;

public class LinkedListProblems {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);
        ListNode output = insertionSortList(head);
        System.out.println(output.val);
    }

    public static ListNode swapPairs(ListNode a) {
        if (a == null || a.next == null)
            return a;

        ListNode temp = null, prev = a, curr = a.next, next = a.next.next, head = a.next;
        while (curr != null) {
            curr.next = prev;
            prev.next = next;
            if (temp != null) {
                temp.next = curr;
            }
            temp = prev;
            prev = next;
            if (next != null) {
                curr = next.next;
                if (curr != null) {
                    next = curr.next;
                } else {
                    next = null;
                }
            } else {
                curr = null;
            }
        }
        return head;
    }

    public static ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode n1 = a, n2 = b;
        ListNode output = null, head = output;
        int sum = 0, carry = 0;
        while (n1 != null && n2 != null) {
            sum = n1.val + n2.val + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            if (output == null) {
                output = node;
                //head = output;
            } else {
                output.next = node;
                output = node;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        if (n1 == null && n2 != null) {
            while (n2 != null) {
                sum = n2.val + carry;
                if (sum >= 10) {
                    sum = sum % 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                ListNode node = new ListNode(sum);
                if (output == null) {
                    output = node;
                    //head = output;
                } else {
                    output.next = node;
                    output = node;
                }
                n2 = n2.next;
            }
        } else {
            while (n1 != null) {
                sum = n1.val + carry;
                if (sum >= 10) {
                    sum = sum % 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                ListNode node = new ListNode(sum);
                if (output == null) {
                    output = node;
                    head = output;
                } else {
                    output.next = node;
                    output = node;
                }
                n1 = n1.next;
            }
        }
        if (carry == 1) {
            ListNode node = new ListNode(carry);
            output.next = node;
        }
        return head;
    }

    public static ListNode partition(ListNode a, int b) {
        if (a == null || a.next == null)
            return a;

        ListNode curr = a, prev = null, temp = null, next = null, x = null;
        while (curr != null) {
            if (curr.val < b && temp == null) {
                prev = curr;
                curr = curr.next;
            } else if (curr.val < b && temp != null) {
                temp.next = curr;
                curr.next = x;
                prev.next = next;
                temp = curr;

                curr = next;
                if (curr != null) {
                    next = curr.next;
                } else {
                    next = null;
                }
            } else if (curr.val >= b) {
                if (x == null) {
                    x = curr;
                }
                if (temp == null) {
                    temp = prev;
                }
                prev = curr;
                curr = curr.next;
                if (curr != null) {
                    next = curr.next;
                } else {
                    next = null;
                }
            }
        }
        return a;
    }

    public static ListNode insertionSortList(ListNode a) {
        if (a == null || a.next == null)
            return a;

        ListNode newList = null, temp = a;
        while (temp != null){
            ListNode next = temp.next;
            newList = sortInserted(newList, temp);
            temp = next;
        }
        return newList;
    }

    public static ListNode sortInserted(ListNode newList, ListNode temp){
        if(newList == null || newList.val >= temp.val){
            temp.next = newList;
            newList = temp;
        } else {
            ListNode temp2 = newList;
            while(temp2.next != null && temp2.next.val < temp.val){
                temp2 = temp2.next;
            }
            temp.next = temp2.next;
            temp2.next = temp;
        }
        return newList;
    }
}
