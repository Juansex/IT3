package model;

/**Is the class that determine the parameters of the audio. 
 * @param name name of the audio.
 * @param album is the name of the album.
 * @param duration is how the song would be.
 * @param solds 
*/
public abstract class Audio {
	private String name;
	private String album;
	private double duration;
	private double selled;
	private String urlPicture;
	
	public Audio(String name, String album, double duration, double selled, String urlPicture) {
		
		this.name = name;
		this.album = album;
		this.duration = duration;
		this.selled = selled;
		this.urlPicture = urlPicture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getSolds() {
		return selled;
	}

	public void setSolds(double solds) {
		this.selled = solds;
	}

	public String getUrlPicture() {
		return urlPicture;
	}

	public void setUrlPicture(String urlPicture) {
		this.urlPicture = urlPicture;
	}

	@Override
	public String toString() {
		return "name " + name + " album" + album + " duration" + duration + " solds" + selled
				+ " urlPicture" + urlPicture;
	}

    public String play() {
        return null;
    }
	
	
	

}
