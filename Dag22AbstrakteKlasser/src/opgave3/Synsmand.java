package opgave3;

public class Synsmand extends Mekaniker {
    private int syn;
    private double tillægPerSyn;


    public Synsmand(String navn, String adresse, int årForSvendeprøve, double timelønssats, int syn, double tillægPerSyn){
        super(navn, adresse, årForSvendeprøve, timelønssats);
        this.syn = syn;
        this.tillægPerSyn = tillægPerSyn;
    }

    public int getSyn() {
        return syn;
    }

    public void setSyn(int syn) {
        this.syn = syn;
    }

    public double getTillægPerSyn() {
        return tillægPerSyn;
    }

    public void setTillægPerSyn(double tillægPerSyn) {
        this.tillægPerSyn = tillægPerSyn;
    }

    @Override
    public double beregnLoen() {
        return super.beregnLoen() + syn * tillægPerSyn;
    }
}
