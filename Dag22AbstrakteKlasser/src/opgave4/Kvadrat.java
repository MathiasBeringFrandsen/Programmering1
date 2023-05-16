package opgave4;

public class Kvadrat extends Figur {
    private int xLength;

    public Kvadrat(int xCoordinate, int yCoordinate, int xLength) {
        super(xCoordinate, yCoordinate);
        this.xLength = xLength;
    }

    public int getxLength() {
        return xLength;
    }

    public void setxLength(int xLength) {
        this.xLength = xLength;
    }

    public double beregnAreal() {
        return xLength * 2;
    }

}
