package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class PremiumUser extends ConsumerUser {

    private ArrayList<Playlist> playlists;
    private ArrayList<Purchase> songList;
    
    public PremiumUser(String nickname, String id, LocalDate vinculated) {
        super(nickname, id);
        this.playlists = new ArrayList<Playlist>();
        this.songList = new ArrayList<Purchase>();
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylist(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<Purchase> getShoppingList() {
        return songList;
    }

    public void setShoppingList(ArrayList<Purchase> songList) {
        this.songList= songList;
    }

    /**
     * this method allows us to buy songs
     * @param audio Audio object to be purchased
     * @return msg String will indicate whether the purchase was successful or not. 
     */
    public String buyAudio(Audio audio ) {
        
        String msg = "";

        Purchase flag = searchAudio(audio.getName());
        
        if (flag == null) {

            if (audio instanceof Song) {

                Song newSong = (Song) audio;

                msg += newSong.purchase();

                super.getShoppingList().add(new Purchase(newSong));

                    
            } else {
            
                msg = "The audio is not a song";
            } 
        }

        msg += "The song was successfully purchased ";
        return msg;
    }

	/**
	* this method allows to search a song by its name
	* @param name is the name of the song to be searched.
	* @return sentinel the shop that contains the song.
	*/
	public Purchase searchAudio(String name) {

	    Object sentinel = null;
	        
        boolean search = false;
	        
            for (int i = 0; i < super.getShoppingList().size() && !search; i++) {
	            
                if (((Purchase) super.getShoppingList().get(i)).getSelectedSong().getName().equalsIgnoreCase(name)) {
	                
                    
                    sentinel = super.getShoppingList().get(i);
	                
                    search = true;
	            }
	        }

	    return (Purchase) sentinel;
	}
	

    /**
	* This method allows to add a playlist to the user's list of playlists.
	* @param playlistName String the name of the playlist to be added.
	* @return msg String the message that indicates if the playlist was added  successfully or not.
	 */
	public String createPlaylist(String playlistName) {
	
        String msg = "Playlist added successfully";

	        Playlist sentinel = searchPlaylist(playlistName);

	        if (sentinel == null) {

	            playlists.add(new Playlist(playlistName));

	        } else {

	            msg = "The playlist name already exists";
	        }

	    return msg;
	}
	

	/**
	* allows to add an audio to a playlist.<br>
	* @param playlistName String is the name of the playlist.
	* @param audio Audio is the audio to be added.
	* @return msg String the message that indicates if the audio was added successfully or not.
	*/
	public String addAudioToPlaylist(String playlistName, Audio audio) {
	
	    String msg = "";

	    Playlist sentinel = searchPlaylist(playlistName);

	        if (sentinel != null) {

	            msg = sentinel.createAudio(audio);

	        } else {
	            msg = "Playlist name not found";
	        }
        msg += "The audio was added to the playlist";
	    return msg;
	}
	

	/**
	* allows to search a playlist by its name.
	* @param playlistName String is the name of the playlist to be searched.
	* @return sentinel PlayList the playlist found.
	*/
	public Playlist searchPlaylist(String playlistName) {
	
	    Playlist sentinel = null;

	    boolean search = false;
	        
            if (playlists != null) {
	            
                for (int i = 0; i < playlists.size() && !search; i++) {
	                
                    if (playlists.get(i).getPlaylistName().equalsIgnoreCase(playlistName)) {
	                    
                        sentinel = playlists.get(i);
	                    
                        search = true;
	                }
	            }
	        }
	
	 return sentinel;

	}
	

	/**
	* allows to change the name of a playlist
    * @param playlistName String is the name of the playlist to be edited.
	* @param newPlaylistName String is the new name of the playlist.
	* @return msg String the message that indicates if the playlist was edited successfully or not.
	*/
	public String editPlaylistName(String playlistName, String newPlaylistName) {
	
	    String msg = "";

	    Playlist sentinel = searchPlaylist(playlistName);

	        if (sentinel != null) {
	            sentinel.setPlaylistName(newPlaylistName);

	        } else {
	            msg = "Error, could not find playlist name";
	        }

	    return msg;

	}
	

	/**
	* allows to remove an audio from a playlist.
	* @param playlistName String is the name of the playlist.
	* @param audio Audio is the audio to be removed.
	* @return msg String the message that indicates if the audio was removed successfully or not.
	*/
	public String deleteAudioToPlaylist(String playlistName, Audio audio) {
	
	    String msg = "";

	    Playlist sentinel = searchPlaylist(playlistName);

	    if (sentinel != null) {

	        msg = sentinel.deleteAudio(audio);

	    } else {

	        msg = "The playlist does not exist";

	    }
        
        msg += "the audio was successfully deleted";

	    return msg;

	}
	
    /**
	* allows to share a playlist.
	* @param playlistName String is the name of the playlist.
	* @return msg String the message that indicates if the audio was shared successfully or not.
	*/
	public String sharePlaylist(String playlistName) {
	
	    String msg = "";

	        Playlist sentinel = searchPlaylist(playlistName);

	        if (sentinel != null) {

	            msg = sentinel.sharePlaylist();

	        }
        msg += "The playlist could not be shared";

	    return msg;
	}
	
}
