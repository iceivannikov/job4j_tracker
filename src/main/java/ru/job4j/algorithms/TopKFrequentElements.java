package ru.job4j.algorithms;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
          map.put(num, map.getOrDefault(num, 0) + 1);
      }
      PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
              Comparator.comparingInt(Map.Entry::getValue)
      );
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
          pq.add(entry);
          if (pq.size() > k) {
              pq.poll();
          }
      }
      int[] result = new int[k];
      for (int i = k - 1; i >= 0; i--) {
          result[i] = Objects.requireNonNull(pq.poll()).getKey();
      }
      return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, k)));
    }
}
