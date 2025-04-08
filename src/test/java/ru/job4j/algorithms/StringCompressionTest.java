package ru.job4j.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {

    private final StringCompression compressor = new StringCompression();

    @Test
    void whenStringHasAllUniqueCharacters_thenReturnSameCharacters() {
        assertEquals("abcd", compressor.compress("abcd"));
    }

    @Test
    void whenStringHasRepeatedCharacters_thenReturnCharacterWithCount() {
        String compressed = compressor.compress("aabbbcc");
        assertEquals(compressed, "a2b3c2");
    }

    @Test
    void whenStringIsEmpty_thenReturnEmptyString() {
        assertEquals("", compressor.compress(""));
    }

    @Test
    void whenStringHasOneCharacter_thenReturnSameCharacter() {
        assertEquals("a", compressor.compress("a"));
    }

    @Test
    void whenStringHasAllSameCharacter_thenReturnCharacterWithCount() {
        assertEquals("a5", compressor.compress("aaaaa"));
    }

    @Test
    void whenStringHasMixedCaseCharacters_thenTreatSeparately() {
        String compressed = compressor.compress("aAaaA");
        assertTrue(compressed.contains("a3A2"));
    }
}