package januar2018.application.controller;

import januar2018.application.model.Arrangement;
import januar2018.application.model.Hold;
import januar2018.application.model.Tutor;
import januar2018.application.model.Uddannelse;
import januar2018.storage.Storage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Uddannelse createUddanelse(String navn) {
        Uddannelse uddannelse = new Uddannelse(navn);
        Storage.addUddannelse(uddannelse);
        return uddannelse;
    }

    public static Hold createHold(String betegnelse, String holdleder, Uddannelse uddannelse) {
        Hold hold = uddannelse.createHold(betegnelse, holdleder);
        return hold;
    }

    public static Tutor createTutor(String navn, String email) {
        Tutor tutor = new Tutor(navn, email);
        Storage.addTutor(tutor);
        return tutor;
    }

    public static Arrangement createArrangement(String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double pris) {
        Arrangement arrangement = new Arrangement(titel, date, startTid, slutTid, pris);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static void addTutorTooHold(Tutor tutor, Hold hold) {
        tutor.setHold(hold);
        if (!hold.getTutors().contains(tutor)) {
            hold.addTutor(tutor);
        }
    }

    public static void addArrangementToTutor(Tutor tutor, Arrangement arrangement) {
        if (tutor.overlap(arrangement)) {
            throw new RuntimeException("Tutor er allerede på anden aktivitet der overlapper med denne.");
        } else {
            tutor.addArrangement(arrangement);
        }
    }

    public static void fjernArrangementFraTutor(Tutor tutor, Arrangement arrangement) {
        if (tutor.getArrangementer().contains(arrangement)) {
            tutor.removeArrangement(arrangement);
        }
    }

    public static ArrayList<Hold> holdUdenTutorer() {
        ArrayList<Hold> holdUdenTutorer = new ArrayList<>();
        for (Uddannelse uddannelse : Storage.getUddannelser()) {
            for (Hold hold : uddannelse.getHold()) {
                if (hold.getTutors().size() == 0) {
                    holdUdenTutorer.add(hold);
                }
            }
        }
        return holdUdenTutorer;
    }

    public static void tutorOversigtTilFil(String filnavn) {
        try {
            File file = new File(filnavn);
            PrintWriter out = new PrintWriter(file);
            int i = 0;
            while (i < Storage.getUddannelser().size()) {
                ArrayList<String> printliste = Storage.getUddannelser().get(i).tutorOversigt();
                int j = 0;
                while (j < printliste.size()) {
                    out.println(printliste.get(j));
                    j++;
                }
                i++;
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void initStorage() {
        Uddannelse dmu = Controller.createUddanelse("DMU");
        Uddannelse finø = Controller.createUddanelse("FINØ");

        Hold h1 = dmu.createHold("1dmE17S", "Margrethe Dybdal");
        Hold h2 = dmu.createHold("1dmE17T", "Kristian Dorland");
        Hold h3 = dmu.createHold("1dmE17U", "Kell Ørhøj");
        Hold h4 = finø.createHold("1fiE17B", "Karen Jensen");

        Tutor t1 = Controller.createTutor("Anders Hansen", "aaa@students.eaaa.dk");
        Tutor t2 = Controller.createTutor("Peter Jensen", "ppp@students.eaaa.dk");
        Tutor t3 = Controller.createTutor("Niels Madsen", "nnn@students.eaaa.dk");
        Tutor t4 = Controller.createTutor("Lone Andersen", "lll@students.eaaa.dk");
        Tutor t5 = Controller.createTutor("Mads Miller", "mmm@students.eaaa.dk");

        Arrangement rusfest = Controller.createArrangement("Rusfest", LocalDate.of(2017, 8, 31), LocalTime.of(18, 00), LocalTime.of(23, 30), 250);
        Arrangement fodbold = Controller.createArrangement("Fodbold", LocalDate.of(2017, 8, 30), LocalTime.of(14, 00), LocalTime.of(17, 30), 100);
        Arrangement brætspil = Controller.createArrangement("Brætspil", LocalDate.of(2017, 8, 29), LocalTime.of(12, 00), LocalTime.of(16, 30), 25);
        Arrangement mindeparken = Controller.createArrangement("Mindeparken", LocalDate.of(2017, 8, 30), LocalTime.of(18, 00), LocalTime.of(22, 00), 25);

        Controller.addTutorTooHold(t1, h1);
        Controller.addTutorTooHold(t4, h1);
        Controller.addTutorTooHold(t2, h2);
        Controller.addTutorTooHold(t3, h2);
        Controller.addTutorTooHold(t5, h3);

        Controller.addArrangementToTutor(t1, rusfest);
        Controller.addArrangementToTutor(t2, rusfest);
        Controller.addArrangementToTutor(t3, rusfest);
        Controller.addArrangementToTutor(t3, fodbold);
        Controller.addArrangementToTutor(t3, brætspil);
        Controller.addArrangementToTutor(t4, brætspil);
        Controller.addArrangementToTutor(t1, mindeparken);
        Controller.addArrangementToTutor(t5, mindeparken);
    }

}