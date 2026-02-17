import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class SpotifyTester {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        final int first = 1;
        final int second = 2;
        final int third = 3;
        final int fourth = 4;
        final int fifth = 5;
        final int sixth = 6;
        final int seventh = 7;

        while (true) {
            displayMenu();
            System.out.println("What is your pick?");

            int response = scanner.nextInt();
            try {
                if (scanner.nextInt() == first) {
                    System.out.println();
                }
                if (response == second) {

                }
                if (response == third) {

                }
                if (response == fourth) {

                }
                if (response == fifth) {

                }
                if (response == sixth) {
                    loadPlaylist();
                    displayMenu();
                }
                if (response == seventh) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Choice, Please pick a number between 1 - 7: ");
            }
        }

    }

    public static void loadPlaylist() throws IOException, FileNotFoundException{
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

        displayPlaylist(playlist);
    }

    public static void displayPlaylist(Playlist playlist){
        System.out.println(String.format("%-25s %-25s %-30s %-15s %-15s", "Title", "Artist", "Album", "Release Year", "Genre"));
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println(playlist.toString());
        displayMenu();
    }

    public static void displayMenu(){
        String display = "";

        display += (
                "1. Sort by Artist (A -> Z) \n" +
                "2. Sort by Artist (Z -> A) \n" +
                "3. Sort by Year (Old -> New) \n" +
                "4. Sort by Year (New -> Old) \n" +
                "5. Sort by Genre \n" +
                "6. Display all Songs \n" +
                "7. Quit the Program \n"
        );

        System.out.println(display);
    }
}
