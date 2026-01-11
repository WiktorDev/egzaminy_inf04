import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Album> albums = new ArrayList<>();

    /**
     * nazwa metody:    loadData
     * opis metody:     metoda wczytuje plik a nastepnie na podstawie danych tworzy obiekty klasy Album
     * parametry:       brak
     * zwracany typ:    brak
     * autor:           0000000000
     */
    public void loadData() {
        try {
            List<String> lines = Files.readAllLines(Path.of(Main.class.getResource("Data.txt").toURI()));
            int index = 0;
            for (String line : lines) {
                if (line.isEmpty()) this.albums.add(Album.fromFilePart(lines.subList(index-5, index).toArray(new String[0])));
                index++;
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * nazwa metody:    printData
     * opis metody:     metoda wyświetla w konsolu każdy rekord (korzytsa z metody display klasy Album)
     * parametry:       brak
     * zwracany typ:    brak
     * autor:           0000000000
     */
    public void printData() {
        this.albums.forEach(Album::display);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.loadData();
        main.printData();
    }
}