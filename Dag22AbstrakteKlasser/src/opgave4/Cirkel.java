package opgave4;


public class Cirkel extends Figur {
    private int radius1;

    public Cirkel(int xCoordinate, int yCoordinate, int radius1) {
        super(xCoordinate, yCoordinate);
        this.radius1 = radius1;
    }

    public int getRadius1() {
        return radius1;
    }

    public void setRadius1(int radius1) {
        this.radius1 = radius1;
    }

    @Override
    public double beregnAreal() {
        return radius1 * radius1 * 3.14;
    }
}
