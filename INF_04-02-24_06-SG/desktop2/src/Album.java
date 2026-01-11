public class Album {
    private final String artist;
    private final String album;
    private final int songsNumber;
    private final int year;

    public void setDownloadNumber(int downloadNumber) {
        this.downloadNumber = downloadNumber;
    }

    private int downloadNumber;

    public Album(String artist, String album, int songsNumber, int year, int downloadNumber) {
        this.artist = artist;
        this.album = album;
        this.songsNumber = songsNumber;
        this.year = year;
        this.downloadNumber = downloadNumber;
    }

    public void display() {
        System.out.println(this.artist);
        System.out.println(this.album);
        System.out.println(this.songsNumber);
        System.out.println(this.year);
        System.out.println(this.downloadNumber);
        System.out.println();
    }

    public static Album fromFilePart(String[] parts) {
        return new Album(
                parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])
        );
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getSongsNumber() {
        return songsNumber;
    }

    public int getYear() {
        return year;
    }

    public int getDownloadNumber() {
        return downloadNumber;
    }
}
