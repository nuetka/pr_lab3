import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class Track {
    private String name;
    private String genre;
    private int duration;

    public Track() {
        this.name = "";
        this.genre = "";
        this.duration = 0;

    }

    public Track(String name) {
        this.name = name;
        this.genre = "";
        this.duration = 0;
    }

    public Track(String name, String genre, int duration) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static List<Track> findTracksByGenre(List<Track> tracks, String genre) {
        List<Track> result = new ArrayList<>();
        for (Track track : tracks) {
            if (track.getGenre().equals(genre)) {
                result.add(track);
            }
        }
        return result;
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter track name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter track genre: ");
        this.genre = scanner.nextLine();

        System.out.print("Enter track duration (in seconds): ");
        this.duration = scanner.nextInt();
    }

    public void printToConsole() {
        System.out.println("Track Name: " + name);
        System.out.println("Genre: " + genre);
        System.out.println("Duration: " + duration + " seconds");
    }

}

class Album {
    private String name;
    private int year;
    private String artist;
    private List<Track> tracks;

    public Album() {
        name = "";
        year = 0;
        artist = "";
        tracks = new ArrayList<>();
    }

    public Album(String name, int year, String artist, List<Track> tracks) {
        this.name = name;
        this.year = year;
        this.artist = artist;
        this.tracks = new ArrayList<>(tracks);
    }

    public Album(String name) {
        this.name = name;
        year = 0;
        artist = "";
        tracks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return new ArrayList<>(tracks);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = new ArrayList<>(tracks);
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter album name: ");
        String name = scanner.nextLine();
        setName(name);

        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        setYear(year);
        scanner.nextLine(); 

        System.out.print("Enter artist: ");
        String artist = scanner.nextLine();
        setArtist(artist);

        System.out.print("Enter track count: ");
        int trackCount = scanner.nextInt();
        scanner.nextLine(); 

        List<Track> tracks = new ArrayList<>();
        for (int i = 0; i < trackCount; i++) {
            System.out.println("Track num " + (i + 1) + ":");
            System.out.print("  Name: ");
            String trackName = scanner.nextLine();
            System.out.print("  Genre: ");
            String genre = scanner.nextLine();
            System.out.print("  Duration: ");
            int duration = scanner.nextInt();
            scanner.nextLine(); 

            Track track = new Track(trackName, genre, duration);
            tracks.add(track);
        }

        setTracks(tracks);
    }

    public void printToConsole() {
        System.out.println("Album: " + name);
        System.out.println("Year: " + year);
        System.out.println("Artist: " + artist);
        System.out.println("Tracks:");
        for (Track track : tracks) {
            System.out.println(track.getName());
        }
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void removeTrack(String trackName) {
        tracks.removeIf(track -> track.getName().equals(trackName));
    }

    public static List<Album> findAlbumsByYear(List<Album> albums, int year) {
        List<Album> result = new ArrayList<>();
        for (Album album : albums) {
            if (album.getYear() == year) {
                result.add(album);
            }
        }
        return result;
    }
}

class Playlist {
    private String name;
    private List<Track> tracks;

    public Playlist() {
        name = "";
        tracks = new ArrayList<Track>();
    }

    public Playlist(String name, List<Track> tracks) {
        this.name = name;
        this.tracks = new ArrayList<Track>(tracks);
    }

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<Track>();
    }

    public String getName() {
        return name;
    }

    public List<Track> getTracks() {
        return new ArrayList<Track>(tracks);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = new ArrayList<Track>(tracks);
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя плейлиста: ");
        String name1 = scanner.nextLine();
        setName(name1);

        System.out.print("Enter track count: ");
        int trackCount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<Track> tracks = new ArrayList<>();
        for (int i = 0; i < trackCount; i++) {
            System.out.println("Track num " + (i + 1) + ":");
            System.out.print("  Name: ");
            String trackName = scanner.nextLine();
            System.out.print("  Genre: ");
            String genre = scanner.nextLine();
            System.out.print("  Duration: ");
            int duration = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Track track = new Track(trackName, genre, duration);
            tracks.add(track);
        }

        setTracks(tracks);
    }

    public void printToConsole() {
        System.out.println("Playlist: " + name);
        System.out.println("Tracks:");
        for (Track track : tracks) {
            System.out.println(track.getName());
        }
    }
}

class Artist {
    private String name;
    private List<Album> albums;

