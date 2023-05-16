package application.model;

public class Song {
    private String title;
    private String artist;
    private int bpm;

    public Song(String title, String artist, int bpm){
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    public void printSong(){
        System.out.println("****************************");
        System.out.println("Titel     :  " + getTitle());
        System.out.println("Kunster   :  " + getArtist());
        System.out.println("Hastighed :  " + getBpm() + " (Bpm)");
        System.out.println("****************************");
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public String tilpas(int tempo){
        String tilpas = "Perfekt";
        if (bpm < tempo){
            tilpas = "Langsom";
        }else if (bpm > tempo){
            tilpas = "Hurtig";
        }
        return tilpas;
    }
}
