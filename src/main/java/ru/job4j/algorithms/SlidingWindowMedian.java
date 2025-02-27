package ru.job4j.algorithms;

import java.util.Arrays;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int[] window = new int[k];
        System.arraycopy(nums, 0, window, 0, k);
        Arrays.sort(window);
        result[0] = getMedian(window);
        for (int i = k; i < nums.length; i++) {
            int removeIndex = binarySearch(window, nums[i - k]);
            System.arraycopy(window, removeIndex + 1, window, removeIndex, window.length
                    - removeIndex - 1);
            int insertIndex = binarySearch(window, nums[i]);
            if (insertIndex < 0) {
                insertIndex = -insertIndex - 1;
            }
            if (insertIndex < window.length) {
                System.arraycopy(window, insertIndex, window, insertIndex + 1, window.length
                        - insertIndex - 1);
                window[insertIndex] = nums[i];
            } else {
                window[window.length - 1] = nums[i];
            }
            result[i - k + 1] = getMedian(window);
        }
        return result;
    }

    private double getMedian(int[] window) {
        int n = window.length;
        double result = window[n / 2];
        if (n % 2 == 0) {
            result = ((double) window[n / 2 - 1] + window[n / 2]) / 2.0;
        }
        return result;
    }

    private int binarySearch(int[] window, int target) {
        int left = 0;
        int right = window.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (window[mid] == target) {
                return mid;
            } else if (window[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
