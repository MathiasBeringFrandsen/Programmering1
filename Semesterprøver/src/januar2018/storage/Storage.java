package januar2018.storage;

import januar2018.application.model.Arrangement;
import januar2018.application.model.Tutor;
import januar2018.application.model.Uddannelse;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Uddannelse> uddannelser = new ArrayList<>();
    private static final ArrayList<Tutor> tutorer = new ArrayList<>();
    private static final ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public static void addUddannelse(Uddannelse uddannelse){
        if (!uddannelser.contains(uddannelse)){
            uddannelser.add(uddannelse);
        }
    }

    public static ArrayList<Uddannelse> getUddannelser(){
        return new ArrayList<>(uddannelser);
    }

    public static void addTutor(Tutor tutor){
        if (!tutorer.contains(tutor)){
            tutorer.add(tutor);
        }
    }

    public static ArrayList<Tutor> getTutorer(){
        return new ArrayList<>(tutorer);
    }

    public static void addArrangement(Arrangement arrangement){
        if (!arrangementer.contains(arrangement)){
            arrangementer.add(arrangement);
        }
    }

    public static ArrayList<Arrangement> getArrangementer(){
        return new ArrayList<>(arrangementer);
    }
}
