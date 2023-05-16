package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udlejning {
    private LocalDate startDato;
    private LocalDate slutDato;

    private ArrayList<Bil> biler = new ArrayList<>();
    private Kunde kunde;
    private Afdeling afdeling;

    public Udlejning(LocalDate startDato,LocalDate slutDato){
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public ArrayList<Bil> getBiler() {
        return biler;
    }

    public void setBiler(ArrayList<Bil> biler) {
        this.biler = biler;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }
}
