package ru.job4j.algorithms;

import java.util.*;

public class SlidingWindowMedianHeap {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            balanceHeaps(maxHeap, minHeap);
            if (i >= k - 1) {
                result[i - k + 1] = getMedian(maxHeap, minHeap, k);
                int outOfWindow = nums[i - k + 1];
                if (!maxHeap.remove(outOfWindow)) {
                    minHeap.remove(outOfWindow);
                }
                balanceHeaps(maxHeap, minHeap);
            }
        }
        return result;
    }

    private void balanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        while (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int k) {
        double result = !maxHeap.isEmpty() ? maxHeap.peek() : 0;
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && k % 2 == 0) {
            result = ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        SlidingWindowMedianHeap swm = new SlidingWindowMedianHeap();
        System.out.println(Arrays.toString(swm.medianSlidingWindow(nums, k)));
    }
}
