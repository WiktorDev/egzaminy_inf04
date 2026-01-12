import java.util.Scanner;

public class Main {
    private String pesel;

    public Main(String pesel) {
        this.pesel = pesel;
    }

    /**
     * nazwa metody:        gender
     * opis metody:         metoda sprawdza płeć na podstawie numeru pesel
     * parametry:           brak
     * zwracany typ i opis: char K - Mezczyzna, K - Kobieta
     * autor:               00000000000
     */
    public char gender() {
        int genderDigit = this.pesel.charAt(9) - '0';
        return genderDigit % 2 == 0 ? 'K' : 'M';
    }

    /**
     * nazwa metody:        validateChecksum
     * opis metody:         metoda sprawdza poprawnosc numeru pesel
     * parametry:           brak
     * zwracany typ i opis: boolean - zwraca wartosc logiczna z informacja o poprawnosci numeru pesel
     * autor:               00000000000
     */
    public boolean validateChecksum() {
        int[] weights = {1,3,7,9};

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (this.pesel.charAt(i) - '0') * weights[i % 4];
        }

        int checksum = (10 - (sum % 10)) % 10;
        return checksum == (this.pesel.charAt(10) - '0');
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Podaj numer PESEL: ");
//        String pesel = scanner.nextLine();

        Main main = new Main("55030101193");
        System.out.println("Płeć: " + main.gender());
        System.out.println("Pesel poprawny? " + main.validateChecksum());
    }
}