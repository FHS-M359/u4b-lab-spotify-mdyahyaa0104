public class Song {
    private String title, artist, album, genre;
    private int durationSeconds, releaseYear;

    public Song(String title, String artist, String album, int durationSeconds, int releaseYear, String genre){
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationSeconds = durationSeconds;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public String toString(){
        return (String.format("%-25s %-25s %-30s %-15s %-15s", title, artist, album, releaseYear, genre));
    }

    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public String getAlbum() {
        return album;
    }
    public int getDurationSeconds() {
        return durationSeconds;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public String getGenre() {
        return genre;
    }

}
