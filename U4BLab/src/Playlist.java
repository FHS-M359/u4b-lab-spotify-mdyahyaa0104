import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private ArrayList<Song> songs = new ArrayList<>();

    public Playlist() {}

    public void loadData() throws IOException, FileNotFoundException {
            Scanner file = new Scanner(new File("H:\\M359 YAHYAA\\u4b-lab-spotify-mdyahyaa0104\\U4BLab\\spotify_unique_years_artists.txt"));
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

    public String toString(){
        String output = "";
        for (Song song : songs) {
            output += (song.toString()) + "\n";

        }

        return output;
    }

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

    public void sortGenre(String genre){
        ArrayList<Song> newList = new ArrayList<>();

        for(Song song: songs){
            if(song.getGenre().equalsIgnoreCase(genre)){
                newList.add(song);
            }
        }

        songs = newList;
    }
}
