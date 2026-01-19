package com.example.inf04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KoscTest {
    @Test
    void drawShouldAlwaysReturnValueBetween1And6() {
        Kosc kosc = new Kosc();
        for (int i = 0; i < 10_000; i++) {
            kosc.draw();
            assertTrue(kosc.drawn >= 1 && kosc.drawn <= 6, "Wylosowano wartość spoza zakresu: " + kosc.drawn);
        }
    }

    @Test
    void drawnValueCannotBeChangedIfIsNotAvailable() {
        Kosc kosc = new Kosc();
        kosc.isAvailable = false;
        kosc.drawn = 4;
        kosc.draw();
        assertEquals(4, kosc.drawn);
    }
}