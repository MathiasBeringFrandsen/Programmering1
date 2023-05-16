package storage;

import application.model.*;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Udlejning> udlejninger = new ArrayList<>();
    private static final ArrayList<Bil> biler = new ArrayList<Bil>();
    private static final ArrayList<Prisklasse> prisklasser = new ArrayList<>();
    private static final ArrayList<Kunde> kunder = new ArrayList<>();
    private static final ArrayList<Værksted> værksteder = new ArrayList<>();
    private static final ArrayList<Afdeling> afdelinger = new ArrayList<>();


    //Udlejninger
    public static ArrayList<Udlejning> getUdlejninger() {
        return new ArrayList<>(udlejninger);
    }

    public void addUdlejning(Udlejning udlejning) {
        //mayde check if it cointains here? so i doesnt double add?
        udlejninger.add(udlejning);
    }

    public void removeUdlejning(Udlejning udlejning) {
        udlejninger.remove(udlejning);
    }

    //Biler
    public static ArrayList<Bil> getBiler() {
        return new ArrayList<>(biler);
    }

    public void addBiler(Bil bil) {
        biler.add(bil);
    }

    public void removeBiler(Bil bil) {
        biler.remove(biler);
    }

    //Prisklasser
    public static ArrayList<Prisklasse> getPrisklasser() {
        return new ArrayList<>(prisklasser);
    }

    private void addPrisklasse(Prisklasse prisklasse) {
        prisklasser.add(prisklasse);
    }

    private void removePrisklasse(Prisklasse prisklasse) {
        prisklasser.remove(prisklasse);
    }

    //Kunde
    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }

    public void addKunde(Kunde kunde) {
        kunder.add(kunde);
    }

    public void removeKunde(Kunde kunde) {
        kunder.remove(kunde);
    }

    //Værksted
    public static ArrayList<Værksted> getVærksteder() {
        return new ArrayList<>(værksteder);
    }

    public void addVærksted(Værksted værksted) {
        værksteder.add(værksted);
    }

    public void removeVærksted(Værksted værksted) {
        værksteder.remove(værksted);
    }

    //Afdeling
    public static ArrayList<Afdeling> getAfdelinger() {
        return new ArrayList<>(afdelinger);
    }

    public void addAfdeling(Afdeling afdeling) {
        afdelinger.add(afdeling);
    }

    public void removeAfdelinger(Afdeling afdeling) {
        afdelinger.remove(afdeling);
    }
}
