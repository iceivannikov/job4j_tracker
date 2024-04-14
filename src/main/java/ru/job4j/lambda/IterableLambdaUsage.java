package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class IterableLambdaUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("top");
        list.add("user");
        list.add("precision");
        list.add("post");
        Predicate<String> predicate = s -> s.length() == 4;
        list.removeIf(predicate);
        list.forEach(System.out::println);
        System.out.println("=".repeat(30));
        List<Integer> integers = Arrays.asList(2, 4, 7, 9, 12);
        System.out.println("Before UnaryOperator");
        integers.forEach(s -> System.out.println("Current number: " + s));
        UnaryOperator<Integer> unaryOperator = i -> i * i;
        integers.replaceAll(unaryOperator);
        System.out.println("After UnaryOperator");
        integers.forEach(s -> System.out.println("Current number: " + s));
    }
}
