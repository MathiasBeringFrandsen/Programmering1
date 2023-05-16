package øvelse;

public class Instructor extends Person {
    private double månedsløn;

    public Instructor(String navn, int fødselsår, int månedsløn) {
        super(navn, fødselsår);
        this.månedsløn = månedsløn;
    }

    public String toString() {
        return super.toString() + ", " + månedsløn;
    }
}
