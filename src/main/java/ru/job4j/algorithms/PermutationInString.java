package ru.job4j.algorithms;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        boolean result = false;
        if (s1.length() < s2.length()) {
            Map<Character, Integer> counterS1 = new HashMap<>();
            Map<Character, Integer> counterS2 = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                counterS1.put(s1.charAt(i), counterS1.getOrDefault(s1.charAt(i), 0) + 1);
            }
            for (int i = 0; i < s1.length(); i++) {
                counterS2.put(s2.charAt(i), counterS2.getOrDefault(s2.charAt(i), 0) + 1);
            }
            if (counterS1.equals(counterS2)) {
                result = true;
            } else {
                for (int i = s1.length(); i < s2.length(); i++) {
                    char leftChar = s2.charAt(i - s1.length());
                    counterS2.put(leftChar, counterS2.get(leftChar) - 1);
                    if (counterS2.get(leftChar) == 0) {
                        counterS2.remove(leftChar);
                    }
                    char rightChar = s2.charAt(i);
                    counterS2.put(rightChar, counterS2.getOrDefault(rightChar, 0) + 1);
                    if (counterS1.equals(counterS2)) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion(s1, s2));
    }
}
