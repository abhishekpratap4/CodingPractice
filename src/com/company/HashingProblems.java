package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by pratap on 1/13/17.
 */


class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class HashingProblems {
    public static void main(String[] args) {
        //System.out.println(fractionToDecimal(-2147483648, -1));
        RandomListNode head = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);

        head.next = node2;
        head.random = node3;

        head.next.next = node3;
        head.next.random = head;

        head.next.next.random = head;

        copyRandomList(head);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 1 || denominator == -1) {
            return Integer.toString(numerator / denominator);
        }
        double result = (numerator * 1.0f) / (denominator * 1.0f);
        String resString = String.valueOf(result);
        String resParts[] = resString.split("\\.");
        String resPart1 = resParts[1].split("E")[0];
        if ((Integer.parseInt(resPart1)) == 0)
            return resParts[0];
        else {
            LinkedHashSet<Character> set = new LinkedHashSet<>();
            for (int i = 0; i < resPart1.length() && i < 5; i++) {
                char value = resPart1.charAt(i);
                if (!set.contains(value)) {
                    set.add(value);
                }
            }
            StringBuilder str = new StringBuilder("");
            Iterator<Character> it = set.iterator();
            while (it.hasNext()) {
                str.append(it.next());
            }
            if (set.size() == resPart1.length())
                return resParts[0] + "." + str.toString();
            else
                return resParts[0] + "." + "(" + str.toString() + ")";
        }
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        HashMap<Integer, RandomListNode> map = new HashMap<>();

        RandomListNode temp = head;
        RandomListNode newHead = null, newTemp = null;
        while (temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);
            if (newHead == null) {
                newHead = newNode;
            } else {
                newTemp.next = newNode;
            }
            newTemp = newNode;
            temp = temp.next;
            map.put(newTemp.label, newTemp);
        }

        temp = head;
        while (temp != null) {
            RandomListNode random = temp.random;
            map.get(temp.label).random = map.get(random.label);
            temp = temp.next;
        }

        return newHead;
    }
}
