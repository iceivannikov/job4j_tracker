package ru.job4j.algorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int result = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, map.getOrDefault(s.charAt(right), 0));
            if (right - left + 1 - maxFreq > k) {
               map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
               left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement lcr = new LongestRepeatingCharacterReplacement();
        String s = "ABAB";
        int k = 2;
        System.out.println(lcr.characterReplacement(s, k));
    }
}
