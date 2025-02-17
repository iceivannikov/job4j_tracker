package ru.job4j.algorithms;

import java.util.Arrays;

public class PermutationInStringTwoPointers {
    public boolean checkInclusion(String s1, String s2) {
        boolean result = false;
        if (s1.length() < s2.length()) {
            int[] countS1 = new int[26];
            int[] countS2 = new int[26];
            for (char c : s1.toCharArray()) {
                countS1[c - 'a']++;
            }
            int left = 0;
            for (int right = 0; right < s2.length(); right++) {
                countS2[s2.charAt(right) - 'a']++;
                if (right - left + 1 > s1.length()) {
                    countS2[s2.charAt(left) - 'a']--;
                    left++;
                }
                if (right - left + 1 == s1.length() && Arrays.equals(countS1, countS2)) {
                    result = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        PermutationInStringTwoPointers perm = new PermutationInStringTwoPointers();
        System.out.println(perm.checkInclusion(s1, s2));
    }
}
