package Opgave4;

public class RadiatorApp {

    public static void main(String[] args) {
        Radiator radiator1 = new Radiator();
        Radiator radiator2 = new Radiator(22);
        System.out.println("Radiator1 start temperatur: " + radiator1.getTemperature());
        radiator1.skruOp(5);
        System.out.println("Skru 5 op: " + radiator1.getTemperature());
        radiator1.skruNed(8);
        System.out.println("Skru 8 ned: " + radiator1.getTemperature());
        System.out.println();
        System.out.println("Radiator2 start temperatur: " + radiator2.getTemperature());
        radiator2.skruNed(17);
        System.out.println("Skru 17 ned: " + radiator2.getTemperature());
        radiator2.skruOp(33);
        System.out.println("Skru 33 op: " + radiator2.getTemperature());
    }
}
