package org.teachings.gpt;

import org.junit.jupiter.api.Test;
import org.teachings.gpt.random.DuplicateCharacters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepeaterTest {

    @Test
    public void testFindFirstNonRepeatingChar() {
        DuplicateCharacters duplicateCharacters = new DuplicateCharacters();
        assertEquals('c', duplicateCharacters.findFirst("abcba"));
        assertEquals(0, duplicateCharacters.findFirst("abba"));
        assertEquals('a', duplicateCharacters.findFirst("abcdef"));
    }

    @Test
    public void testFindFirstAllRepeatingChars() {
        DuplicateCharacters duplicateCharacters = new DuplicateCharacters();
        assertEquals(0, duplicateCharacters.findFirst("aabbcc"));
    }

    @Test
    public void testFindFirstEmptyString() {
        DuplicateCharacters duplicateCharacters = new DuplicateCharacters();
        assertEquals(0, duplicateCharacters.findFirst(""));
    }

    @Test
    public void testFindFirstNullString() {
        DuplicateCharacters duplicateCharacters = new DuplicateCharacters();
        assertEquals(0, duplicateCharacters.findFirst(null));
    }

    @Test
    public void testEmptyString() {
        DuplicateCharacters duplicateCharacters = new DuplicateCharacters();
        assertEquals(0, duplicateCharacters.findFirst(""));
    }

    @Test
    public void testSingleCharString() {
        DuplicateCharacters duplicateCharacters = new DuplicateCharacters();
        assertEquals('a', duplicateCharacters.findFirst("a"));
    }

    @Test
    public void testAllRepeatingChars() {
        DuplicateCharacters duplicateCharacters = new DuplicateCharacters();
        assertEquals(0, duplicateCharacters.findFirst("aaaa"));
    }
}
