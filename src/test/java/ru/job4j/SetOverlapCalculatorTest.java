package ru.job4j;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class SetOverlapCalculatorTest {

    @Test
    void whenFindingIntersection() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        Set<Integer> result = SetOverlapCalculator.findIntersection(set1, set2);
        Set<Integer> expected = new HashSet<>();
        expected.add(2);
        expected.add(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenNotFindingIntersection() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        Set<Integer> result = SetOverlapCalculator.findIntersection(set1, set2);
        Set<Integer> expected = new HashSet<>();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenPercentageIntersection66Dot7percent() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        Set<Integer> result = SetOverlapCalculator.findIntersection(set1, set2);
        double actual = SetOverlapCalculator.calculateOverlapPercentage(result, set2);
        double expected = 66.7;
        assertThat(actual).isCloseTo(expected, offset(0.1D));
    }

    @Test
    void whenPercentageIntersection0percent() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        Set<Integer> result = SetOverlapCalculator.findIntersection(set1, set2);
        double actual = SetOverlapCalculator.calculateOverlapPercentage(result, set2);
        double expected = 0;
        assertThat(actual).isCloseTo(expected, offset(0.1D));
    }
}