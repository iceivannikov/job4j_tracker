package ru.job4j.algorithms.subarraysumequalsk;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int currentPrefixSum = 0;
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0, 1);
        for (int num : nums) {
            currentPrefixSum += num;
            if (prefixSumCounts.containsKey(currentPrefixSum - k)) {
                result += prefixSumCounts.get(currentPrefixSum - k);
            }
            prefixSumCounts.put(currentPrefixSum, prefixSumCounts.getOrDefault(num, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.subarraySum(nums, k));
    }
}
