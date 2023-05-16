package Kollegie;

import java.time.LocalDate;
import java.util.ArrayList;

public class LejeAftale {
    private LocalDate fraDato;
    private LocalDate tilDato;
    private ArrayList<Lejer> lejere = new ArrayList<>();
    private Bolig bolig;

    LejeAftale(Bolig bolig){
        this.fraDato = LocalDate.now();
        this.tilDato = null;
        this.bolig = bolig;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public void setFraDato(LocalDate fraDato) {
        this.fraDato = fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public void setTilDato(LocalDate tilDato) {
        this.tilDato = tilDato;
    }

    public ArrayList<Lejer> getLejere() {
        return new ArrayList<>(lejere);
    }

    public void addLejer(Lejer lejer){
        if (lejere.size() < 2){
            lejere.add(lejer);
        }
    }

    public void removeLejer(Lejer lejer){
        lejere.remove(lejer);
    }

}
