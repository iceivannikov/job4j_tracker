package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    public void whenNumberMinusOneThenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Factorial().calc(-1));
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void whenNumberThreeThenSix() {
        Factorial factorial = new Factorial();
        int number = 3;
        int expected = 6;
        factorial.calc(number);
        int actual = factorial.calc(number);
        assertThat(actual).isEqualTo(expected);
    }
}