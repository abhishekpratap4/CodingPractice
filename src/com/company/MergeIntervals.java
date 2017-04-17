package com.company;

import java.util.ArrayList;

/**
 * Created by pratap on 12/7/16.
 */
public class MergeIntervals {
    public static void main(String[] args) {

        ArrayList<Interval> list = new ArrayList<>();
        Interval i1 = new Interval(1,2);
        list.add(i1);
        Interval i2 = new Interval(8,10);
        list.add(i2);
//        Interval i3 = new Interval(11,12);
//        list.add(i3);
//        Interval i4 = new Interval(13,14);
//        list.add(i4);
//        Interval i5 = new Interval(12, 16);
//        list.add(i5);

        Interval newI = new Interval(3,6);
        ArrayList<Interval> it = insert(list, newI);
        for (int i = 0; i < it.size(); i++) {
            System.out.println("[" + it.get(i).start + "," + it.get(i).end + "]");
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {


        if(newInterval.start > newInterval.end){
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }

        if(intervals.size()<= 0){
            ArrayList<Interval> out = new ArrayList<Interval>();
            out.add(newInterval);
            return out;
        }

        int start = -1, end = -1;
        boolean startInserted = false, endInserted = false;
        for (int i = 0; i < intervals.size(); i++) {
            Interval in = intervals.get(i);
            if (!startInserted && newInterval.start >= in.start && newInterval.start <= in.end) {
                start = i;
                startInserted = true;
            } else if (i > 0 && !startInserted && newInterval.start < intervals.get(i).start) {
                if(newInterval.start >= intervals.get(i-1).start && newInterval.end <= intervals.get(i-1).end) {
                    start = i - 1;
                    startInserted = true;
                    Interval temp = new Interval();
                    temp.start = Math.min(intervals.get(i - 1).start, newInterval.start);
                    temp.end = Math.max(newInterval.end, intervals.get(i - 1).end);
                    intervals.set(i - 1, temp);
                }
            }
        }
        if (!startInserted) {
            if (newInterval.start < intervals.get(0).start && newInterval.end >= intervals.get(0).start) {
                start = 0;
                Interval temp = new Interval();
                temp.start = newInterval.start;
                temp.end = intervals.get(0).end;
                intervals.set(0, temp);
                startInserted = true;
            } else if (newInterval.start > intervals.get(intervals.size() - 1).end) {
                intervals.add(new Interval(newInterval.start,newInterval.end));
                start = end = intervals.size()-1;
                startInserted = true;
                endInserted = true;
            } else if (newInterval.end < intervals.get(0).start) {
                ArrayList<Interval> n = new ArrayList<>();
                n.add(new Interval(newInterval.start,newInterval.end));
                n.addAll(1,intervals);
                intervals = n;
                start = end = 0;
                startInserted = true;
                endInserted = true;
            }

        }

        for (int i = 0; i < intervals.size(); i++) {
            Interval in = intervals.get(i);
            if (!endInserted && newInterval.end >= in.start && newInterval.end <= in.end) {
                end = i;
                endInserted = true;
            } else if (i > 0 && !endInserted && newInterval.end < intervals.get(i).start) {
                end = i - 1;
                endInserted = true;
                Interval temp = new Interval();
                temp.start = intervals.get(i-1).start;
                temp.end = newInterval.end;
                intervals.set(i-1, temp);
            }
        }

        if (!endInserted) {
            if (newInterval.end < intervals.get(0).start) {
//                end = 0;
//                Interval temp = new Interval();
//                temp.start = newInterval.end;
//                temp.end = intervals.get(0).end;
//                intervals.set(0,temp);
//                endInserted = true;
                System.out.println("unwanted");
            } else if (newInterval.end > intervals.get(intervals.size() - 1).end) {
                end = intervals.size() - 1;
                Interval temp = new Interval();
                temp.start = intervals.get(intervals.size() - 1).start;
                temp.end = newInterval.end;
                intervals.set(intervals.size() - 1, temp);
                endInserted = true;
            }
        }

        System.out.println("Start: " + start + " End: " + end);
        int k = 0;
        ArrayList<Interval> intervalsOut = new ArrayList<>();
        while (k < start) {
            intervalsOut.add(intervals.get(k));
            k++;
        }
        Interval t = new Interval();
        t.start = intervals.get(start).start;
        t.end = intervals.get(end).end;

        intervalsOut.add(t);

        k = end + 1;
        while (k <= intervals.size() - 1) {
            intervalsOut.add(intervals.get(k));
            k++;
        }
        return intervalsOut;
    }
}


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
