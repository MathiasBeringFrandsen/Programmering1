package Opgave5;

import java.util.ArrayList;

public class Episode {
    private int number;
    private ArrayList<String> guestActors;
    private int lengthMinuttes;

    Episode(int number, int lengthMinuttes,ArrayList<String> guestActors){
        this.number = number;
        this.lengthMinuttes = lengthMinuttes;
        this.guestActors = guestActors;
    }

    public int getNumber() {
        return number;
    }

    public int getLength() {
        return lengthMinuttes;
    }

    public ArrayList<String> getGuestCast() {
        return new ArrayList<>(guestActors);
    }



}
