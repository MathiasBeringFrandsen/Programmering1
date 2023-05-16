package Opgave1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FletningMain {

    public static ArrayList fletAlleKunder(ArrayList<Kunde> l1, ArrayList<Kunde> l2) {
        ArrayList<Kunde> alleKunder = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i).compareTo(l2.get(j)) <= 0) {
                alleKunder.add(l1.get(i));
                i++;
            } else {
                alleKunder.add(l2.get(j));
                j++;
            }
        }
        while (i < l1.size()) {
            alleKunder.add(l1.get(i));
            i++;
        }
        while (j < l2.size()) {
            alleKunder.add(l2.get(j));
            j++;
        }
        return alleKunder;
    }

    public static int[] fællesTal(int[] l1, int[] l2) {
        int[] temp = new int[l1.length + l2.length];
        int[] ensTal;
        int i = 0;
        int j = 0;
        int counter = 0;
        while (i < l1.length && j < l2.length) {
            if (l1[i] == l2[j]) {
                temp[counter] = l1[i];
                i++;
                j++;
                counter++;
            } else if (l1[i] < l2[j]) {
                i++;
            } else {
                j++;
            }
        }
        ensTal = new int[counter];
        System.arraycopy(temp, 0, ensTal, 0, ensTal.length);
        return ensTal;
    }

    public static ArrayList goodCustomers(ArrayList<Kunde> l1, Kunde[] l2) {
        ArrayList<Kunde> godeKunder = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.length) {
            if (l1.get(i).compareTo(l2[j]) == 0) {
                i++;
                j++;
            } else if (l1.get(i).compareTo(l2[j]) < 0) {
                godeKunder.add(l1.get(i));
                i++;
            } else {
                j++;
            }
        }
        while (i < l1.size()) {
            godeKunder.add(l1.get(i));
            i++;
        }
        return godeKunder;
    }

    public static void main(String[] args) {
        ArrayList<Kunde> c1 = new ArrayList<>();
        ArrayList<Kunde> c2 = new ArrayList<>();

        c1.add(new Kunde("Olesen", "Karl", 23));
        c1.add(new Kunde("Jensen", "Ulla", 42));
        c1.add(new Kunde("Mortensen", "Jens", 64));
        c1.add(new Kunde("Karlsen", "Ole", 43));
        c1.add(new Kunde("Nørskov", "Mads", 23));
        c1.add(new Kunde("Røv", "Torben", 34));
        c2.add(new Kunde("Hvam", "Frank", 36));
        c2.add(new Kunde("And", "Anders", 21));
        c2.add(new Kunde("Clapton", "Eric", 76));
        c2.add(new Kunde("Hendrix", "Jimi", 27));
        c2.add(new Kunde("King", "BB", 90));
        c2.add(new Kunde("Morrison", "Jim", 27));
        c2.add(new Kunde("Vaughan", "Stevie", 36));
        Collections.sort(c1);
        Collections.sort(c2);

        System.out.println(fletAlleKunder(c1, c2));
        System.out.println();

        int[] a1 = {2, 4, 6, 8, 10, 12, 14};
        int[] a2 = {1, 2, 4, 5, 6, 9, 12, 17};

        System.out.println(Arrays.toString(fællesTal(a1, a2)));
        System.out.println();

        Kunde[] c3 = {new Kunde("Morrison", "Jim", 27), new Kunde("Nørskov", "Mads", 23), new Kunde("Røv", "Torben", 34),
        new Kunde("Hvam", "Frank", 36), new Kunde("And", "Anders", 21), new Kunde("Clapton", "Eric", 76)};
        Arrays.sort(c3);
        System.out.println(Arrays.toString(c3));
        System.out.println(c2);
        System.out.println();
        System.out.println(goodCustomers(c2,c3));

    }
}
