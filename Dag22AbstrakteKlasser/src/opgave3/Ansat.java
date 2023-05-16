package opgave3;

public abstract class Ansat extends Person {
    private double timelønssats;

    public Ansat(String navn, String adresse, double timelønssats){
        super(navn, adresse);
        this.timelønssats = timelønssats;
    }

    public double getTimelønssats() {
        return timelønssats;
    }

    public void setTimelønssats(double timelønssats) {
        this.timelønssats = timelønssats;
    }

    public abstract double beregnLoen();
}
