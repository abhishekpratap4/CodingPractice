package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pratap on 11/28/16.
 */
public class Twitter {

    HashMap<Integer, LinkedList<Integer>> userTweet;
    HashMap<Integer, LinkedList<Integer>> userFollower;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userTweet = new HashMap<>();
        userFollower = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (userTweet.containsKey(userId)) {
            LinkedList<Integer> tweetList = userTweet.get(userId);
            if (!tweetList.contains(tweetId))
                tweetList.add(tweetId);
        } else {
            LinkedList<Integer> tweetList = new LinkedList<>();
            tweetList.add(tweetId);
            userTweet.put(userId, tweetList);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweetList = new LinkedList<>();
        List<Integer> fullList = new LinkedList<>();
        if (userTweet.containsKey(userId)) {
            tweetList = userTweet.get(userId);
            fullList.addAll(tweetList);
        }
        if (userFollower.containsKey(userId)) {
            List<Integer> followerList = userFollower.get(userId);
            Iterator it = followerList.iterator();
            while (it.hasNext()) {
                List<Integer> followerTweets = getTweets((int) it.next());
                if (followerTweets != null)
                    fullList.addAll(followerTweets);
            }
        }
        List<Integer> output = new LinkedList<>();
        for (int i = fullList.size() - 1; i >= 0; i--) {
            output.add(fullList.get(i));
        }
        output = output.subList(0, output.size() >= 10 ? 10 : output.size());
        return output;
    }

    private List<Integer> getTweets(int userId) {
        if (userTweet.containsKey(userId)) {
            return userTweet.get(userId);
        }
        return null;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        if (userFollower.containsKey(followerId)) {
            LinkedList<Integer> followerList = userFollower.get(followerId);
            if (!followerList.contains(followeeId))
                followerList.add(followeeId);
        } else {
            LinkedList<Integer> followerList = new LinkedList<>();
            followerList.add(followeeId);
            userFollower.put(followerId, followerList);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        if (userFollower.containsKey(followerId)) {
            LinkedList<Integer> followerList = userFollower.get(followerId);
            followerList.remove(new Integer(followeeId));
        }
    }

    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1, 1);
        obj.postTweet(2, 3);
        obj.postTweet(1, 2);
        System.out.println(obj.getNewsFeed(1));
        obj.follow(1, 2);
        System.out.println(obj.getNewsFeed(1));
        obj.unfollow(1, 2);
        System.out.println(obj.getNewsFeed(1));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */