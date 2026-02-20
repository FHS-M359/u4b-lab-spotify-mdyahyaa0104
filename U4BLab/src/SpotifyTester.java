import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SpotifyTester {
    public static void main(String[] args) throws IOException, FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        Playlist sortPlaylist = new Playlist();
        String file = "H:\\M359 YAHYAA\\u4b-lab-spotify-mdyahyaa0104\\U4BLab\\spotify_unique_years_artists.txt";

        final int first = 1;
        final int second = 2;
        final int third = 3;
        final int fourth = 4;
        final int fifth = 5;
        final int sixth = 6;
        final int seventh = 7;

        System.out.println("========= SPOTIFY MENU =========");

        while (true) {
            displayMenu();
            System.out.println("What do you want to do?");

            try {
                int response = scanner.nextInt();

                if(response == first) {
                    sortPlaylist.loadData(file);
                    sortPlaylist.sortArtistAZ();
                    displayPlaylist(sortPlaylist);
                    wait(2);
                } else if (response == second) {
                    sortPlaylist.loadData(file);
                    sortPlaylist.sortArtistZA();
                    displayPlaylist(sortPlaylist);
                    wait(2);
                } else if (response == third) {
                    sortPlaylist.loadData(file);
                    sortPlaylist.sortReleaseYearAscending();
                    displayPlaylist(sortPlaylist);
                    wait(2);
                } else if (response == fourth) {
                    sortPlaylist.loadData(file);
                    sortPlaylist.sortReleaseYearDescending();
                    displayPlaylist(sortPlaylist);
                    wait(2);
                } else if (response == fifth) {
                    System.out.println("What genre do you want to search for?");
                    scanner.nextLine();
                    String genre = scanner.nextLine();
                    try{
                        while(Integer.parseInt(genre) % 1 == 0){
                            System.out.println("Please enter a valid Genre: ");
                            genre = scanner.nextLine();
                        }
                    } catch(Exception ignored){}

                    sortPlaylist.loadData(file);
                    sortPlaylist.searchGenre(genre);
                    displayPlaylist(sortPlaylist);
                    wait(2);
                } else if (response == sixth) {
                    playlist.loadData(file);
                    displayPlaylist(playlist);
                    wait(2);
                } else if (response == seventh) {
                    break;
                } else{
                    System.out.println("Invalid Choice, Please pick a number between 1 - 7: \n");
                    // Wait a second before showing the menu again
                    wait(1);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice, Please choose a valid number. \n");
                wait(1);
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
                "5. Search by Genre \n" +
                "6. Display all Songs \n" +
                "7. Quit the Program \n"
        );

        System.out.println(display);
    }

    public static void wait(int time) throws InterruptedException {
        Thread.sleep(250);
        for(int i = time; i > 0; i--){
            System.out.println("Please wait " + i + " seconds...");
            Thread.sleep(1000);
        }
        System.out.println("\n");
    }
}
