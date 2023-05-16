package opgave4;

public class Rektangel extends Kvadrat {
    private int yLength;

    public Rektangel(int xCoordinate, int yCoordinate, int xLength, int yLength){
        super(xCoordinate, yCoordinate, xLength);
        this.yLength = yLength;
    }

    public int getyLength() {
        return yLength;
    }

    public void setyLength(int yLength) {
        this.yLength = yLength;
    }

    @Override
    public double beregnAreal() {
        return getxLength() * yLength;
    }
}
