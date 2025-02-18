package ru.job4j.algorithms;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        boolean result = true;
        if (s.length() != t.length()) {
            result = false;
        } else {
            int[] counter1 = new int[26];
            int[] counter2 = new int[26];
            for (char c : s.toCharArray()) {
                counter1[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                counter2[c - 'a']++;
            }
            if (!Arrays.equals(counter1, counter2)) {
                result = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new ValidAnagram().isAnagram(s, t));
        String s1 = "rat";
        String t1 = "car";
        System.out.println(new ValidAnagram().isAnagram(s1, t1));
        String s2 = "rat";
        String t2 = "nagaram";
        System.out.println(new ValidAnagram().isAnagram(s2, t2));
    }
}
