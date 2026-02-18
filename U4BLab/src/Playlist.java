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

    public ArrayList<Song> sortArtistAZ(){
        for(int i = 0; i < songs.size()-1; i++){
            int highIndex = i;

            for(int j = i + 1; j < songs.size(); j++){
                if(songs.get(j).getArtist().compareTo(songs.get(highIndex).getArtist()) < 0){
                    highIndex = j;
                }
            }

            songs.set(highIndex, songs.set(i, songs.get(highIndex)));
        }

    }

    public ArrayList<Song> sortArtistZA(){

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
