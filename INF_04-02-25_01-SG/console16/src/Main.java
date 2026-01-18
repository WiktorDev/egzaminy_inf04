import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        WashingMachine washingMachine = new WashingMachine();
        System.out.println("Podaj numer prania 1..12");
        int program = washingMachine.setProgram(input.nextInt());

        if (program == 0) washingMachine.showMessage("Podano niepoprawny numer programu");
        else washingMachine.showMessage("Program został ustawiony");

        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.on();
        vacuumCleaner.on();
        vacuumCleaner.on();
        vacuumCleaner.showMessage("Odkurzacz wyładował się");
        vacuumCleaner.off();
    }
}