package model;

/**Is the info about the song that is going to reproduced.
 * 
*/

public class Song extends Audio {
	
	
	public Song(String name, String album, double duration, double selled, String urlPicture) {
		super(name, album, duration, selled, urlPicture);
	}
	
	
	public String toString() {
		return "Songs" + " (name " + getName() + " album" + getAlbum() + " duration" + getDuration() + " solds" + getSolds() + " urlPicture" + getUrlPicture() + ")";
	}


    public Object getGenre() {
        return null;
    }


    public String purchase() {
        return null;
    }
}
