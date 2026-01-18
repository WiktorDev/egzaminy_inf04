public class VacuumCleaner extends Device {
    private boolean isRunning = false;

    /**
     * nazwa:               on
     * opis:                włącza odkurzacz jeżeli jest wyłączony
     * parametry:           brak
     * zwracany typ i opis: void
     * autor:               00000000000
     */
    public void on() {
        if (this.isRunning) return;
        this.isRunning = true;
        this.showMessage("Odkurzacz włączono");
    }

    /**
     * nazwa:               off
     * opis:                wyłącza odkurzacz jeżeli jest włączony
     * parametry:           brak
     * zwracany typ i opis: void
     * autor:               00000000000
     */
    public void off() {
        if (!this.isRunning) return;
        this.isRunning = false;
        this.showMessage("Odkurzacz wyłączono");
    }
}
