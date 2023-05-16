package application.model;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<String> hunde = new ArrayList<>();
        hunde.add("Pax");
        hunde.add("Fido");
        hunde.add("Molly");
        hunde.add("Pluto");
        hunde.add("Juno");

        System.out.println(hunde);
        System.out.println();
        hunde.set(2, "King");
        hunde.remove(1);
        System.out.println(hunde);
        System.out.println();
        hunde.add(3, "Trine");
        hunde.add(0, "Bella");
        System.out.println(hunde);
        System.out.println();
        System.out.println("Der er " + hunde.size() + " hunde i listen.");
        System.out.println();

        int antalHunde = 0;
        for (String hund : hunde) {
            if (hund.length() == 5) {
                antalHunde++;
            }
        }
        System.out.println("Antal hunde med 5 bogstaver i navnet: " + antalHunde);
        System.out.println();

        for (int i = hunde.size() - 1; i >= 0; i--) {
            System.out.println(hunde.get(i));
        }

        System.out.println();

        for (int i = 0; i < hunde.size(); i = i + 2){
            System.out.println(hunde.get(i));
        }
    }
}
