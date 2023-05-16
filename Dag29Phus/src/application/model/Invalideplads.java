package application.model;

import java.time.LocalTime;

public class Invalideplads extends Parkeringsplads{
    private double areal;

    public Invalideplads(int nummer, double areal){
        super(nummer);
        this.areal = areal;
    }

    public double getAreal() {
        return areal;
    }

    @Override
    public int beregnPris(LocalTime sluttidspunkt) {
        return 0;
    }
}
