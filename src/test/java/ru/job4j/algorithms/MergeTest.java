package ru.job4j.algorithms;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MergeTest {
    @Test
    void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenEmptyArrayThenOk() {
        int[] array = {};
        assertThat(Merge.mergesort(array)).isEmpty();
    }

    @Test
    void whenSingleElementArrayThenOk() {
        int[] array = {42};
        assertThat(Merge.mergesort(array)).containsExactly(42);
    }

    @Test
    void whenReverseSortedThenOk() {
        int[] array = {5, 4, 3, 2, 1};
        assertThat(Merge.mergesort(array)).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void whenArrayWithDuplicatesThenOk() {
        int[] array = {5, 3, 5, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(2, 3, 3, 5, 5);
    }

    @Test
    void whenArrayWithNegativeNumbersThenOk() {
        int[] array = {-5, 0, 3, -1, 2};
        assertThat(Merge.mergesort(array)).containsExactly(-5, -1, 0, 2, 3);
    }

    @Test
    void whenArrayWithOneUniqueElementThenOk() {
        int[] array = {7, 7, 7, 7, 3, 7, 7};
        assertThat(Merge.mergesort(array)).containsExactly(3, 7, 7, 7, 7, 7, 7);
    }

    @Test
    void whenAllElementsAreSameThenOk() {
        int[] array = {5, 5, 5, 5, 5};
        assertThat(Merge.mergesort(array)).containsExactly(5, 5, 5, 5, 5);
    }
}