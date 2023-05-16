package application.model;

import java.util.ArrayList;
import java.util.List;

public class Prisklasse {
    private String beskrivelse;
    private double pris;
    private int aldersGrænse;
    private List<Bil> biler = new ArrayList<>();

    public Prisklasse(String beskrivelse, double pris, int aldersGrænse){
        this.beskrivelse = beskrivelse;
        this.pris = pris;
        this.aldersGrænse = aldersGrænse;
    }
}
