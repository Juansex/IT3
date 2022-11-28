package model;

import java.time.LocalDate;

public class StandarUser extends ConsumerUser{

   public static final int MAXIMUMPURCHASES = 50; //maximum number of songs that can be purchased by a standard user 
   public static final int MAXIMUMPLAYLISTS = 10; //maximum number of playlists that can be created by a standard user 

	private int adCounter;

	public StandarUser(String nickname, String id, LocalDate vinculated) {
    	super(nickname, id);
    	adCounter = 0;
	}

	public int getAdCounter() {
    	return adCounter;
	}

	public void setAdCounter(int adCounter) {
    	this.adCounter = adCounter;
	}

	/**
    * is in charge of searching for the audio you wish to purchase. 
    * @param name String name of the audio to be searched 
    * @return Purchase search result
    */
	public Purchase searchAudioToPurchase(String name) {

    	Object buy = null;
    	boolean flag = false;

    	for (int i = 0; i < super.getShoppingList().size() && !flag;i++) {

        	if (((Purchase) super.getShoppingList().get(i)).getSelectedSong().getName().equalsIgnoreCase(name)) {
				
            buy = super.getShoppingList().get(i);
            
            flag= true;
        }
    }

    	return (Purchase) buy;
	}

    /**
	* This method allows to create a Playlist.
	* @param playlistName String the name of the playlist to be created.
	* @return msg String the message that indicates if the playlist was created successfully or not.
	 */
	public String createPlaylist(String playlistName) {

    	String msg = "";

    	Object obj = searchPlaylist(playlistName);

    	boolean available = availableCreation();

    	if (obj == null) {

        	if (available) {

            	for (int i = 0; i < super.getPlaylists().size() && obj == null; i++) {

            	if (super.getPlaylists().get(i) == null) {

                    	super.getPlaylists().add(new Playlist(playlistName));
                    	obj = super.getPlaylists().get(i);
                	}
            	}
        	} else {
            	msg = "Error, no more playlists can be created";
        	}
    	} else {
        	msg = "The playlist already exists";
    	}


    	return msg;


	}

	/** 
    * verify that the playlist to be created has not exceeded the maximum allowed for the user 
    * @return boolean depends on whether or not there is space to create playlist
    */
	public boolean availableCreation() {

    	boolean available = false;

        	if (super.getPlaylists().size()<MAXIMUMPLAYLISTS) {
            
            available = true;
        }
    	return available;
	}

	/**
   * this method allows us to buy songs
   * @param audio Audio object to be purchased
   * @return msg String will indicate whether the purchase was successful or not. 
   */
	public String buyAudio(Audio audio) {

	String msg = "";

    	Purchase flag = searchAudioToPurchase(audio.getName());

    	boolean disponibility = availableToPurchase();

    	if (flag == null) {

        if (disponibility) {

            if (audio instanceof Song) {

            Song buySong = (Song)audio;
            
        	msg += buySong.purchase();

            super.getShoppingList().add(new Purchase(buySong));
            
            } else {
            
            msg = "This type of audio cannot be purchased";

            }
        } else {
            msg = "Error, no more songs can be purchased";
        }
    } 

	return msg;
}

/**
 * Description: verifies that the user has not exceeded the song purchase limit
 * pre: none
 * pos: none 
 * @return boolean depends on whether or not the user has exceeded the purchase limit. 
 */
public boolean availableToPurchase() {

	boolean flag= false;

	if (super.getShoppingList().size() < MAXIMUMPURCHASES) {
    
    flag = true;

	}
	return flag;

	}

	/**
	* allows to share a playlist.
	* @param playlistName String is the name of the playlist.
	* @return msg String the message that indicates if the audio was shared successfully or not.
	*/
	public String sharePlaylist(String playlistName) {

    String msg = "";
    Object search = searchPlaylist(playlistName);

    if (search != null) {
        
        ((Playlist) search).sharePlaylist();

    } else {

        msg = "no playlist found";
        
    }

    return msg;
	}

	/**
	* Description: allows to search a playlist by its name.
   * pre:the playlist must be already created.
	* post:none
	* @param playlistName String is the name of the playlist to be searched.
	* @return PlayList the playlist found.
	*/
	public Object searchPlaylist(String playlistName) {
	
    Object search = null;
    boolean flag = false;

    for (int i = 0; i < super.getPlaylists().size() && !flag; i++) {
        
        if (super.getPlaylists().get(i) != null && ((Playlist) super.getPlaylists().get(i)).getPlaylistName().equalsIgnoreCase(playlistName)) {
            
            search = super.getPlaylists().get(i);
            flag = true;
        
        }
    }

    return search;
}

	/**
	* Description: allows to change the name of a playlist
	* pre:the playlist must be already created
	* post:the playlist will be edited
   * @param playlistName String is the name of the playlist to be edited.
	* @param newPlaylistName String is the new name of the playlist.
	* @return msg String the message that indicates if the playlist was edited successfully or not.
	*/
	public String editPlaylistName(String playlistName, String newPlaylistName) {
	
    String msg = "";

        Object sentinel = searchPlaylist(playlistName);

        if (sentinel != null) {
            ((Playlist) sentinel).setPlaylistName(newPlaylistName);

        } else {
            msg = "Error, could not find playlist name";
        }

	return msg;
	}
	/**
	* Description: allows to add an audio to a playlist.<br>
	* pre:none
	* post:the audio will be added to the playlist
	* @param playlistName String is the name of the playlist.
	* @param audio Audio is the audio to be added.
	* @return msg String the message that indicates if the audio was added successfully or not.
	*/
	public String addAudioToPlaylist(String playlistName, Audio audio){
	
    String msg = "";

	Object search = searchPlaylist(playlistName);

    if (search != null) {

        msg = ((Playlist) search).createAudio(audio);

    	} else {

		msg = "Error,could not find the playlist";

    }
    	msg += "Audio was successfully added to the playlist";

	return msg;
}

	/**
	* Description: allows to remove an audio from a playlist.
	* pre: the audio must be already created.
	* post: the audio will be removed from the playlist.
	* @param playlistName String is the name of the playlist.
	* @param audio Audio is the audio to be removed.
	* @return msg String the message that indicates if the audio was removed successfully or not.
	*/
	public String deleteAudioToPlaylist(String playlistName, Audio audio) {

    String msg = "";

    Object delete = searchPlaylist(playlistName);

        if (delete != null) {

            msg = ((Playlist) delete).deleteAudio(audio);

        } else {

            msg = "The playlist does not exist";
            
        }
    msg += "The audio was removed from the playlist ";

    return msg;
}


	/**
    * Description: will show the advertisements 
    * pre: none
    * pos: none
    * @return flag boolean if the condition is satisfied
    */
	public boolean showAds(){

    boolean flag = false;
    
        if (adCounter==2){
            
        flag = true;
            
        adCounter = 0;

        	}else{
            
            adCounter++;

        	}

		return flag;
}
}
