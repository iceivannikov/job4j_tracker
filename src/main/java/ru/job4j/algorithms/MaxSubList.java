package ru.job4j.algorithms;

record MaxRange(int start, int end) {

}

public class MaxSubList {
    MaxRange count(int[] array) {
        int currentSum = array[0];
        int maxSum = array[0];
        int maxStart = 0;
        int maxEnd = 0;
        int tempStart = 0;
        for (int i = 1; i < array.length; i++) {
            if (currentSum < 0) {
                currentSum = array[i];
                tempStart = i;
            } else {
                currentSum += array[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStart = tempStart;
                maxEnd = i;
            }
        }
        return new MaxRange(maxStart, maxEnd);
    }
}
