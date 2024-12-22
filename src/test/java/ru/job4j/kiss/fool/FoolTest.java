package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoolTest {
    @Test
    void testFizzBuzzOutput() {
        assertEquals("FizzBuzz", Fool.getFizzBuzzOutput(15));
        assertEquals("FizzBuzz", Fool.getFizzBuzzOutput(30));
        assertEquals("Fizz", Fool.getFizzBuzzOutput(3));
        assertEquals("Fizz", Fool.getFizzBuzzOutput(9));
        assertEquals("Buzz", Fool.getFizzBuzzOutput(5));
        assertEquals("Buzz", Fool.getFizzBuzzOutput(10));
        assertEquals("1", Fool.getFizzBuzzOutput(1));
        assertEquals("2", Fool.getFizzBuzzOutput(2));
        assertEquals("4", Fool.getFizzBuzzOutput(4));
    }
}