    public Artist() {
        name = "";
        albums = new ArrayList<>();
    }

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = new ArrayList<>(albums);
    }

    public Artist(String name) {
        this.name = name;
        albums = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return new ArrayList<>(albums);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = new ArrayList<>(albums);
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the artist's name: ");
        name = scanner.nextLine();

        System.out.print("Enter the number of albums: ");
        int numAlbums = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numAlbums; i++) {
            Album album = new Album();
            album.readFromConsole();
            albums.add(album);
        }
    }

    public void printToConsole() {
        System.out.println("Artist: " + name);
        System.out.println("Albums:");
        for (Album album : albums) {
            System.out.println(album.getName());
        }
    }
}

class Library {
    private List<Album> albums;
    private List<Playlist> playlists;

    public Library() {
        albums = new ArrayList<>();
        playlists = new ArrayList<>();
    }

    public Library(List<Album> albums, List<Playlist> playlists) {
        this.albums = albums;
        this.playlists = playlists;
    }

    public Library(List<Album> albums) {
        this.albums = albums;
        playlists = new ArrayList<>();
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of albums: ");
        int numAlbums = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numAlbums; i++) {
            Album album = new Album();
            album.readFromConsole();
            albums.add(album);
        }

        System.out.print("Enter the number of playlists: ");
        int numPlaylists = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numPlaylists; i++) {
            Playlist playlist = new Playlist();
            playlist.readFromConsole();
            playlists.add(playlist);
        }
    }

    public void printToConsole() {
        System.out.println("Albums:");
        for (Album album : albums) {
            System.out.println(album.getName());
        }

        System.out.println("Playlists:");
        for (Playlist playlist : playlists) {
            System.out.println(playlist.getName());
        }
    }


}


public class Main {
    public static void main(String[] args) {

        Track track1 = new Track("Track1", "Genre1", 180);
        Track track2 = new Track("Track2", "Genre2", 190);
        Track track3 = new Track("Track3", "Genre3", 280);

        Track track4 = new Track();

        System.out.println("Entering track information from the console\n");
        track4.readFromConsole();

        Track track5 = new Track("Track5");

        List<Track> tracks = new ArrayList<>();

        // Добавляем в список уже созданные треки
        tracks.add(track1);
        tracks.add(track2);

        // Добавляем трек, который был считан с консоли
        tracks.add(track4);

        // Добавляем трек, созданный с помощью конструктора с одним аргументом
        tracks.add(track5);

        System.out.println("\nTrack array\n");
        for (Track tr : tracks) {
            tr.printToConsole();
            System.out.println("\n");
        }

        List<Track> tracksWithGenre2 = Track.findTracksByGenre(tracks, "Genre2");
        System.out.println("All tracks with genre 2\n");
        for (Track track : tracksWithGenre2) {
            track.printToConsole();
            System.out.println("\n");
        }

        System.out.println("Input album-info from console\n");
        Album album2 = new Album();
        album2.readFromConsole();
        System.out.println("Album filled in from the console\n");
        album2.printToConsole();

        Album album1 = new Album("Album1", 2022, "Artist1",tracks);
        System.out.println("\nAlbum1\n");
        album1.printToConsole();

        System.out.println("Adding Track3 and removing Track2 from the first album\n");
        album1.addTrack(track3);
        album1.removeTrack("Track2");
        album1.printToConsole();

        System.out.println("\nAlbum with 2022 release year \n");

        List<Album> albums = new ArrayList<>();

        albums.add(album1);
        albums.add(album2);

        List<Album> albums2022 = Album.findAlbumsByYear(albums,2022);
        for (Album a : albums2022) {
            a.printToConsole();
            System.out.println("\n");
        }

        Playlist playlist = new Playlist("Playlist1",tracks);
        Playlist playlist1 = new Playlist();
        System.out.println("\nInput playlist info from console \n");
        playlist1.readFromConsole();
        System.out.println("\nPlaylist filled in from the console \n");
        playlist1.printToConsole();

        List<Playlist> playlists = new ArrayList<>();
        playlists.add(playlist);
        playlists.add(playlist1);

        Library library = new Library(albums, playlists);
        System.out.println("\nLibrary \n");
        library.printToConsole();

        System.out.println("\nAfter adding the album to the library \n");
        Album albumNew = new Album("AlbumNew", 3333, "Artist666",tracks);
        library.addAlbum(albumNew);
        library.printToConsole();

    }
}
