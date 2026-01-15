import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Liczba zarejestrowanych osób to " + Osoba.instances);
        Osoba o1 = new Osoba();

        System.out.println("Podaj id: ");
        int id = scanner.nextInt();
        System.out.println("Podaj imie: ");
        String name = scanner.next();

        Osoba o2 = new Osoba(id, name);
        Osoba o3 = new Osoba(o2);

        o1.hi("Jan");
        o2.hi("Jan");
        o3.hi("Jan");

        System.out.println("Liczba zarejestrowanych osób to " + Osoba.instances);
    }
}