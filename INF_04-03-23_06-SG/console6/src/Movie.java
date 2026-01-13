/**
 * nazwa klasy:     Movie
 * pola:            title - tytuł filmu
 *                  rentalsCount - liczba wypożyczeń filmu
 * metody:          getTitle, String - zwraca tytuł filmu z pola title
 *                  setTitle, void - ustawia tytuł filmu (pole title)
 *                  getRentalsCount, int - zwraca liczbe wypożyczeń filmu
 *                  increment, void - zwieksza liczbe wypozyczen (pole rentalsCount) o jeden
 * informacje:      brak
 * autor:           00000000000
 */
public class Movie {
    protected String title = "";
    protected int rentalsCount = 0;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRentalsCount() {
        return this.rentalsCount;
    }

    public void increment() {
        this.rentalsCount++;
    }
}
