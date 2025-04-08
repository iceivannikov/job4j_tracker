package ru.job4j.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueNumbersTest {
    private final UniqueNumbers uniqueNumbers = new UniqueNumbers();

    @Test
    void whenAllElementsUniqueThenReturnSameArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, uniqueNumbers.findUnique(input));
    }

    @Test
    void whenSomeElementsDuplicateThenReturnOnlyUniqueElements() {
        int[] input = {1, 1, 2, 2, 3, 4, 5};
        int[] expected = {3, 4, 5};
        assertArrayEquals(expected, uniqueNumbers.findUnique(input));
    }

    @Test
    void whenArrayIsEmptyThenReturnEmptyArray() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, uniqueNumbers.findUnique(input));
    }

    @Test
    void whenAllElementsHaveDuplicatesThenReturnEmptyArray() {
        int[] input = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int[] expected = {};
        assertArrayEquals(expected, uniqueNumbers.findUnique(input));
    }

    @Test
    void whenSingleElementThenReturnSameElement() {
        int[] input = {7};
        int[] expected = {7};
        assertArrayEquals(expected, uniqueNumbers.findUnique(input));
    }

    @Test
    void whenDuplicatesAtStartThenReturnUniqueFromMiddleAndEnd() {
        int[] input = {1, 1, 2, 3, 4, 5};
        int[] expected = {2, 3, 4, 5};
        assertArrayEquals(expected, uniqueNumbers.findUnique(input));
    }

    @Test
    void whenDuplicatesAtEndThenReturnUniqueFromStartAndMiddle() {
        int[] input = {1, 2, 3, 4, 5, 5};
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, uniqueNumbers.findUnique(input));
    }

    @Test
    void whenElementAppearsThreeTimesThenNotIncluded() {
        int[] input = {1, 1, 1, 2, 3, 3, 4};
        int[] expected = {2, 4};
        assertArrayEquals(expected, uniqueNumbers.findUnique(input));
    }
}