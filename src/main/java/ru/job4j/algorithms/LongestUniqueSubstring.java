package ru.job4j.algorithms;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        String result = "";
        if (str != null && !str.isEmpty()) {
            Set<Character> uniqChars = new HashSet<>();
            int left = 0;
            int maxLength = 0;
            int start = 0;
            for (int right = 0; right < str.length(); right++) {
                char currentChar = str.charAt(right);
                while (uniqChars.contains(currentChar)) {
                    uniqChars.remove(str.charAt(left));
                    left++;
                }
                uniqChars.add(currentChar);
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    start = left;
                }
            }
            result = str.substring(start, start + maxLength);
        }
        return result;
    }
}
