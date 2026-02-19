import java.util.ArrayList;

public class Playlist {
    private ArrayList<Song> songs;


    public Playlist(ArrayList<Song> songs){
        this.songs = songs;
    }

    public String toString(){
        String output = "";
        for (Song song : songs) {
            output += (song.toString()) + "\n";

        }

        return output;
    }

    public ArrayList<Song> sortArtistAZ() {
        ArrayList<Song> sortedList = new ArrayList<>(songs);

        for(int i = 0; i < sortedList.size() - 1; i++) {
            int highIndex = i;

            for(int j = i + 1; j < sortedList.size(); j++) {
                if(sortedList.get(j).getArtist().compareToIgnoreCase(sortedList.get(highIndex).getArtist()) < 0) {
                    highIndex = j;
                }
            }

            sortedList.set(highIndex, sortedList.set(i, sortedList.get(highIndex)));
        }

        return sortedList;
    }

    public ArrayList<Song> sortArtistZA(){
        ArrayList<Song> sortedList = new ArrayList<>(songs);

        for(int i = 0; i < sortedList.size() - 1; i++) {
            int lowIndex = i;

            for(int j = i + 1; j < sortedList.size(); j++) {
                if(sortedList.get(j).getArtist().compareToIgnoreCase(sortedList.get(lowIndex).getArtist()) > 0) {
                    lowIndex = j;
                }
            }

            sortedList.set(lowIndex, sortedList.set(i, sortedList.get(lowIndex)));
        }

        return sortedList;
    }

    public ArrayList<Song> sortReleaseYearAscending(){
        ArrayList<Song> sortedList = new ArrayList<>(songs);

        for (int i = 1; i < sortedList.size(); i++) {
            Song current = sortedList.get(i);
            int j = i - 1;

            while (j >= 0 && sortedList.get(j).getReleaseYear() > current.getReleaseYear()) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }

            sortedList.set(j + 1, current);
        }

        return sortedList;
    }
    public ArrayList<Song> sortReleaseYearDescending(){
        ArrayList<Song> sortedList = new ArrayList<>(songs);

        for (int i = 1; i < sortedList.size(); i++) {
            Song current = sortedList.get(i);
            int j = i - 1;

            while (j >= 0 && sortedList.get(j).getReleaseYear() < current.getReleaseYear()) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }

            sortedList.set(j + 1, current);
        }

        return sortedList;
    }

    public ArrayList<Song> sortGenre(String genre){
        ArrayList<Song> newList = new ArrayList<>();

        for(Song song: songs){
            if(song.getGenre().equalsIgnoreCase(genre)){
                newList.add(song);
            }
        }

        return newList;
    }

//    public ArrayList<Song> sortArtist(String artist){
//
//    }
}
