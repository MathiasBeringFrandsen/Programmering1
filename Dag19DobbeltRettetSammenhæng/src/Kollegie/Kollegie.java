package Kollegie;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Kollegie {
    private String navn;
    private String adresse;
    private ArrayList<Bolig> boliger = new ArrayList<>();

    public Kollegie(String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public ArrayList<Bolig> getBoliger() {
        return new ArrayList<>(boliger);
    }

    public Bolig createBolig(int kvm, int prisPrMaaned){
        Bolig bolig = new Bolig(kvm, getAdresse(), prisPrMaaned, this);
        boliger.add(bolig);
        return bolig;
    }

    public void addBolig(Bolig bolig) {
        if (!boliger.contains(bolig)) {
            boliger.add(bolig);
            bolig.setKollegie(this);
        }
    }

    public void removeBolig(Bolig bolig) {
        if (boliger.contains(bolig)) {
            boliger.remove(bolig);
        }
    }

    public int getAntalLejeAftaler() {
        int antalLejeAftaler = 0;
        for (Bolig bolig : boliger) {
            ArrayList<LejeAftale> aftaler = bolig.getLejeAftaler();
            for (LejeAftale aftale : aftaler) {
                antalLejeAftaler++;
            }
        }
        return antalLejeAftaler;
    }

    public double gennemsnitligtAntalDage() {
        double totalDage = 0;
        int antalAfsluttede = 0;
        for (Bolig bolig : boliger) {
            ArrayList<LejeAftale> aftaler = bolig.getLejeAftaler();
            for (LejeAftale aftale : aftaler){
                if (aftale.getTilDato() != null){
                    antalAfsluttede++;
                    long daysBetween = ChronoUnit.DAYS.between(aftale.getFraDato(), aftale.getTilDato());
                    totalDage += daysBetween;
                }
            }
        }
        return totalDage / antalAfsluttede;
    }

}