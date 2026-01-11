import java.util.Random;

public class Numbers {
    private final int length;
    private final int[] numbers;

    public Numbers(int length) {
        Random random = new Random();
        this.length = length;

        this.numbers = new int[length];
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(1, 1001);
            this.numbers[i] = number;
        }
    }

    /**
     * nazwa metody:        printNumbers
     * opis metody:         wyświetla wszystkie liczby z tablicy w formacie index: value
     * parametry:           brak
     * zwracany typ i opis: brak
     * autor:               00000000000
     */
    public void printNumbers() {
        for (int i = 0; i < this.length; i++) {
            System.out.printf("%d: %d%n", i, this.numbers[i]);
        }
    }

    /**
     * nazwa metody:        findFirst
     * opis metody:         wyszukuje pierwsze wystąpienie liczby z parametru
     * parametry:           number - szukana liczba
     * zwracany typ i opis: index znalezionej liczby lub -1 w przypadku braku odpowiedniej wartosci
     * autor:               00000000000
     */
    public int findFirst(int number) {
        for (int i = 0; i < this.length; i++) {
            if (this.numbers[i] == number) return i;
        }
        return -1;
    }

    /**
     * nazwa metody:        allOddNumbers
     * opis metody:         wyswietla wszystkie liczby nieparzyste
     * parametry:           brak
     * zwracany typ i opis: brak
     * autor:               00000000000
     */
    public int allOddNumbers() {
        int count = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.numbers[i] % 2 != 0) {
                System.out.println(this.numbers[i]);
                count++;
            }
        }
        return count;
    }

    /**
     * nazwa metody:        avg
     * opis metody:         liczy srednia artmetyczna wszystkich elementow tablicy
     * parametry:           brak
     * zwracany typ i opis: int - wyliczona srednia
     * autor:               00000000000
     */
    public int avg() {
        int sum = 0;
        for (int i = 0; i < this.length; i++) sum += this.numbers[i];
        return sum / this.length;
    }
}
