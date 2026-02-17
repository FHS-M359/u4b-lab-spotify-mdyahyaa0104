import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class SpotifyTester {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner scan = new Scanner(new File("H:\\M359 YAHYAA\\u4b-lab-spotify-mdyahyaa0104\\U4BLab\\spotify_unique_years_artists.txt"));
        ArrayList<Song> songList = new ArrayList<>();

        while(scan.hasNextLine()){
            String[] line = scan.nextLine().split(",");

            String title = line[0];
            String artist = line[1];
            String album = line[2];
            int durationSeconds = Integer.parseInt(line[3]);
            int releaseYear = Integer.parseInt(line[4]);
            String genre = line[5];

            songList.add(new Song(title, artist, album, durationSeconds, releaseYear, genre));
        }

        Playlist playlist = new Playlist(songList);

        displayList(playlist);
    }

    public static void displayList(Playlist playlist){
        System.out.println(String.format("%-25s %-25s %-30s %-15s %-15s", "Title", "Artist", "Album", "Release Year", "Genre"));
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println(playlist.toString());
    }
}
