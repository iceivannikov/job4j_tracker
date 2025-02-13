package ru.job4j.algorithms;

import java.util.Arrays;

public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int left = 0;
        int right = length - 1;
        int resultIndex = length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[resultIndex--] = nums[left] * nums[left];
                left++;
            } else {
                result[resultIndex--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] nums1 = new int[]{-7, -3, 2, 3, 11};
        SquaresSortedArray solution = new SquaresSortedArray();
        System.out.println(Arrays.toString(solution.sortedSquares(nums)));
        System.out.println(Arrays.toString(solution.sortedSquares(nums1)));
    }
}
