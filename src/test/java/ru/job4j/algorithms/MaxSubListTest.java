package ru.job4j.algorithms;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MaxSubListTest {

    @Test
    public void whenArrayHasMixedPositiveAndNegativeNumbersThenFindMaxSubarray() {
        MaxSubList maxSubList = new MaxSubList();
        int[] array = {2, -8, 3, -2, 4, -10};
        MaxRange result = maxSubList.count(array);
        assertThat(result.start()).isEqualTo(2);
        assertThat(result.end()).isEqualTo(4);
    }

    @Test
    public void whenArrayHasOnlyPositiveNumbersThenFindMaxSubarray() {
        MaxSubList maxSubList = new MaxSubList();
        int[] array = {1, 2, 3, 4, 5};
        MaxRange result = maxSubList.count(array);
        assertThat(result.start()).isEqualTo(0);
        assertThat(result.end()).isEqualTo(4);
    }

    @Test
    public void whenArrayHasOnlyNegativeNumbersThenFindMaxSubarray() {
        MaxSubList maxSubList = new MaxSubList();
        int[] array = {-1, -2, -3, -4, -5};
        MaxRange result = maxSubList.count(array);
        assertThat(result.start()).isEqualTo(0);
        assertThat(result.end()).isEqualTo(0);
    }

    @Test
    public void whenArrayHasSingleElementThenThatIsMaxSubarray() {
        MaxSubList maxSubList = new MaxSubList();
        int[] array = {10};
        MaxRange result = maxSubList.count(array);
        assertThat(result.start()).isEqualTo(0);
        assertThat(result.end()).isEqualTo(0);
    }

    @Test
    public void whenArrayHasZeroesThenFindMaxSubarray() {
        MaxSubList maxSubList = new MaxSubList();
        int[] array = {0, 0, 0, 0, 0};
        MaxRange result = maxSubList.count(array);
        assertThat(result.start()).isEqualTo(0);
        assertThat(result.end()).isEqualTo(0);
    }
}