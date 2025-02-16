package ru.job4j.algorithms;

import java.util.Arrays;

public class PermutationInStringOnArray {
    public boolean checkInclusion(String s1, String s2) {
        boolean result = false;
        if (s1.length() < s2.length()) {
            int[] countS1 = new int[26];
            int[] countS2 = new int[26];
            for (char c : s1.toCharArray()) {
                countS1[c - 'a']++;
            }
            for (int i = 0; i < s1.length(); i++) {
                countS2[s2.charAt(i) - 'a']++;
            }
            if (Arrays.equals(countS1, countS2)) {
                result = true;
            }
            for (int i = s1.length(); i < s2.length(); i++) {
                countS2[s2.charAt(i - s1.length()) - 'a']--;
                countS2[s2.charAt(i) - 'a']++;
                if (Arrays.equals(countS1, countS2)) {
                    result = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        PermutationInStringOnArray perm = new PermutationInStringOnArray();
        System.out.println(perm.checkInclusion(s1, s2));
    }
}
