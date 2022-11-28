package model;

import java.util.ArrayList;

public abstract class ConsumerUser<Playlist, Purchase, Play> extends User {
    
    private ArrayList<Playlist> playlists;
    private ArrayList<Purchase> shoppingList;
    private ArrayList<Play> reproductions ;

    public ConsumerUser(String nickname, String id) {
        super(nickname, id, vinculated);
        playlists = new ArrayList<Playlist>();
        shoppingList = new ArrayList<Purchase>();
        reproductions = new ArrayList<Play>();
        
    }
    
    public ArrayList<Play> getReproductions() {
        return reproductions;
    }

    public void setReproductions(ArrayList<Play> reproductions) {
        this.reproductions = reproductions;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }


    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }


    public ArrayList<Purchase> getShoppingList() {
        return shoppingList;
    }


    public void setShoppingList(ArrayList<Purchase> shoppingList) {
        this.shoppingList = shoppingList;
    }
	

    
    /**This method play the audio 
     * @param audio Audio object to be reproduced
     * @return msg String message indicating playback
     */
    public String playAudio(Audio audio) {

        String msg = "";

        msg += audio.play();

        Play sentinel = searchPlayback(audio.getName());

        if (sentinel == null) {

            reproductions.add((Play) new PlayAudio(audio));

        } else {

            ((PlayAudio) sentinel).updateInfo();
        }

        return msg;

    }


    /**
     * This method allows to get the most listened genre.
     * @return String the most listened genre.
     */
    public String mostListenedGenre() {


        String msg = "";

        int[] typeOfGenre = reproductionsPerGenre();
        int max = 0;
        int pos = -1;
        for (int i = 0; i < typeOfGenre.length; i++) {

            if (typeOfGenre[i] > max) {
                
                max = typeOfGenre[i];
                pos = i;

            }
        }
        switch (pos) {
            case 0:
                msg = "The most listened genre is: ROCK, with " + max + " plays.";
                break;
            case 1:
                msg = "The most listened genre is: POP, with " + max + " plays.";
                break;
            case 2:
                msg = "The most listened genre is: Trap, with " + max + " plays.";
                break;
            case 3:
                msg = "The most listened genre is: House, with " + max + " plays.";
                break;
            default:
                msg = "no songs have been played.";
                break;
        }
        return msg;
    }


    /**
     * This method allows to get the number of playbacks per genre.
     * @return int[] the number of playbacks per genre.
     */
    public int[] reproductionsPerGenre() {

        int[] playbacks = new int[4];

        for (int i = 0; i < reproductions.size(); i++) {

            if (reproductions .get(i).getAudio() instanceof Song) {

                Song song = (Song) reproductions .get(i).getAudio();

                if (song.getGenre().equals(TypeOfGenre.ROCK)) {

                    playbacks[0] += reproductions.get(i).getReproduction();

                } else if (song.getGenre().equals(TypeOfGenre.POP)) {

                    playbacks[1] += reproductions .get(i).getReproduction();

                } else if (song.getGenre().equals(TypeOfGenre.TRAP)) {

                    playbacks[2] += reproductions .get(i).getReproduction();

                } else if (song.getGenre().equals(TypeOfGenre.HOUSE)) {

                    playbacks[3] += reproductions.get(i).getReproduction();

                }
            }
        }
        return playbacks;
    }


    /**
     * This methos allows to get the most heared category.
     * @return String the most listened category of podcast.
     */
    public String mostListenedCategory() {


        String msg = "";

        int[] categoryType = reproductionsPerCategory();

        int max = 0;
        int pos = -1;
        for (int i = 0; i < categoryType.length; i++) {

            if (categoryType[i] > max) {

                max = categoryType[i];
                pos = i;
            }
        }
        switch (pos) {

            case 0:
                msg = "The most listened genre is: Politics, with " + max + " plays.";
                break;
            case 1:
                msg = "The most listened genre is: Entertainment, with " + max + " plays.";
                break;
            case 2:
                msg = "The most listened genre is: Videogame, with " + max + " plays.";
                break;
            case 3:
                msg = "The most listened genre is: Fashion, with " + max + " plays.";
                break;
            default:
                msg = "no song played";
                break;
        }
        return msg;
    }


    /**
     * In this method the reproductions are counted for each podcaste category.
     * @return playbacks int[] reproductions by category 
     */
    public int[] reproductionsPerCategory() {

        int[] playbacks = new int[4];

        for (int i = 0; i < reproductions.size(); i++) {

            if (reproductions .get(i).getAudio() instanceof Podcast) {

                Podcast pod = (Podcast) reproductions.get(i).getAudio();

                if (pod.getCategory().equals(CategoryType.POLITICS)) {

                    playbacks[0] += reproductions .get(i).getReproduction();

                } else if (pod.getCategory().equals(CategoryType.ENTERTAINMENT)) {

                    playbacks[1] += reproductions.get(i).getReproduction();

                } else if (pod.getCategory().equals(CategoryType.VIDEOGAME)) {

                    playbacks[2] +=reproductions.get(i).getReproduction();

                } else if (pod.getCategory().equals(CategoryType.FASHION)) {
                    
                    playbacks[3] += reproductions.get(i).getReproduction();

                }
            }
        }
        return playbacks;
    }




    /**
     * this method allows to search a playback.
     * @param name String is the name of the audio that will be searched.
     * @return sentinel Play object
     */
    public Play searchPlayback(String name) {

        Play sentinel = null;
        boolean flag= false;

        for (int i = 0; i < reproductions .size() && !flag; i++) {
            
            if (reproductions .get(i).getAudio().getName().equalsIgnoreCase(name)) {
                
                sentinel = reproductions.get(i);
                flag = true;

            }
        }
        return sentinel;
    }


    /**
     * This method allows to add a playlist.
     * @param playlistName String is the playlist's name.
     * @return String the message of the operation.
     */
    public abstract String createPlaylist(String  playlistName);


    /**
     * This method allows to add an audio to a playlist
     * @param playlistName String is the playlist's name.
     * @param audio Audio is the audio object to be added.
     * @return String the message of the operation.
     */
    public abstract String addAudioToPlaylist(String playlistName, Audio audio);


    /**
     * This method allows to edit a playlist's name
     * @param playlistName String is the playlist's name.
     * @param newPlaylistName String is the new playlist's name.
     * @return String the message of the operation.
     */
    public abstract String editPlaylistName(String playlistName, String newPlaylistName);


    /**
     * this metod allows to remove an audio from a playlist
     * @param playlistName String is the playlist's name.
     * @param audio  Audio is the audio to be deleted.
     * @return String the message of the operation.
     */
    public abstract String deleteAudioToPlaylist(String playlistName, Audio audio);


    /**
     * allows to share a playlist by means of an auto-generated code
     * @param playlistName String is the playlist's name.
     * @return String the message of the operation.
     */
    public abstract String sharePlaylist(String playlistName);
    
}