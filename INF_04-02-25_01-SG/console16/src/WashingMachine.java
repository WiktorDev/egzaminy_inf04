public class WashingMachine extends Device {
    private int program = 0;

    /**
     * nazwa:               setProgram
     * opis:                ustawia numer programu pralki (1..12)
     * parametry:           programNumber - numer programu pralki (1..12)
     * zwracany typ i opis: (int) ustawiony program
     * autor:               00000000000
     */
    public int setProgram(int programNumber) {
        if (programNumber < 1 || programNumber > 12) this.program = 0;
        else this.program = programNumber;
        return this.program;
    }
}
