package com.example.inf04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;

    @BeforeEach
    void setUp() {
        this.main = new Main();
    }

    @Test
    void positiveKeyShorterThanAlphabetLength() {
        String encrypted = this.main.encrypt("abc", 3);
        assertEquals("def", encrypted);
    }

    @Test
    void lettersAndKeyOutOfAlphabet() {
        String encrypted = this.main.encrypt("xyz", 3);
        assertEquals("abc", encrypted);
    }

    @Test
    void encryptWithNegativeKey() {
        String encrypted = this.main.encrypt("def", -3);
        assertEquals("abc", encrypted);
    }

    @Test
    void keyLargerThanAlphabetLength() {
        String encrypted = this.main.encrypt("abc", 29);
        assertEquals("def", encrypted);
    }

    @Test
    void spaceInPlainText() {
        String encrypted = this.main.encrypt("ab cd", 2);
        assertEquals("cd ef", encrypted);
    }
}