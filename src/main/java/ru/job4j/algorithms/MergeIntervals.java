package ru.job4j.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        if (intervals.length > 0) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            for (int[] interval : intervals) {
                if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                    merged.add(interval);
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
                }
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
