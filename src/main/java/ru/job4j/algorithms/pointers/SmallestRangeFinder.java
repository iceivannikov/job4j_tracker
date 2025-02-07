package ru.job4j.algorithms.pointers;

import java.util.Arrays;

public class SmallestRangeFinder {

    public static int[] findSmallestRange(int[] nums, int k) {
        int[] result = null;
        if (k > nums.length) {
            return result;
        }
        int start = 0;
        int count = k - 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count--;
            } else {
                start = i;
                count = k - 1;
            }
            if (count == 0) {
                result = new int[2];
                result[0] = start;
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 5, 6, 7};
        int k = 4;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }

}
