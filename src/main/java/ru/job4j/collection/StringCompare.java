package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int index = 0;
        while (index < left.length() && index < right.length()) {
            char chLeft = left.toLowerCase().charAt(index);
            char chRight = right.toLowerCase().charAt(index);
            if (chLeft != chRight) {
                return Character.compare(chLeft, chRight);
            }
            index++;
        }
        return Integer.compare(left.length(), right.length());
    }
}
