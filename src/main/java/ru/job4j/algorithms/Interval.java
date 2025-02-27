package ru.job4j.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", start, end);
    }
}

class Main {
    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return new int[]{-1, -1};
        }
        var activeIntervals = new PriorityQueue<Interval>(Comparator.comparingInt(i -> i.end));
        int maxOverlap = 0;
        int maxStart = -1;
        int maxEnd = -1;
        for (Interval interval : intervals) {
            while (!activeIntervals.isEmpty() && activeIntervals.peek().end < interval.start) {
                activeIntervals.poll();
            }
            activeIntervals.offer(interval);
            if (activeIntervals.size() > maxOverlap) {
                maxOverlap = activeIntervals.size();
                maxStart = interval.start;
                maxEnd = activeIntervals.peek().end;
            }
            while (maxStart == maxEnd) {
                activeIntervals.poll();
                if (!activeIntervals.isEmpty()) {
                    maxStart = activeIntervals.peek().start;
                    maxEnd = activeIntervals.peek().end;
                }
            }
        }
        return new int[]{maxStart, maxEnd};
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(4, 6));

        int[] result = findMaxOverlapInterval(intervals);

        System.out.println("Interval that overlaps the maximum number of intervals: [" + result[0]
                + ", " + result[1] + "]");
    }
}