package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftSplit = left.split("/");
        String[] rightSplit = right.split("/");
        int result = rightSplit[0].compareTo(leftSplit[0]);
        if (result != 0) {
            return result;
        }
        return left.compareTo(right);
    }
}
