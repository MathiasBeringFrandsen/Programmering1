package storage;

import application.model.Festival;
import application.model.Frivillig;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Festival> festivaler = new ArrayList<>();
    private static final ArrayList<Frivillig> frivillige = new ArrayList<>();

    public static ArrayList<Festival> getFestivaller(){
        return new ArrayList<>(festivaler);
    }

    public static ArrayList<Frivillig> getFrivillige(){
        return new ArrayList<>(frivillige);
    }

    public static void addFrivillig(Frivillig frivillig){
        if (!frivillige.contains(frivillig)){
            frivillige.add(frivillig);
        }
    }

    public static void addFestival(Festival festival){
        if (!festivaler.contains(festival)){
            festivaler.add(festival);
        }
    }
}
