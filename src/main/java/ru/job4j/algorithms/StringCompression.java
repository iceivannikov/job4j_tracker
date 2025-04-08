package ru.job4j.algorithms;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompression {
    public String compress(String input) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : map.keySet()) {
            int count = map.get(c);
            sb.append(c);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        System.out.println(s.compress("abcdshdkjhiuwfhwiuhveivhwioiqwjsjsksj"));
    }
}
