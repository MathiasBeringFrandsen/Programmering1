package opgave4;

public class Ellipse extends Cirkel {
    private int radius2;

    public Ellipse(int xCoordinate, int yCoordinate, int radius1, int radius2) {
        super(xCoordinate, yCoordinate, radius1);
        this.radius2 = radius2;
    }

    public int getRadius2() {
        return radius2;
    }

    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }

    @Override
    public double beregnAreal() {
        return getRadius1() * radius2 * 3.14;
    }
}
