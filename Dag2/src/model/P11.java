package model;
import javax.swing.JOptionPane;

public class P11 {
    public static void main(String[] args) {
        int mpg = 52;
        int gas = 4;
        double carMaintenance = 0.05;
        int trainTicket = Integer.parseInt(JOptionPane.showInputDialog("Hvad koster en togbilet?"));
        int distanceToWork = Integer.parseInt(JOptionPane.showInputDialog("Hvor langt har du til arbejde?"));
        double priceOfDriving = ((distanceToWork*2) / mpg * gas) + ((distanceToWork*2) * carMaintenance);
        if (priceOfDriving < trainTicket) {
            System.out.println("Tag Bilen!");
        }
        else {
            System.out.println("Tag Toget");
        }
    }
}

