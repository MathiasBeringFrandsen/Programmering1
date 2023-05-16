package opgave3;

public class Arbejdsdreng extends Ansat{

    public Arbejdsdreng(String navn, String adresse, double timelønssats){
        super(navn, adresse, timelønssats);
    }

    @Override
    public double beregnLoen() {
        return getTimelønssats() * 25;
    }
}
