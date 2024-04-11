package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int index = 0;
        while (index < left.length() && index < right.length()) {
            if (left.charAt(index) != right.charAt(index)) {
                return Character.compare(left.charAt(index), right.charAt(index));
            }
            index++;
        }
        return Integer.compare(left.length(), right.length());
    }
}
