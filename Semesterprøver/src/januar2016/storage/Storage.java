package januar2016.storage;

import januar2016.application.model.Bane;
import januar2016.application.model.Medlem;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Bane> baner = new ArrayList<>();
    private static final ArrayList<Medlem> medlemmer = new ArrayList<>();

    public static ArrayList<Bane> getBaner() {
        return new ArrayList<>(baner);
    }

    public static ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<>(medlemmer);
    }

    public static void addMedlem(Medlem medlem){
        if (!medlemmer.contains(medlem)){
            medlemmer.add(medlem);
        }
    }

    public static void addBane(Bane bane){
        if (!baner.contains(bane)){
            baner.add(bane);
        }
    }
}
