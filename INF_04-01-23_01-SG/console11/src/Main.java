import java.util.Scanner;

public class Main {
    /**
     * nazwa funkcji:       NWD
     * opis funkcji:        znajduje najwiekszy wspolny dzielnik
     * parametry:           a - pierwsza liczba
     *                      b - druga liczba
     * zwracany typ i opis: int, najwiekszy wspolny dzielnik liczb a i b
     * autor:               00000000000
     */
    public static int NWD(int a, int b) {
        while (a != b) {
            if (a > b) a = a-b;
            else b = b-a;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbe a: ");
        int a = scanner.nextInt();
        System.out.print("Podaj liczbe b: ");
        int b = scanner.nextInt();

        System.out.println("Największy współnu dzielnik: " + NWD(a, b));
    }
}