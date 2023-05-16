package Svømmer;

import java.time.LocalDate;
import java.util.ArrayList;

public class SvømmerApp {
    public static void main(String[] args) {
        ArrayList<Double> tider = new ArrayList<Double>();
        tider.add(2.34);
        tider.add(2.11);
        tider.add(2.46);
        tider.add(1.54);

        Svømmer s1 = new Svømmer("Mathias", "Lyseng", LocalDate.of(1986, 4, 7), tider);

        System.out.println("Svømmerens bedste tid: " + s1.bedsteTid());
        System.out.println();
        System.out.println("Svømmerens gennemsnitlige tid: " + s1.gennemsnitAfTid());
        System.out.println();
        System.out.println("Svømmerens snit uden dårligste tid: " + s1.snitUdenDårligste());
    }
}
