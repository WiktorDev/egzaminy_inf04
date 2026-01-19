package com.example.inf04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Kosc kosc1 = new Kosc();
        System.out.println(Kosc.instances);
        System.out.println(kosc1.drawn);
        System.out.println(kosc1.toText());
        System.out.println(kosc1.images[kosc1.resourceId]);

        System.out.println("Podaj liczbe 1..6");
        Kosc kosc2 = new Kosc(input.nextInt());
        System.out.println(Kosc.instances);
        System.out.println(kosc2.drawn);
        System.out.println(kosc2.toText());
        System.out.println(kosc2.images[kosc2.resourceId]);
    }
}