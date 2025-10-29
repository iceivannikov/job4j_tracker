package ru.job4j.algorithms;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int counter = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (counter == 0) {
                candidate = num;
            }
            if (candidate == num) {
                counter++;
            } else {
                counter--;
            }
        }
        return candidate;
    }
}
