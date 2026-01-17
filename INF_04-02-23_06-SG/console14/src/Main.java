import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        System.out.println("Wylosowana tablica:");
        System.out.println(Arrays.toString(array));

        bubbleSort(array);

        System.out.println("Posortowana tablica:");
        System.out.println(Arrays.toString(array));
    }
}