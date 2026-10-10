import java.util.Arrays;

public class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String songTitle) {
        if (count < songs.length) {
            songs[count] = songTitle;
            count++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
    }
}