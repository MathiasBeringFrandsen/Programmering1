package Opgave1;

public class Mekaniker extends Person {
    private int årForSvendeprøve;
    private double timelønssats;

    public Mekaniker(String navn, String adresse, int årForSvendeprøve, double timelønssats) {
        super(navn, adresse);
        this.årForSvendeprøve = årForSvendeprøve;
        this.timelønssats = timelønssats;
    }

    public int getÅrForSvendeprøve() {
        return årForSvendeprøve;
    }

    public void setÅrForSvendeprøve(int årForSvendeprøve) {
        this.årForSvendeprøve = årForSvendeprøve;
    }

    public double getTimelønssats() {
        return timelønssats;
    }

    public void setTimelønssats(double timelønssats) {
        this.timelønssats = timelønssats;
    }

    public double beregnLoen() {
        return 37 * timelønssats;
    }


}
