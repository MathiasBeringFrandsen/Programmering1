package opgave4;

public class EllipseM extends Figur {
    private int r1;
    private int r2;

    public EllipseM(int xCor, int yCor, int r1, int r2) {
        super(xCor, yCor);
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public double beregnAreal() {
        return r1 * r2 * 3.14;
    }
}
