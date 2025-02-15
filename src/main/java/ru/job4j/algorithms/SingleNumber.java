package ru.job4j.algorithms;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        if (nums.length == 1) {
            result = nums[0];
        } else {
            for (int num : nums) {
                result ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new SingleNumber().singleNumber(nums));
    }
}
