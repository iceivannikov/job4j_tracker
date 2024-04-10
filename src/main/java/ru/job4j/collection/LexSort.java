package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] splitLeft = left.split("\\.");
        String[] splitRight = right.split("\\.");
        int i = Integer.parseInt(splitLeft[0]);
        int j = Integer.parseInt(splitRight[0]);
        return Integer.compare(i, j);
    }
}
