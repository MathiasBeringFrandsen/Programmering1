package application.controller;

import application.model.*;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Løb createLøb(LocalDate dato, String sted, int normalPris, LocalDate earlyBirdDate, int earlyBirdPris) {
        Løb løb = new Løb(dato, sted, normalPris, earlyBirdDate, earlyBirdPris);
        Storage.addLøb(løb);
        return løb;
    }

    public static Forhindring createForhindring(int nummer, String navn) {
        Forhindring forhindring = new Forhindring(nummer, navn);
        Storage.addForhindring(forhindring);
        return forhindring;
    }

    public static void addForhindringTilLøb(Forhindring forhindring, Løb løb) {
        løb.addForhindring(forhindring);
    }

    public static Tilmelding createTilmelding(String navn, boolean kvinde, LocalDate tilmeldingsdato, Løb løb) {
        Tilmelding tilmelding = løb.createTilmelding(navn, kvinde, tilmeldingsdato);
        return tilmelding;
    }

    public static void createNote(String navn, int strafSekunder, Tilmelding tilmelding) {
        tilmelding.registrerStrafPåForhindring(navn, strafSekunder);
    }

    public static String Vinder(Løb løb) {
        String vinder = løb.winner();
        return vinder;
    }

    public static void resultaterTilFil(Løb løb, String filNavn) {
        try {
            File file = new File(filNavn);
            PrintWriter printer = new PrintWriter(file);
            ArrayList<Tilmelding> gennemført = løb.listeOverGennemført();
            int i = 0;
            while (i < gennemført.size()) {
                printer.println(gennemført.get(i));
                i++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void initStorage() {
        Løb l1 = Controller.createLøb(LocalDate.of(2021, 8, 23), "Hasle bakker", 500, LocalDate.of(2021, 6, 23), 350);

        Forhindring f1 = Controller.createForhindring(1, "Stejl bakke");
        Forhindring f2 = Controller.createForhindring(2, "Meget stejl bakke");
        Forhindring f3 = Controller.createForhindring(3, "Mudderpøl");
        Forhindring f4 = Controller.createForhindring(4, "Over mur");
        Forhindring f5 = Controller.createForhindring(5, "Under gitter");

        Controller.addForhindringTilLøb(f1, l1);
        Controller.addForhindringTilLøb(f2, l1);
        Controller.addForhindringTilLøb(f3, l1);
        Controller.addForhindringTilLøb(f4, l1);
        Controller.addForhindringTilLøb(f5, l1);

        Tilmelding t1 = Controller.createTilmelding("Sune", false, LocalDate.of(2021, 5, 12), l1);
        Tilmelding t2 = Controller.createTilmelding("Anne", true, LocalDate.of(2021, 7, 12), l1);
        Tilmelding t3 = Controller.createTilmelding("Bent", false, LocalDate.of(2021, 7, 14), l1);
        Tilmelding t4 = Controller.createTilmelding("Ole", false, LocalDate.of(2021, 5, 10), l1);
        Tilmelding t5 = Controller.createTilmelding("Lars", false, LocalDate.of(2021, 4, 18), l1);
        Tilmelding t6 = Controller.createTilmelding("Mette", true, LocalDate.of(2021, 8, 20), l1);

        t1.setLøbstid(8733);
        t2.setLøbstid(9132);
        Controller.createNote("Over mur", 90, t2);
        t4.setLøbstid(8280);
        Controller.createNote("Over mur", 220, t4);
        t5.setLøbstid(9126);
        Controller.createNote("Over mur", 180, t5);
        Controller.createNote("Under Gitter", 410, t5);
        t6.setLøbstid(12732);
    }

}
