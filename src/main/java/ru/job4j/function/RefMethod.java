package ru.job4j.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    public static void cutOut(String value) {
        UnaryOperator<String> sub = str -> str.length() > 10 ? str.substring(0, 10) + ".." : str;
        System.out.println(sub.apply(value));
    }
}
