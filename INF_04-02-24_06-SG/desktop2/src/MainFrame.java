import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private JPanel contentPane;
    private JLabel image1;
    private JLabel image2;
    private JButton previousButton;
    private JButton nextButton;
    private JButton downloadButton;
    private JLabel albumArtist;
    private JLabel albumName;
    private JLabel albumYear;
    private JLabel albumSongsNumber;
    private JLabel albumDownloadCount;

    private final List<Album> albums = new ArrayList<>();
    private int currentAlbumIndex;

    public MainFrame() {
        this.loadData();
        this.changeAlbum(0);

        setTitle("MojeDźwięki, Wykonał 00000000000");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setVisible(true);
        pack();
        setResizable(false);

        nextButton.addActionListener(e -> {
            int index = this.currentAlbumIndex + 1;
            if (index > this.albums.size()-1) index = 0;
            this.changeAlbum(index);
        });
        previousButton.addActionListener(e -> {
            int index = this.currentAlbumIndex - 1;
            if (index < 0) index = this.albums.size()-1;
            this.changeAlbum(index);
        });
        downloadButton.addActionListener(e -> {
            Album album = this.albums.get(currentAlbumIndex);
            album.setDownloadNumber(album.getDownloadNumber()+1);
            this.changeAlbum(currentAlbumIndex);
        });
    }

    /**
     * nazwa metody:    changeAlbum
     * opis metody:     metoda zmieniająca aktualnie wyswietlany album
     * parametry:       int index - index albumu ktory ma sie wyswietlac
     * zwracany typ:    brak
     * autor:           0000000000
     */
    private void changeAlbum(int index) {
        this.currentAlbumIndex = index;
        Album album = this.albums.get(index);
        this.albumArtist.setText(album.getArtist());
        this.albumName.setText(album.getAlbum());
        this.albumYear.setText(String.valueOf(album.getYear()));
        this.albumSongsNumber.setText(String.format("%d utworów", album.getSongsNumber()));
        this.albumDownloadCount.setText(String.valueOf(album.getDownloadNumber()));
    }

    /**
     * nazwa metody:    loadData
     * opis metody:     metoda wczytuje plik a nastepnie na podstawie danych tworzy obiekty klasy Album
     * parametry:       brak
     * zwracany typ:    brak
     * autor:           0000000000
     */
    private void loadData() {
        try {
            List<String> lines = Files.readAllLines(Path.of(MainFrame.class.getResource("Data.txt").toURI()));
            int index = 0;
            for (String line : lines) {
                if (line.isEmpty()) this.albums.add(Album.fromFilePart(lines.subList(index-5, index).toArray(new String[0])));
                index++;
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
