package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapLambdaUsage {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "top");
        map.put(3, "user");
        map.put(4, "precision");
        map.put(5, "post");
        BiFunction<Integer, String, String> function = (key, value) -> value + "_" + key;
        String result = map.computeIfPresent(1, function);
        System.out.println("Current value: " + result);
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println("=".repeat(30));
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println("=".repeat(30));
        BiFunction<Integer, String, String> biFunction = (key, value) -> value + "_" + key;
        map.replaceAll(biFunction);
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println("=".repeat(30));
        Map<String, Integer> integerHashMap = new HashMap<>();
        Function<String, Integer> func = String::length;
        System.out.println("Result: " + integerHashMap.computeIfAbsent("Petr", func));
        System.out.println("Result: " + integerHashMap.computeIfAbsent("Petr", key -> key.length() + 10));
        integerHashMap.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println("=".repeat(30));
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("Shoes", 200);
        BiFunction<Integer, Integer, Integer> biFunction1 = (oldValue, newValue) -> oldValue - newValue;
        int newPrice = stringIntegerMap.merge("Shoes", 50, biFunction1);
        System.out.println("New price: " + newPrice);
        System.out.println("Price of shirt: " + stringIntegerMap.merge("Shirt", 100, biFunction1));
        stringIntegerMap.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
    }
}
