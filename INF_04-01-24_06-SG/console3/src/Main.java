import java.util.*;

public class Main {

    /**
     * nazwa metody:        generateNumbers
     * opis metody:         losuje liczby
     * parametry:           int count - liczba elementow
     * zwracany typ i opis: lista wylosowanych liczb (List<Integer>)
     * autor:               00000000000
     */
    public static List<Integer> generateNumbers(int count) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int number = random.nextInt(1, 6 + 1);
            list.add(number);
            System.out.printf("Kostka %d: %d%n", i+1, number);
        }
        return list;
    }

    /**
     * nazwa metody:        calculatePoints
     * opis metody:         zlicza punkty na podstawie wygenerowanych liczb
     * parametry:           lista wylosowanych liczb
     * zwracany typ i opis: liczba punktów
     * autor:               00000000000
     */
    public static int calculatePoints(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        numbers.forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));

        int points = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) continue;
            points += map.get(key)*key;
        }
        return points;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int count = 0;
            do {
                System.out.println("Ile kostek chcesz rzucić? (3-10)");
                count = scanner.nextInt();
            } while (count <= 3 || count >= 10);

            List<Integer> list = generateNumbers(count);
            int points = calculatePoints(list);

            System.out.printf("Liczba uzyskanych punktów: %d%n", points);
            System.out.println("Jeszcze raz? (t/n)");
            char nextRound = scanner.next().charAt(0);
            if (nextRound != 't') break;
        }
    }
}