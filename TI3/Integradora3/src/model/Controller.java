package model;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;

public class Controller {
	
	
	public static Random advertisement = new Random();
	private ArrayList<Song>songs;
	private ArrayList<Podcast>podcasts;
	private ArrayList<Artist>artist;
	private ArrayList<StandarUser>standar;
	private ArrayList<PremiumUser>premium;
	private ArrayList<ContentCreator>cc;
	
	private static ArrayList<User> Users;

    private static ArrayList<Audio> Audios;
	
	
	
	public Controller(){
		
		artist = new ArrayList<Artist>();
		premium = new ArrayList<PremiumUser>();
		standar = new ArrayList<StandarUser>();
		podcasts = new ArrayList<Podcast>();
		cc = new ArrayList<ContentCreator>();
		songs = new ArrayList<Song>();
		Users = new ArrayList<User>();
        Audios = new ArrayList<Audio>();
		
		
	}
	
	public static String createPlaylist(String playlistName, String nickname){

        String msg = "";

        User verifyUser = searchUser(nickname);

        if (verifyUser != null) {

            if (verifyUser instanceof PremiumUser) {

                msg = ((PremiumUser)verifyUser).createPlaylist(playlistName);

            } else if (verifyUser instanceof StandarUser) {

                msg = ((StandarUser)verifyUser).createPlaylist(playlistName);
            }
        } else {
            
            return msg += "nickname could not be found, try registering first ";
        }
        
        msg += "playlist successfully added to the user ";

        return msg;

    }

    /**
     * @param audioName String 
     * @param playlistName String name of the selected playlist 
     * @param nickname String user nickname
     * @return msg String will indicate whether or not the audio could have been added to the playlist.
     */
    public String addAudioToPlaylist(String audioName, String playlistName, String nickname) {
        
        String msg = "";

        User user = searchUser(nickname);

        Audio audio = searchAudio(audioName);

            if (user!= null) {

                if (audio!= null) {

                    if (user instanceof ConsumerUser) {

                        msg = ((ConsumerUser)user).addAudioToPlaylist(playlistName, audio);

                    }

                } else {
                
                    msg = "Error, could not find that audio name ";

                }

            } else {

                msg = "Error, user's nickname could not be found";

            }

        return msg;
    }

    /**
     * Description : allows us to remove audio from a playlist 
     * pre: that there is a playlist 
     * @param playlistName String name of the required playlist 
     * @param nickname String user nickname 
     * @param audioName String name of the audio to be deleted 
     * @return msg String will indicate whether or not the audio could be removed from the playlist. 
     */
    public String deleteAudioToPlaylist(String playlistName, String nickname, String audioName) {

        String msg = "";

        User obj = searchUser(nickname);

        Audio audio = searchAudio(audioName);

        if (obj != null && audio!= null) {

            if (obj instanceof ConsumerUser) {

                msg = ((ConsumerUser) obj).deleteAudioToPlaylist(playlistName, audio);

            } else {

                msg = "Error, The user is not a consumer ";
            }
        } else {
            msg = "Error, The user or the audio does not exist";
        }

        return msg;

    }

    /**
     * Description: allows you to rename an existing playlist 
     * pre: that there is a playlist 
     * @param nickname String user nickname
     * @param playlistName String playlist name to change 
     * @param newPlaylistName String new playlist name 
     * @return msg String will indicate whether or not the name could be changed. 
     */
    public String editPlaylistName(String nickname, String playlistName, String newPlaylistName) {
        
        String msg = "";

        User user = searchUser(nickname);

        if (user!= null) {

            if (user instanceof ConsumerUser) {

                msg = ((ConsumerUser)user).editPlaylistName(playlistName, newPlaylistName);

            } 

        } else {

            msg = "Error, user's nickname could not be found ";
        }
        
        msg += "user's nickname could not be found";
        return msg;
    }

    /**
     * Description:allows you to share the playlist using the generated code 
     * pre: that there is a playlist 
     * pos: none 
     * @param nickname String user nickname
     * @param playlistName String name of the playlist to share 
     * @return msg String indicates whether the playlist could be shared 
     */
    public String sharePlaylist(String nickname, String playlistName) {

        String msg = "";

        User verifyUser = searchUser(nickname);

        if (verifyUser!= null) {

            if (verifyUser instanceof ConsumerUser) {

                msg = ((ConsumerUser)verifyUser).sharePlaylist(playlistName);

            } else {
                msg = "This user cannot share playlists";
            }
        } 

        msg += "playlist shared with success";

        return msg;
    }

	public static User searchUser(String nickname) {
        
        User verifyUser  = null;
        boolean flag = false;

        for (int i = 0; i < Users.size() && !flag; i++) {
            
            if (Users.get(i).getNickname().equals(nickname)) {

                verifyUser = Users.get(i);
                flag = true;
            }
        }
        return verifyUser;
    }

