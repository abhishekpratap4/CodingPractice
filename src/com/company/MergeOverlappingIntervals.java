package com.company;

import java.util.ArrayList;

/**
 * Created by pratap on 12/7/16.
 */
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
//        Interval i1 = new Interval(1, 3);
//        list.add(i1);
//        Interval i3 = new Interval(2, 6);
//        list.add(i3);
//        Interval i2 = new Interval(5, 8);
//        list.add(i2);
//
//        Interval i4 = new Interval(9, 12);
//        list.add(i4);
//        Interval i5 = new Interval(15, 18);
//        list.add(i5);
//        Interval i6 = new Interval(6, 6);
//        list.add(i6);

        ArrayList<Interval> it = new MergeOverlappingIntervals().merge(list);
//        for (int i = 0; i < it.size(); i++) {
//            System.out.println("[" + it.get(i).start + "," + it.get(i).end + "]");
//        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        intervals.forEach(interval -> checkInterval(interval));
        intervals.sort((o1, o2) -> Integer.compare(o1.start, o2.start));

        for (int i = 0; i < intervals.size(); i++) {
            if ((i + 1 < intervals.size())
                    && ((intervals.get(i).end >= intervals.get(i + 1).start && intervals.get(i).end <= intervals.get(i + 1).end)
                    || (intervals.get(i + 1).start >= intervals.get(i).start && intervals.get(i + 1).end <= intervals.get(i).end))) {
                Interval newIn = new Interval(Math.min(intervals.get(i).start, intervals.get(i + 1).start), Math.max(intervals.get(i).end, intervals.get(i + 1).end));
                intervals.set(i, newIn);
                intervals.remove(i + 1);
                i = i - 1;
            }
            for (int j = 0; j < intervals.size(); j++) {
                System.out.println("[" + intervals.get(j).start + "," + intervals.get(j).end + "]");
            }
            System.out.println("_________________");
        }
        return intervals;
    }

    public static Interval checkInterval(Interval newInterval) {
        if (newInterval.start > newInterval.end) {
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
        return newInterval;
    }
}
