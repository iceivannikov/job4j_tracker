package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        String[] strings = {
                "image 100",
                "image 30",
                "image 2"
        };
        Comparator<String> comparatorText = (left, right) -> left.compareTo(right);
        Comparator<String> comparatorDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        Arrays.sort(strings, comparatorText);
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, comparatorDescSize);
        System.out.println(Arrays.toString(strings));
    }
}
