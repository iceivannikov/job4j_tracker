package ru.job4j.algorithms;

import java.util.*;

public class TopKFrequentWordsPriorityQueue {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue())
                ? b.getKey().compareTo(a.getKey())
                        : a.getValue() - b.getValue()
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentWordsPriorityQueue words = new TopKFrequentWordsPriorityQueue();
        String[] strings = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        System.out.println(words.topKFrequent(strings, k));
    }
}
