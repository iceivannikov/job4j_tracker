package ru.job4j.algorithms;

import java.util.*;

public class TopKFrequentWordsStream {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map.entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Integer>comparingByValue().reversed()
                                .thenComparing(Map.Entry.comparingByKey())
                )
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static void main(String[] args) {
        TopKFrequentWordsStream words = new TopKFrequentWordsStream();
        String[] strings = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        System.out.println(words.topKFrequent(strings, k));
    }
}
