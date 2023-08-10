import java.util.*;

public class RecentPlayList {
	// To Store the max songs
	int capacity;
	// String KeyType: User and Linked List stores songs played by the particular
	// user
	Map<String, LinkedList<String>> store;

	public RecentPlayList(int capacity) {
		this.capacity = capacity;
		this.store = new HashMap<>();
	}

	// To add and remove songs from the playlist
	public void Song(String user, String song) {

		// adds songs to the playlist
		store.computeIfAbsent(user, k -> new LinkedList<>()).add(song);

		// Enters loop only if songs in the playlist are greater than count 3
		if (store.get(user).size() > capacity) {

			// removeFirst() is used tO Remove the first Song from the playlist
			store.get(user).removeFirst();
		}
	}

	// Returns the Playlist of the user
	public List<String> GetRecentlyPlayedSong(String user) {
		return store.getOrDefault(user, new LinkedList<>());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecentPlayList playlist = new RecentPlayList(3);
		playlist.Song("user1", "S1");
		playlist.Song("user1", "S2");
		playlist.Song("user1", "S3");

		System.out.print("User1 playlist                          ");
		System.out.println(playlist.GetRecentlyPlayedSong("user1"));
		
		playlist.Song("user1", "S4");
		System.out.print("User1 playlist when S4 song is played   ");
		System.out.println(playlist.GetRecentlyPlayedSong("user1"));
		
		playlist.Song("user1", "S2");
		System.out.print("User1 playlist when S2 song is played   ");
		System.out.println(playlist.GetRecentlyPlayedSong("user1"));
		
		playlist.Song("user1", "S1");
		System.out.print("User1 playlist when S1 song is played   ");
		System.out.println(playlist.GetRecentlyPlayedSong("user1"));

	}

}