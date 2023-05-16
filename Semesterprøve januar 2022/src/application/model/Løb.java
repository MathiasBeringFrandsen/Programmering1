package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Løb {
    private LocalDate dato;
    private String sted;
    private int normalPris;
    private LocalDate earlyBirdDate;
    private int earlyBirdPris;

    private final ArrayList<Forhindring> forhindringer = new ArrayList<>();
    private final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Løb(LocalDate dato, String sted, int normalPris, LocalDate earlyBirdDate, int earlyBirdPris) {
        this.dato = dato;
        this.sted = sted;
        this.normalPris = normalPris;
        this.earlyBirdDate = earlyBirdDate;
        this.earlyBirdPris = earlyBirdPris;
    }

    public LocalDate getDato() {
        return dato;
    }

    public String getSted() {
        return sted;
    }

    public int getNormalPris() {
        return normalPris;
    }

    public LocalDate getEarlyBirdDate() {
        return earlyBirdDate;
    }

    public int getEarlyBirdPris() {
        return earlyBirdPris;
    }

    public ArrayList<Forhindring> getForhindringer() {
        return new ArrayList<>(forhindringer);
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public Tilmelding createTilmelding(String navn, boolean kvinde, LocalDate tilmeldingsdato) {
        Tilmelding tilmelding = new Tilmelding(navn, kvinde, tilmeldingsdato, tilmeldinger.size() + 1, this);
        tilmeldinger.add(tilmelding);
        return tilmelding;
    }

    public void addForhindring(Forhindring forhindring) {
        if (!forhindringer.contains(forhindring)) {
            forhindringer.add(forhindring);
        }
    }

    public void removeForhindring(Forhindring forhindring) {
        if (forhindringer.contains(forhindring)) {
            forhindringer.remove(forhindring);
        }
    }

    public int earlyBirdIndtjening() {
        int indtjening = 0;
        for (Tilmelding tilmelding : tilmeldinger) {
            if (tilmelding.getTilmeldingsdato().isBefore(earlyBirdDate) || tilmelding.getTilmeldingsdato().isEqual(earlyBirdDate)) {
                indtjening += earlyBirdPris;
            }
        }
        return indtjening;
    }

    public double gennemsnitStrafSekunder(Forhindring forhindring) {
        double samletStraftid = 0;
        int i = 0;
        for (Tilmelding tilmelding : getTilmeldinger()) {
            for (Note note : tilmelding.getNoter()) {
                samletStraftid += note.getStrafSekunder();
                i++;
            }
        }
        return samletStraftid / i;
    }

    public String winner() {
        Tilmelding vinder = tilmeldinger.get(0);
        for (Tilmelding tilmelding : tilmeldinger) {
            if (tilmelding.getLøbstid() != -1 && tilmelding.getLøbstid() < vinder.getLøbstid()) {
                vinder = tilmelding;
            }
        }
        return vinder.getLøbeNummer() + " " + vinder.getNavn() + " " + vinder.resultatTid();
    }

    public String løberInfo(String navn) {
        String info = "Deltageren findes ikke";
        Tilmelding tilmelding = null;
        int i = 0;
        while (tilmelding == null && i < tilmeldinger.size()) {
            Tilmelding t = tilmeldinger.get(i);
            if (t.getNavn().equals(navn)) {
                tilmelding = t;
                info = tilmelding.getLøbeNummer() + " " + tilmelding.getNavn() + " " + tilmelding.resultatTid() + " " + tilmelding.getNoter().size();
            } else {
                i++;
            }
        }
        return info;
    }

//    public ArrayList<Tilmelding> listeOverGennemført() {
//        ArrayList<Tilmelding> sejeLøbere = new ArrayList<>();
//        for (int i = 0; i < tilmeldinger.size(); i++) {
//
//        }
//        return sejeLøbere;
//    }

    public String toString() {
        return sted + " " + dato + " " + normalPris;
    }
}
