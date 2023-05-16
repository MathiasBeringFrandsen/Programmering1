package opgave3;

public class Mekaniker extends Ansat {
    private int årForSvendeprøve;

    public Mekaniker(String navn, String adresse, int årForSvendeprøve, double timelønssats) {
        super(navn, adresse, timelønssats);
        this.årForSvendeprøve = årForSvendeprøve;
    }

    public int getÅrForSvendeprøve() {
        return årForSvendeprøve;
    }

    public void setÅrForSvendeprøve(int årForSvendeprøve) {
        this.årForSvendeprøve = årForSvendeprøve;
    }

    public double beregnLoen(){
        return getTimelønssats() * 37;
    }

}
