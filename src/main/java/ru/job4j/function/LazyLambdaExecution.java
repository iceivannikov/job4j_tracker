package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class LazyLambdaExecution {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
        };
        String[] names1 = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthComparator = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names1, lengthComparator);
    }
}
