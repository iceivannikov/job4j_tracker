package ru.job4j.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {

    private final StringCompression compressor = new StringCompression();

    @Test
    void whenStringHasAllUniqueCharactersThenReturnSameCharacters() {
        assertEquals("abcd", compressor.compress("abcd"));
    }

    @Test
    void whenStringHasRepeatedCharactersThenReturnCharacterWithCount() {
        String compressed = compressor.compress("aabbbcc");
        assertEquals(compressed, "a2b3c2");
    }

    @Test
    void whenStringIsEmptyThenReturnEmptyString() {
        assertEquals("", compressor.compress(""));
    }

    @Test
    void whenStringHasOneCharacterThenReturnSameCharacter() {
        assertEquals("a", compressor.compress("a"));
    }

    @Test
    void whenStringHasAllSameCharacterThenReturnCharacterWithCount() {
        assertEquals("a5", compressor.compress("aaaaa"));
    }

    @Test
    void whenStringHasMixedCaseCharactersThenTreatSeparately() {
        String compressed = compressor.compress("aAaaA");
        assertTrue(compressed.contains("a3A2"));
    }
}