	public static Audio searchAudio(String audioName) {
        
        Audio object = null;
        boolean found = false;

        for (int i = 0; i < Audios.size() && !found; i++) {

            if (Audios.get(i).getName().equals(audioName)) {

                object = Audios.get(i);
                found = true;

            }
        }

        return object;
    }

	public static String buySong(String nickname, String audioName) {

        String msg = "";

        User obj = searchUser(nickname);

        Audio sentinel = searchAudio(audioName);

        if (obj != null) {

            if (sentinel!= null && sentinel instanceof Song) {

                if (obj instanceof PremiumUser) {

                    msg = ((PremiumUser) obj).buyAudio(sentinel);

                } else if (obj instanceof StandarUser) {

                    msg = ((StandarUser)obj).buyAudio(sentinel);
                }
            } else {
                msg = "This audio could not be purchased ";
            }
        } else {
            msg = "The user does not exist";
        }

        return msg;
    }

	/**
	 * 
	 * @param nickname
	 * @param id
	 * @param vinculated
	 * @return
	 */
	public boolean registerPremiumUser(String nickname, String id, LocalDate vinculated) {
		
		PremiumUser premiumUser = new PremiumUser(nickname, id, vinculated);
											
		premium.add(premiumUser);
		
		
		return true;
	}
	
	
public boolean registerStandar(String nickname, String id, LocalDate vinculated) {
		
		StandarUser standUser = new StandarUser(nickname, id, vinculated); 
		
		standar.add(standUser);
		
		return true;
	}

public boolean registerArtist(String nickname, String id, LocalDate vinculated) {
	
											
	Artist art = new Artist( nickname, id, vinculated);
	
	artist.add(art);
	
	
	return true;
}



public boolean registerCC(String nickname, String id, LocalDate vinculated) {
	
	ContentCreator contenido = new ContentCreator(nickname, id, vinculated);
	
	cc.add(contenido);
											
	return true;
}
	
	public boolean registersong(String name, String album, double duration, double solds, String urlPicture) {
		
		Song song = new Song(name, album, duration, solds, urlPicture);
		
		songs.add(song);
		
		
		return true;
		
	}
	
	public boolean registerPodcast(String name, String album, double duration, double solds, String urlPicture, int type,String descrption) {
		
		Podcast podcast = new Podcast(name, album, duration, solds, urlPicture, type, descrption);
		
		podcasts.add(podcast);
		
		
		return true;
	}
	
	public String showUsers() {
		
		String msg = "";
		
		for (int i = 0; i< artist.size() && i <  cc.size() && i<premium.size() && i<standar.size(); i++) {
			
			msg += "Artists Users \n" +
					artist.get(i).getNickname()
					+"\n"
					+"Content Crator users \n"
					+cc.get(i).getNickname()
					+"\n"
					+"Premium Users \n"
					+premium.get(i).getNickname()
					+"\n"
					+"Standar Users \n"
					+standar.get(i).getNickname();
			
		}
		
		return msg; 
	}
	
		public static String showAd() {

			String msg = "";
			int advert = advertisement.nextInt(3);
	
			switch (advert) {
				case 0:
					break;
				case 1:
					msg = Ad.NIKE.playAudio();
					break;
				case 2:
					msg = Ad.MyMs.playAudio();
					break;
			}
			return msg;
		}
	
	public static String playAudio (String nickname, String nameAudio) {

        String msg = "";
        User user = searchUser(nickname);

        Audio audio = searchAudio(nameAudio);

        if (user != null) {

            if (user instanceof ConsumerUser) {

                if (audio!= null) {

                    if (user instanceof PremiumUser) {

                        msg = ((PremiumUser)user).playAudio(audio);

                    } else if (user instanceof StandarUser) {

                        StandarUser user2 = (StandarUser)user;

                        if (audio instanceof Song) {

                            if (user2.showAds()) {

                                msg += showAd();
                                msg += "\n" + ((StandarUser)user).playAudio(audio);

                            } else {
                                msg = ((StandarUser)user).playAudio(audio);
                            }
                        } else {
                            msg += showAd();
                        }

                    }
                } else {
                    msg = "The audio does not exist";
                }
            }
        } else {
            msg = "The user does not exist";
        }
        return msg;
    }

	
	public String showSong() {
		
		String msg = "";
		
		for (int i = 0; i<songs.size();i++) {
			
			msg += "Songs \n"
					+ songs.get(i).getName();
			
		}
		
		return msg;
		
	}

	public static void registerPodcast(String name, String distinctiveUrl, int duration, String nickname,
			String description, int category) {
	}
	

}
