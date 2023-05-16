package Opgave123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KundeApp {
    private ArrayList<Kunde> kunder = new ArrayList<>();

    public static void indsætKunde(ArrayList<Kunde> kunder, Kunde kunde) {
        int i = 0;
        boolean found = false;
        while (!found && i < kunder.size()) {
            if (kunde.compareTo(kunder.get(i)) < 0) {
                found = true;
            } else {
                i++;
            }
        }
        kunder.add(i, kunde);
    }

    public static void indsætKunde(Kunde[] kunder, Kunde kunde) {
        int i = kunder.length - 1;
        while (i >= 0 && kunder[i] == null) {
            i--;
        }
        i++;
        boolean found = false;
        while (!found && i > 0) {
            if (kunde.compareTo(kunder[i - 1]) > 0) {
                found = true;
            } else {
                kunder[i] = kunder[i - 1];
                i--;
            }
        }
        kunder[i] = kunde;
    }

    public static boolean numberOfCharsInARow(String s, int k) {
        boolean found = false;
        int i = 0;
        while (!found && i <= s.length() - k) {
            if (match(s, i, k)) {
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }

    public static boolean match(String s, int index, int k) {
        boolean foundDiff = false;
        int j = 1;
        while (!foundDiff && j < k) {
            if (s.charAt(index) != s.charAt(index + j)) {
                foundDiff = true;
            } else {
                j++;
            }
        }
        return !foundDiff;
    }

    public static void main(String[] args) {
        ArrayList<Kunde> customers = new ArrayList<>();
        customers.add(new Kunde("Nørskov", "Mads", 23));
        customers.add(new Kunde("Bering", "Mathias", 35));
        customers.add(new Kunde("Andrei", "Alin", 21));
        customers.add(new Kunde("Røv", "Torben", 92));
        Collections.sort(customers);

        System.out.println(customers);
        indsætKunde(customers, new Kunde("Bølle", "Bob", 17));
        System.out.println(customers);

        System.out.println();


        Kunde[] kunder = new Kunde[10];
        kunder[0] = new Kunde("Clapton", "Eric", 76);
        kunder[1] = new Kunde("Hendrix", "Jimi", 27);
        kunder[2] = new Kunde("King", "BB", 90);
        kunder[3] = new Kunde("Morrison", "Jim", 27);
        kunder[4] = new Kunde("Vaughan", "Stevie", 36);

        System.out.println(Arrays.toString(kunder));
        indsætKunde(kunder, new Kunde("Joplin", "Janis", 27));
        System.out.println(Arrays.toString(kunder));

        System.out.println();

        System.out.println(numberOfCharsInARow("Jubiiii", 4));
    }
}
