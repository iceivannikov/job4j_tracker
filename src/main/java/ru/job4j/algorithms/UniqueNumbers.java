package ru.job4j.algorithms;

import java.util.Arrays;

public class UniqueNumbers {
    public int[] findUnique(int[] array) {
        int left = 0;
        int right = 0;
        int index = 0;
        while (right < array.length) {
            if (array[right] == array[left]) {
                right++;
            } else {
                if (right - left == 1) {
                    array[index] = array[left];
                    index++;
                }
                left = right;
            }
        }
        if (right - left == 1) {
            array[index] = array[left];
            index++;
        }
        return Arrays.copyOf(array, index);
    }
}
