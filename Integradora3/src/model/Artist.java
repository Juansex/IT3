package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**Is the class that register the class artist with the stiplated parameters.
 * 
*/
public class Artist extends Producer {
	
	private ArrayList<Song> songs;
	

	public Artist(String nickname, String id, LocalDate vinculated) {
		super(nickname, id, vinculated);
		
		songs = new ArrayList<Song>();
	}
	
	public boolean addSong(Song song) {
		songs.add(song);
		return true;
	}

	@Override
	public String toString() {
		return "songs " + songs ;
	}
	

}
