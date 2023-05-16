package opgave4;

public abstract class Figur {
    private int xCoordinate;
    private int yCoordinate;

    public Figur(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void forskyd(int xAfstand, int yAfstand){
        xCoordinate += xAfstand;
        yCoordinate += yAfstand;
    }

    public String getLocation(){
        return "x: " + xCoordinate + ", y: " + yCoordinate;
    }

    public abstract double beregnAreal();
}
