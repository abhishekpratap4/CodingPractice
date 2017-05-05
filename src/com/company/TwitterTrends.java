package com.company;

import java.util.*;

/**
 * Created by pratap on 4/29/17.
 */


public class TwitterTrends {

    static Map<String, Integer> hashtagMap = new HashMap<>();

    static class QueueNode implements Comparable<QueueNode> {
        String tag;
        int count;

        public QueueNode(String name, int c) {
            tag = name;
            count = c;
        }

        @Override
        public int compareTo(QueueNode o) {
            int diff = this.count - o.count;
            if (diff != 0)
                return diff;
            else
                return o.tag.compareTo(this.tag);
        }

        @Override
        public String toString() {
            return this.tag;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = Integer.parseInt(s.nextLine());

        while (N > 0) {
            String tweet = s.nextLine();
            processTweet(tweet);
            N--;
        }
        //System.out.println(hashtagMap);

        PriorityQueue<QueueNode> p = new PriorityQueue<>(5, Collections.reverseOrder());
        for (Map.Entry<String, Integer> e : hashtagMap.entrySet()) {
            p.add(new QueueNode(e.getKey(), e.getValue().intValue()));
        }

        System.out.println(p.remove());
        System.out.println(p.remove());
        System.out.println(p.remove());
        System.out.println(p.remove());
        System.out.println(p.remove());
    }

    private static void processTweet(String tweet) {
        String tagArr[] = tweet.split(" ");
        for (String tag : tagArr) {
            if (tag.startsWith("#")) {
                addToMap(tag);
            }
        }
    }

    private static void addToMap(String hashTag) {
        if (hashtagMap.containsKey(hashTag)) {
            hashtagMap.put(hashTag, hashtagMap.get(hashTag) + 1);
        } else {
            hashtagMap.put(hashTag, 1);
        }
    }
}
