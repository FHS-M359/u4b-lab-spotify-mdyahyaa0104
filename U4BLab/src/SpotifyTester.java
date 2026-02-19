import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;


public class SpotifyTester {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Scanner file = new Scanner(new File("H:\\M359 YAHYAA\\u4b-lab-spotify-mdyahyaa0104\\U4BLab\\spotify_unique_years_artists.txt"));
        ArrayList<Song> songList = new ArrayList<>();

        final int first = 1;
        final int second = 2;
        final int third = 3;
        final int fourth = 4;
        final int fifth = 5;
        final int sixth = 6;
        final int seventh = 7;

        while(file.hasNextLine()){
            String[] line = file.nextLine().split(",");

            String title = line[0];
            String artist = line[1];
            String album = line[2];
            int durationSeconds = Integer.parseInt(line[3]);
            int releaseYear = Integer.parseInt(line[4]);
            String genre = line[5];

            songList.add(new Song(title, artist, album, durationSeconds, releaseYear, genre));
        }

        Playlist playlist = new Playlist(songList);

        while (true) {
            displayMenu();
            System.out.println("What is your pick?");

            try {
                int response = scanner.nextInt();

                if(response == first) {
                    Playlist AZSortedPlaylist = new Playlist(playlist.sortArtistAZ());

                    displayPlaylist(AZSortedPlaylist);
                } else if (response == second) {
                    Playlist ZASortedPlaylist = new Playlist(playlist.sortArtistZA());

                    displayPlaylist(ZASortedPlaylist);
                } else if (response == third) {
                    Playlist oldNewSortedPlaylist = new Playlist(playlist.sortReleaseYearAscending());

                    displayPlaylist(oldNewSortedPlaylist);
                } else if (response == fourth) {
                    Playlist newOldSortedPlaylist = new Playlist(playlist.sortReleaseYearDescending());

                    displayPlaylist(newOldSortedPlaylist);
                } else if (response == fifth) {
                    System.out.println("What genre do you want to sort by?");
                    scanner.nextLine();
                    String genre = scanner.nextLine();

                    Playlist genrePlaylist = new Playlist(playlist.sortGenre(genre));
                    displayPlaylist(genrePlaylist);

                } else if (response == sixth) {
                    displayPlaylist(playlist);
                } else if (response == seventh) {
                    break;
                } else{
                    System.out.println("Invalid Choice, Please pick a number between 1 - 7: \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice, Please choose a valid number. \n");
                scanner.nextLine();
            }
        }

    }


    public static void displayPlaylist(Playlist playlist){
        System.out.println("\n" + String.format("%-25s %-25s %-30s %-15s %-15s", "Title", "Artist", "Album", "Release Year", "Genre"));
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println(playlist.toString());
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
