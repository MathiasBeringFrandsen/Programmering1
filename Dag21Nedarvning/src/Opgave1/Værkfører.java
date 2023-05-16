package Opgave1;

public class Værkfører extends Mekaniker{
    private int udnævntVærkførerÅr;
    private double tillægPerUge;

    public Værkfører(String navn, String adresse, int årForSvendeprøve, double timelønssats, int udnævntVærkførerÅr, double tillægPerUge){
        super(navn, adresse, årForSvendeprøve, timelønssats);
        this.udnævntVærkførerÅr = udnævntVærkførerÅr;
        this.tillægPerUge = tillægPerUge;
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
        return super.beregnLoen() + tillægPerUge;
    }
}
