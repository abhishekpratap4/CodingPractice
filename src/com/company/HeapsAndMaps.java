package com.company;

import java.util.*;

/**
 * Created by pratap on 1/19/17.
 */

class ListNodeComparator implements Comparator<ListNode> {

    @Override
    public int compare(ListNode o1, ListNode o2) {
        return o1.val > o2.val ? 1 : -1;
    }
}

public class HeapsAndMaps {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(10);
        head1.next.next = new ListNode(20);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(13);

        ListNode head3 = new ListNode(8);
        head3.next = new ListNode(8);
        head3.next.next = new ListNode(9);

        ListNode arr[] = {head1, head2, head3};
        ListNode res = mergeKLists(new ArrayList<>(Arrays.asList(arr)));
        System.out.print(res.val);

    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode res = null, t = null;
        TreeMap<ListNode, Integer> map = new TreeMap<>(new ListNodeComparator());
        for (int i = 0; i < a.size(); i++) {
            ListNode head = a.get(i);
            while (head != null) {
                map.put(head, head.val);
                head = head.next;
            }
        }

        int i = 0;
        for (Map.Entry<ListNode, Integer> e : map.entrySet()) {
            ListNode temp = e.getKey();
            if (i == 0) {
                res = temp;
                t = res;
            } else {
                t.next = temp;
                t = t.next;
            }
            i++;
        }

        return res;
    }
}
