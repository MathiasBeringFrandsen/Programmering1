package opgave3;

public class Værkfører extends Ansat{
    private int årForSvendeprøve;
    private int udnævntVærkførerÅr;
    private double tillægPerUge;

    public Værkfører(String navn, String adresse, int årForSvendeprøve, double timelønssats, int udnævntVærkførerÅr, double tillægPerUge) {
        super(navn, adresse, timelønssats);
        this.årForSvendeprøve = årForSvendeprøve;
        this.udnævntVærkførerÅr = udnævntVærkførerÅr;
        this.tillægPerUge = tillægPerUge;
    }

    public int getÅrForSvendeprøve() {
        return årForSvendeprøve;
    }

    public void setÅrForSvendeprøve(int årForSvendeprøve) {
        this.årForSvendeprøve = årForSvendeprøve;
    }

    public int getUdnævntVærkførerÅr() {
        return udnævntVærkførerÅr;
    }

    public void setUdnævntVærkførerÅr(int udnævntVærkførerÅr) {
        this.udnævntVærkførerÅr = udnævntVærkførerÅr;
    }

    public double getTillægPerUge() {
        return tillægPerUge;
    }

    public void setTillægPerUge(double tillægPerUge) {
        this.tillægPerUge = tillægPerUge;
    }

    @Override
    public double beregnLoen() {
        return super.getTimelønssats() * 37 + tillægPerUge;
    }
}
