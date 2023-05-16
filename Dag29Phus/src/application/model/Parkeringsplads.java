package application.model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Parkeringsplads {
    private int nummer;
    private LocalTime ankomst;
    private Bil bil;
    private Parkeringshus parkeringshus;

    public Parkeringsplads(int nummer) {
        this.nummer = nummer;
        this.ankomst = null;
    }

    public int getNummer() {
        return nummer;
    }

    public LocalTime getAnkomst() {
        return ankomst;
    }

    public Bil getBil() {
        return bil;
    }

    public Parkeringshus getParkeringshus() {
        return parkeringshus;
    }

    public void setParkeringshus(Parkeringshus parkeringshus) {
        this.parkeringshus = parkeringshus;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
        this.ankomst = LocalTime.now();
    }

    public void removeBil(Bil bil) {
        this.bil = null;
        this.ankomst = null;
    }

    public int beregnPris(LocalTime sluttidspunkt) {
        long minutterParkeret = ChronoUnit.MINUTES.between(ankomst, sluttidspunkt);
        int heleTiMinutter = (int) minutterParkeret / 10;
        int pris;
        if (minutterParkeret % 10 == 0) {
            pris = heleTiMinutter * 6;
        } else {
            pris = heleTiMinutter * 6 + 6;
        }
        return pris;
    }

    public void hentBil(LocalTime afgangstidspunkt){
        parkeringshus.setSaldo(beregnPris(afgangstidspunkt));
        this.bil = null;
        this.ankomst = null;
    }



}
