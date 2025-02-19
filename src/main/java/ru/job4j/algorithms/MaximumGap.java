package ru.job4j.algorithms;

import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 9};
        System.out.println(new MaximumGap().maximumGap(nums));
    }
}
