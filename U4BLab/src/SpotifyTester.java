import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SpotifyTester {
    public static void main(String[] args) throws IOException, FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        // origin/sorted playlists
        Playlist playlist = new Playlist(new ArrayList<Song>());
        Playlist sortPlaylist = new Playlist(new ArrayList<Song>());
        // file path
        String file = "H:\\M359 YAHYAA\\u4b-lab-spotify-mdyahyaa0104\\U4BLab\\spotify_unique_years_artists.txt";

        // constant variables coordinating with choices to improve readability of code
        final int first = 1;
        final int second = 2;
        final int third = 3;
        final int fourth = 4;
        final int fifth = 5;
        final int sixth = 6;
        final int seventh = 7;

        System.out.println("========= SPOTIFY MENU =========");

        // loops repeatedly until the break statement is given
        while (true) {
            displayMenu();
            System.out.println("What do you want to do?");

            try {
                int response = scanner.nextInt();

                if(response == first) {
                    // load all data from the file
                    sortPlaylist.loadData(file);
                    // sort
                    sortPlaylist.sortArtistAZ();
                    // display
                    displayPlaylist(sortPlaylist);
                    // wait 3 seconds before showing the menu (enhancement)
                    wait(3);
                } else if (response == second) {
                    sortPlaylist.loadData(file);
                    sortPlaylist.sortArtistZA();
                    displayPlaylist(sortPlaylist);
                    wait(3);
                } else if (response == third) {
                    sortPlaylist.loadData(file);
                    sortPlaylist.sortReleaseYearAscending();
                    displayPlaylist(sortPlaylist);
                    wait(3);
                } else if (response == fourth) {
                    sortPlaylist.loadData(file);
                    sortPlaylist.sortReleaseYearDescending();
                    displayPlaylist(sortPlaylist);
                    wait(3);
                } else if (response == fifth) {
                    System.out.println("What genre do you want to search for?");
                    scanner.nextLine();
                    String genre = scanner.nextLine();
                    // try/catch block to check if the genre is an integer and prompts a valid string input if it's an int
                    try{
                        while(Integer.parseInt(genre) % 1 == 0){
                            System.out.println("Please enter a valid Genre: ");
                            genre = scanner.nextLine();
                        }
                    } catch(Exception ignored){}

                    sortPlaylist.loadData(file);
                    sortPlaylist.searchGenre(genre);
                    displayPlaylist(sortPlaylist);
                    wait(3);
                } else if (response == sixth) {
                    playlist.loadData(file);
                    displayPlaylist(playlist);
                    wait(3);
                } else if (response == seventh) {
                    // exit the loop
                    break;
                } else{
                    System.out.println("Invalid Choice, Please pick a choice between 1 - 7: \n");
                    wait(1);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice, Please choose a valid choice. \n");
                wait(1);
                scanner.nextLine();
            }
        }

    }


    /**
     * a static void method that intakes a playlist parameter and displays it in as a formatted string table
     * @param playlist a Playlist object
     */
    public static void displayPlaylist(Playlist playlist){
        System.out.println("\n" + String.format("%-25s %-25s %-30s %-15s %-15s", "Title", "Artist", "Album", "Release Year", "Genre"));
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println(playlist.toString());
    }

    /**
     * a static void method that displays the menu for SpotifyTester used to interact with the sorting mechanisms
     */
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

    /**
     * a static void method used to pause the program for an inputted number of seconds while displaying how much time is remaining.
     * this method also prevents any 'backlog'. (actions called while the program is 'waiting'
     * @param time # of seconds
     * @throws InterruptedException
     */
    public static void wait(int time) throws InterruptedException, IOException {
        // 250ms delay before countdown
        Thread.sleep(250);
        for(int i = time; i > 0; i--){
            System.out.println("Please wait " + i + " seconds...");
            Thread.sleep(1000);
        }

        //prevents backlog by ignoring all console inputs while the program is in wait
        while(System.in.available() > 0){
            System.in.read();
        }

        System.out.println("\n");
    }
}
