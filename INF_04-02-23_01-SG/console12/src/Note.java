/**
 * klasa:   Note
 * opis:    Klasa przechuje dane dotyczące notatki oraz liczbe wszystkich instancji tej klasy
 * pola:    count - statyczne pole które zlicza liczbe instancji tej klasy
 *          id - id notatki
 *          title - tytul notatki
 *          content - tresc notatki
 * autor:   00000000000
 */
public class Note {
    private static int count = 0;

    private int id;
    protected String title;
    protected String content;

    public Note(String title, String content) {
        count++;
        this.id = count;
        this.content = content;
        this.title = title;
    }

    public void display() {
        System.out.printf("%s %s%n", this.title, this.content);
    }

    public void debug() {
        System.out.printf("%d;%s;%s%n", this.id, this.title, this.content);
    }
}
