package model;

public class PlayAudio {
    
    private Audio audio;
    private int reproduction;


    public PlayAudio(Audio audio) {

        this.audio = audio;
        reproduction = 0;
    }


    public Audio getAudio() {
        return audio;
    }


    public void setAudio(Audio audio) {
        this.audio = audio;
    }


    public int getReproduction() {
        return reproduction;
    }


    public void setReproduction(int reproduction) {
        this.reproduction = reproduction;
    }

    public void updateInfo(){
        reproduction++;
    }



}