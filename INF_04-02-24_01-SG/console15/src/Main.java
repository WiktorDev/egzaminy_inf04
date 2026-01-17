import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj tekst: ");
        String text = input.nextLine();
        System.out.println("Liczba samogłosek: " + StringUtils.vowelsCount(text));
        System.out.println("Tekst bez duplikatów: " + StringUtils.removeRepetitions(text));
    }
}