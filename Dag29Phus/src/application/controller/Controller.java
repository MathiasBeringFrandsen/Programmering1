package application.controller;

import application.model.*;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Controller {

    public static Parkeringshus createParkeringshus(String adresse) {
        Parkeringshus parkeringshus = new Parkeringshus(adresse);
        Storage.addParkeringshus(parkeringshus);
        return parkeringshus;
    }

    public static Parkeringsplads createParkeringsplads(int nummer, Parkeringshus parkeringshus) {
        Parkeringsplads parkeringsplads = parkeringshus.createParkeringsplads(nummer);
        return parkeringsplads;
    }

    public static Invalideplads createInvalideplads(int nummer, double areal, Parkeringshus parkeringshus) {
        Invalideplads invalideplads = parkeringshus.createInvalideplads(nummer, areal);
        return invalideplads;
    }

    public static Bil createBil(String regNr) {
        Bil bil = new Bil(regNr);
        return bil;
    }

    public static void writeOptagnePladser(Parkeringshus hus, String filnavn){
        try {
            File fileout = new File(filnavn);
            PrintWriter writer = new PrintWriter(fileout);
            int i = 0;
            ArrayList<String> biler = hus.optagnePladser();
            while (i < biler.size()){
                writer.println(biler.get(i));
                i++;
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void createSomeObjects() {
        Bil bil1 = Controller.createBil("AB 11 222");
        Bil bil2 = Controller.createBil("EF 33 444");
        Bil bil3 = Controller.createBil("BD 55 666");

        bil1.setBilmærke(Bilmærke.SKODA);
        bil2.setBilmærke(Bilmærke.TESLA);
        bil3.setBilmærke(Bilmærke.ATOM);

        Parkeringshus parkeringshus = Controller.createParkeringshus("Havnegade 12, 8000 Aarhus");

        for (int i = 1; i <= 100; i++) {
            Controller.createParkeringsplads(i,parkeringshus);
        }

        for (int i = 101; i <= 110 ; i++) {
            Controller.createInvalideplads(i, 18, parkeringshus);
        }

        parkeringshus.getParkeringspladser().get(1).setBil(bil1);
        parkeringshus.getParkeringspladser().get(60).setBil(bil2);
        parkeringshus.getParkeringspladser().get(101).setBil(bil3);

    }
}
