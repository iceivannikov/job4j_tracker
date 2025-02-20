package ru.job4j.algorithms;

import java.util.Arrays;

public class Merge {
    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergesort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergesort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[index++] = left[leftIndex++];
            } else {
                result[index++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            result[index++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            result[index++] = right[rightIndex++];
        }
        return result;
    }
}
