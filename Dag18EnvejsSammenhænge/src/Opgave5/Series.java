package Opgave5;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast = new ArrayList<>();
    private final ArrayList<Episode> episodes = new ArrayList<>();

    public Series(String title, ArrayList<String> cast){
        this.title = title;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return new ArrayList<>(cast);
    }

    public Episode createEpisode(int number, int lengthMinuttes, ArrayList<String> guestActors){
        Episode episode = new Episode(number, lengthMinuttes, guestActors);
        episodes.add(episode);
        return episode;
    }

    public int totalLength(){
        int totalLength = 0;
        for (Episode episode : episodes) {
            totalLength += episode.getLength();
        }
        return totalLength;
    }

    public ArrayList<String> getGuestActors(){
        ArrayList<String> allGuestActors = new ArrayList<>();
        for (int i = 0; i < episodes.size(); i++){
            ArrayList<String> guestcast = episodes.get(i).getGuestCast();
            for (int j = 0; j < guestcast.size(); j++){
                allGuestActors.add(guestcast.get(j));
            }
        }
        return allGuestActors;
    }

}
