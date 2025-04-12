package ru.job4j.algorithms;

import java.util.List;
import java.util.PriorityQueue;

public class BankMaxLoadTime {
    public static int[] findMaxLoadTime(List<int[]> visitTimes) {
        if (visitTimes.isEmpty()) {
            return new int[]{-1, -1};
        }
        PriorityQueue<Event> intervals = new PriorityQueue<>();
        for (int[] time : visitTimes) {
            intervals.offer(new Event(time[0], EventType.ARRIVAL));
            intervals.offer(new Event(time[1], EventType.DEPARTURE));
        }
        int maxLoadStartTime = 0;
        int maxLoadEndTime = 0;
        int cnt = 0;
        int maxCnt = 0;
        while (!intervals.isEmpty()) {
            int currentTime = intervals.peek().time;
            int arrivals = 0;
            int departures = 0;
            while (!intervals.isEmpty() && intervals.peek().time == currentTime) {
                Event event = intervals.poll();
                if (event.type == EventType.ARRIVAL) {
                    arrivals++;
                } else {
                    departures++;
                }
            }
            cnt += arrivals;
            int nextTime = (!intervals.isEmpty()) ? intervals.peek().time : currentTime;
            if (cnt > maxCnt) {
                maxCnt = cnt;
                maxLoadStartTime = currentTime;
                maxLoadEndTime = nextTime;
            }
            cnt -= departures;
        }
        return new int[]{maxLoadStartTime, maxLoadEndTime};
    }

    static class Event implements Comparable<Event> {
        int time;
        EventType type;

        Event(int time, EventType type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return this.type == EventType.ARRIVAL ? -1 : 1;
            }
            return Integer.compare(this.time, other.time);
        }
    }

    enum EventType {
        ARRIVAL, DEPARTURE
    }
}
