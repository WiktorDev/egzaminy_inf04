public class Main {
    public static void main(String[] args) {
        Numbers numbers = new Numbers(21);

        System.out.println("Wszystkie wylosowane liczby: ");
        numbers.printNumbers();

        int found = numbers.findFirst(12);
        if (found != -1) {
            System.out.printf("Znaleziono liczbe 12 pod indexem %d", found);
        }

        System.out.println("Liczby nieparzyste:");
        int oddCount = numbers.allOddNumbers();
        System.out.println("Razem nieparzystych: " + oddCount);

        System.out.println("Średnia wszystkich elementów: " + numbers.avg());
    }
}