import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final List<List<Integer>> items = new ArrayList<>();

    /**
     * nazwa metody:        generateNumbers
     * opis funkcji:        metoda generuje zestawy 6-liczb
     * parametry:           count - liczba zestawów
     * zwracany typ i opis: brak
     * autor:               00000000000
     */
    private void generateNumbers(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            List<Integer> list = new ArrayList<>();
            while (list.size() != 6) {
                int number = random.nextInt(1, 49+1);
                if (list.contains(number)) continue;
                list.add(number);
            }
            System.out.printf("Losowanie %d: %s%n", i+1, list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            this.items.add(list);
        }
    }

    /**
     * nazwa metody:        countNumberRepetitions
     * opis funkcji:        metoda zlicza powtórzenia liczb w zestawach
     * parametry:           brak
     * zwracany typ i opis: brak
     * autor:               00000000000
     */
    private void countNumberRepetitions() {
        List<Integer> flatten = this.items.stream().flatMap(List::stream).sorted().toList();
        Map<Integer, Integer> map = new TreeMap<>();
        flatten.forEach(it -> map.put(it, map.getOrDefault(it, 0) + 1));
        map.forEach((k, v) -> System.out.printf("Wystąpienia liczby %d: %d%n", k, v));
    }

    public static void main(String[] args) {
        System.out.println("Ile wygenerować losowań?");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        System.out.println("Zestawy wylosowanych liczb:");

        Main main = new Main();
        main.generateNumbers(count);
        main.countNumberRepetitions();
    }
}