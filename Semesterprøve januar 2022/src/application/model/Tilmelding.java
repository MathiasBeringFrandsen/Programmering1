package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.lang.*;

public class Tilmelding implements Comparable<Tilmelding> {
    private String navn;
    private boolean kvinde;
    private LocalDate tilmeldingsdato;
    private int løbeNummer;
    private int løbstid;

    private Løb løb;
    private final ArrayList<Note> noter = new ArrayList<>();

    Tilmelding(String navn, boolean kvinde, LocalDate tilmeldingsdato, int løbeNummer, Løb løb) {
        this.navn = navn;
        this.kvinde = kvinde;
        this.tilmeldingsdato = tilmeldingsdato;
        this.løbeNummer = løbeNummer;
        this.løb = løb;
        this.løbstid = -1;
    }

    public String getNavn() {
        return navn;
    }

    public boolean isKvinde() {
        return kvinde;
    }

    public LocalDate getTilmeldingsdato() {
        return tilmeldingsdato;
    }

    public int getLøbeNummer() {
        return løbeNummer;
    }

    public int getLøbstid() {
        return løbstid;
    }

    public Løb getLøb() {
        return løb;
    }

    public void setLøbstid(int løbstid) {
        this.løbstid = løbstid;
    }

    public ArrayList<Note> getNoter() {
        return new ArrayList<>(noter);
    }

    public Note createNote(int strafSekunder, Forhindring forhindring) {
        Note note = new Note(strafSekunder, forhindring);
        noter.add(note);
        return note;
    }

    public void registrerStrafPåForhindring(String navnForhindring, int strafSekunder) {
        for (Forhindring forhindring : løb.getForhindringer()) {
            if (forhindring.getNavn().equalsIgnoreCase(navnForhindring)) {
                createNote(strafSekunder, forhindring);
            }
        }
    }

    public int resultatTid() {
        int totalTid = løbstid;
        for (Note note : noter) {
            totalTid += note.getStrafSekunder();
        }
        return totalTid;
    }

    public int compareTo(Tilmelding tilmelding) {
        int comp = 0;
        if (!isKvinde() && tilmelding.isKvinde()) {
            comp = 1;
        } else if (isKvinde() && !tilmelding.isKvinde()) {
            comp = -1;
        }
        if (comp == 0) {
            comp = resultatTid() - tilmelding.resultatTid();
        }
        return comp;
    }

    public String toString() {
        return løbeNummer + " " + navn;
    }

}
