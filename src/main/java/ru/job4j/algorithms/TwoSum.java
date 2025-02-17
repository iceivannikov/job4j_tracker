package ru.job4j.algorithms;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] + nums[right] == target) {
                result[0] = right;
                result[1] = left;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
