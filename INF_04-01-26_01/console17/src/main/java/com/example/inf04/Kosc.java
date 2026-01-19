package com.example.inf04;

import java.util.Random;

public class Kosc {
    public static int instances = 0;
    public String[] images = {"kosc0.png", "kosc1.png", "kosc2.png", "kosc3.png",  "kosc4.png", "kosc5.png", "kosc6.png"};
    public int drawn;
    public int resourceId;
    public boolean isAvailable;

    public Kosc(int drawn) {
        if (drawn > 6 || drawn < 1) {
            this.drawn = 0;
            return;
        }
        this.drawn = drawn;
        this.resourceId = drawn;
        this.isAvailable = true;
        instances++;
    }

    public Kosc() {
        Random rand = new Random();
        int drawn = rand.nextInt(6) + 1;
        this.drawn = drawn;
        this.resourceId = drawn;
        this.isAvailable = true;
        instances++;
    }

    public void draw() {
        if (!this.isAvailable) return;
        Random rand = new Random();
        int drawn = rand.nextInt(6) + 1;
        this.drawn = drawn;
        this.resourceId = drawn;
    }

    public void disable() {
        this.isAvailable = false;
    }

    public String toText() {
        String[] texts = {"jeden", "dwa", "trzy", "cztery", "pięć", "sześć" };
        return texts[this.drawn-1];
    }
}
