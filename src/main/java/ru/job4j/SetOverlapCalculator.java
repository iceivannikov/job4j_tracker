package ru.job4j;

import java.util.HashSet;
import java.util.Set;

public class SetOverlapCalculator {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        Set<Integer> result = findIntersection(set1, set2);
        print(set1, set2, result);
        calculateOverlapPercentage(result, set2);
    }

    public static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>();
        for (Integer i : set1) {
            if (set2.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void print(Set<Integer> set1, Set<Integer> set2, Set<Integer> result) {
        System.out.println("Входные данные:");
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("Выходные данные:");
        System.out.println("Пересечение множеств: " + result);
    }

    public static double calculateOverlapPercentage(Set<Integer> result, Set<Integer> set2) {
        int coincidences = result.size();
        double overlap = coincidences / (double) set2.size() * 100;
        System.out.printf("set1 перекрывает set2 на %.1f%%", overlap);
        return overlap;
    }
}
