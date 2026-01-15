import java.util.Scanner;

public class Main {
    private int[] array = {1,6,2,4,5,9,0,1,12,5};

    /**
     * nazwa metody:        initArray
     * parametry wejścia:   brak
     * wartość zwracana:    brak
     * autor:               00000000000
     */
    public void initArray() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.array.length; i++) {
            System.out.print("Podaj liczbe " + i + ": ");
            this.array[i] = sc.nextInt();
        }
    }

    /**
     * nazwa metody:        sort
     * parametry wejścia:   brak
     * wartość zwracana:    brak
     * autor:               00000000000
     */
    public void sort() {
        for (int i = 0; i < this.array.length - 1; i++) {
            int maxIndex = this.max(i, this.array.length - 1);
            int temp = this.array[i];
            this.array[i] = this.array[maxIndex];
            this.array[maxIndex] = temp;
        }
    }

    /**
     * nazwa metody:        max
     * parametry wejścia:   start - index od którego ma wyszukiwać
     *                      end - index do którego ma wyszukiwać
     * wartość zwracana:    index największego elementu z przedziału
     * autor:               00000000000
     */
    private int max(int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (this.array[i] > this.array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.initArray();
        System.out.println("Posortowana tablica:");
        main.sort();
        for (int i = 0; i < main.array.length; i++) {
            System.out.print(main.array[i] + ", ");
        }
    }
}