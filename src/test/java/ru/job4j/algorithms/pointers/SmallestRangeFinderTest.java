package ru.job4j.algorithms.pointers;

import org.junit.jupiter.api.Test;
import ru.job4j.algorithms.SmallestRangeFinder;

import static org.assertj.core.api.Assertions.assertThat;

public class SmallestRangeFinderTest {

    @Test
    public void whenFindSmallestRangeUniqueElementsThenReturnsExpectedRange() {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] expectedRange = {0, 2};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenFindSmallestRangeRepeatedElementsThenReturnsExpectedRange() {
        int[] nums = {1, 2, 3, 3, 5, 6, 7};
        int k = 4;
        int[] expectedRange = {3, 6};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenNotFound() {
        int[] nums = {1, 2, 3, 3, 3};
        int k = 4;
        int[] expectedRange = null;
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenFindSmallestRangeWithDuplicatesAndSmallWindowThenFails() {
        int[] nums = {1, 2, 2, 3, 4, 5};
        int k = 3;
        int[] expectedRange = {2, 4};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenFindSmallestRangeWithIncreasingNumbersThenFails() {
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int k = 3;
        int[] expectedRange = {3, 5};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenSingleElementArrayThenReturnsNull() {
        int[] nums = {5};
        int k = 2;
        int[] expectedRange = null;
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenAllElementsAreSameThenReturnsNull() {
        int[] nums = {3, 3, 3, 3, 3};
        int k = 2;
        int[] expectedRange = null;
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenOnlyKUniqueElementsThenReturnsWholeArray() {
        int[] nums = {1, 2, 3};
        int k = 3;
        int[] expectedRange = {0, 2};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenAllElementsAreUniqueThenReturnsSmallestRange() {
        int[] nums = {10, 20, 30, 40, 50};
        int k = 3;
        int[] expectedRange = {0, 2};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenSmallestRangeAtEndThenFindsIt() {
        int[] nums = {1, 1, 1, 2, 3, 4};
        int k = 3;
        int[] expectedRange = {2, 4};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }
}