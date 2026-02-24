import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private ArrayList<Song> songs;

    public Playlist(ArrayList<Song> songs) {
        this.songs = songs;
    }

    /**
     * a void method of the Playlist class that loads a playlist Arraylist with the info provided in the txt file
     * data should be in this format: title,artist,album,durationSeconds,releaseYear,genre
     * @param filePath the file path of the txt file you wish to load
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void loadData(String filePath) throws IOException, FileNotFoundException {
            Scanner file = new Scanner(new File(filePath));
            songs.removeAll(songs);
            while (file.hasNextLine()) {
                String[] line = file.nextLine().split(",");

                String title = line[0];
                String artist = line[1];
                String album = line[2];
                int durationSeconds = Integer.parseInt(line[3]);
                int releaseYear = Integer.parseInt(line[4]);
                String genre = line[5];

                songs.add(new Song(title, artist, album, durationSeconds, releaseYear, genre));
        }
    }

    /**
     * a String method that returns the ArrayList in the playList class as a formatted string
     * to be used in the displayPlaylist method of the SpotifyTester class
     * @return a formatted string
     */
    public String toString(){
        String output = "";
        for (Song song : songs) {
            output += (song.toString()) + "\n";

        }

        return output;
    }

    /**
     * a method of the Playlist class that sorts an ArrayList with song objects by their artists alphabetically
     */
    public void sortArtistAZ() {
        for(int i = 0; i < songs.size() - 1; i++) {
            int highIndex = i;

            for(int j = i + 1; j < songs.size(); j++) {
                if(songs.get(j).getArtist().compareToIgnoreCase(songs.get(highIndex).getArtist()) < 0) {
                    highIndex = j;
                }
            }

            songs.set(highIndex, songs.set(i, songs.get(highIndex)));
        }
    }

    /**
     * a method of the Playlist class that sorts an ArrayList with song objects by their artists reverse alphabetically
     */
    public void sortArtistZA(){
        for(int i = 0; i < songs.size() - 1; i++) {
            int lowIndex = i;

            for(int j = i + 1; j < songs.size(); j++) {
                if(songs.get(j).getArtist().compareToIgnoreCase(songs.get(lowIndex).getArtist()) > 0) {
                    lowIndex = j;
                }
            }

            songs.set(lowIndex, songs.set(i, songs.get(lowIndex)));
        }
    }

    /**
     * a method of the Playlist class that sorts an ArrayList with song objects by their release year in ascending order
     */
    public void sortReleaseYearAscending(){
        for (int i = 1; i < songs.size(); i++) {
            Song current = songs.get(i);
            int j = i - 1;

            while (j >= 0 && songs.get(j).getReleaseYear() > current.getReleaseYear()) {
                songs.set(j + 1, songs.get(j));
                j--;
            }

            songs.set(j + 1, current);
        }
    }

    /**
     * a method of the Playlist class that sorts an ArrayList with song objects by their release year in descending order
     */
    public void sortReleaseYearDescending(){
        for (int i = 1; i < songs.size(); i++) {
            Song current = songs.get(i);
            int j = i - 1;

            while (j >= 0 && songs.get(j).getReleaseYear() < current.getReleaseYear()) {
                songs.set(j + 1, songs.get(j));
                j--;
            }

            songs.set(j + 1, current);
        }
    }

    /**
     * a method of the Playlist class that searches the Playlist ArrayList for the specific genre
     * @param genre the genre which is being searched
     */
    public void searchGenre(String genre){
        ArrayList<Song> newList = new ArrayList<>();

        for(Song song: songs){
            if(song.getGenre().equalsIgnoreCase(genre)){
                newList.add(song);
            }
        }

        songs = newList;
    }
}
