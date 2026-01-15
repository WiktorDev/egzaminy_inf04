public class Osoba {
    private int id;
    private String name;

    public static int instances = 0;

    public Osoba() {
        this.id = 0;
        this.name = "";
        instances++;
    }

    public Osoba(int id, String name) {
        this.id = id;
        this.name = name;
        instances++;
    }

    public Osoba(Osoba o) {
        this.id = o.id;
        this.name = o.name;
        instances++;
    }

    public void hi(String arg) {
        if (this.name.isEmpty()) {
            System.out.println("Brak danych!");
            return;
        }
        System.out.printf("Cześć %s, mam na imię %s%n", arg, this.name);
    }
}
