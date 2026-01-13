import java.util.Scanner;

public class Main {
    public String encrypt(String plainText, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            if (c >= 'a' && (int)c <= 'z') encrypted.append((char) ('a' + (c - 'a' + key) % 26));
            else encrypted.append(c);
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tekst do szyfrowania:");
        String plainText = scanner.nextLine();
        System.out.println("Podaj klucz do szyfrowania:");
        int key = scanner.nextInt();

        Main m = new Main();
        System.out.println(m.encrypt(plainText, key));
    }
}