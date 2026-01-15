import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /**
     * nazwa funkcji:   find
     * argumenty:       needle - wartość do wyszukania w tablicy
     *                  haystack - tablica elementow do przeszukania
     * typ zwracany:    int, index odnalezionego elementu lub -1 w przypadku nie znalezienia
     * informacje:      algorytm wyszukiwania z wartownikiem
     * autor:           0000000000
     */
    public static int find(int needle, List<Integer> haystack) {
        haystack.add(needle);
        for (int i = 0; i < haystack.size(); i++) {
            if (haystack.get(i) == needle && i != haystack.size()-1) return i;
        }
        return -1;
    }

    /**
     * nazwa funkcji:   generateHaystack
     * argumenty:       length - wielkosc tablicy/liczba elementow do wstawienia
     * typ zwracany:    List<Integer>, lista wylosowanych liczb
     * informacje:      generuje tablie z pseudolosowymi elementami
     * autor:           0000000000
     */
    public static List<Integer> generateHaystack(int length) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(1, 101));
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> haystack = generateHaystack(50);

        System.out.println("Podaj element do wyszukania: ");
        int needle = scanner.nextInt();

        System.out.println(String.join(", ", haystack.stream().map(Object::toString).toList()));
        int found = find(needle, haystack);

        if (found == -1) System.out.println("Nie odnaleziono pasującego elementu w tablicy!");
        else System.out.println("Wartość odnaleziona pod inexem " + found);
    }
}