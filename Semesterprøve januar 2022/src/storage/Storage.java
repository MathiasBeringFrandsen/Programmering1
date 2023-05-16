package storage;

import application.model.Forhindring;
import application.model.Løb;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Løb> alleLøb = new ArrayList<>();
    private static final ArrayList<Forhindring> forhindringer = new ArrayList<>();

    public static ArrayList<Løb> getLøb(){
        return new ArrayList<>(alleLøb);
    }

    public static ArrayList<Forhindring> getForhindringer(){
        return new ArrayList<>(forhindringer);
    }

    public static void addLøb(Løb løb){
        if (!alleLøb.contains(løb)){
            alleLøb.add(løb);
        }
    }

    public static void addForhindring(Forhindring forhindring){
        if (!forhindringer.contains(forhindring)){
            forhindringer.add(forhindring);
        }
    }

}
