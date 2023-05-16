package application.controller;

import application.model.*;
import storage.Storage;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Festival createFestival(String navn, LocalDate fraDato, LocalDate tilDato) {
        Festival festival = new Festival(navn, fraDato, tilDato);
        Storage.addFestival(festival);
        return festival;
    }

    public static Frivillig createFrivillig(String navn, String mobil, int maksAntalTimer) {
        Frivillig frivillig = new Frivillig(navn, mobil, maksAntalTimer);
        Storage.addFrivillig(frivillig);
        return frivillig;
    }

    public static FrivilligForening createfrivilligForening(String navn, String mobil, int maksAntalTimer, String foreningsNavn, int antalPersoner) {
        FrivilligForening forening = new FrivilligForening(navn, mobil, maksAntalTimer, foreningsNavn, antalPersoner);
        Storage.addFrivillig(forening);
        return forening;
    }

    public static Vagt tagVagt(Job job, Frivillig frivillig, int timer) {
        Vagt vagt;
        if (job.getAntalTimer() < timer) {
            throw new RuntimeException("Der er ikke nok antal timer tilbage i jobbet");
        }
        if (frivillig.getMaksAntalTimer() < timer) {
            throw new RuntimeException("Den frivillige har ikke nok timer ledige til at påtage sig dette job");
        } else {
            vagt = job.createVagt(timer, frivillig);
            job.setAntalTimer(job.getAntalTimer() - timer);
        }
        return vagt;
    }

    public static boolean findfrivillig(Festival festival, String navn) {
        boolean found = false;
        ArrayList<Frivillig> frivilligeMedGaver = festival.gaverTilFrivillige();
        int left = 0;
        int right = festival.gaverTilFrivillige().size() - 1;
        while (!found && left <= right) {
            int middle = (left + right) / 2;
            int comp = frivilligeMedGaver.get(middle).getNavn().compareTo(navn);
            if (comp == 0) {
                found = true;
            } else if (comp > 0)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return found;
    }


    public static void initStorage() {
        Festival northside = Controller.createFestival("Northside", LocalDate.of(2020, 06, 04), LocalDate.of(2020, 06, 06));

        Controller.createFrivillig("Jane Jensen", "12345677", 20);
        Controller.createFrivillig("Lone Hansen", "78787878", 25);
        Controller.createFrivillig("Anders Mikkelsen", "55555555", 10);

        Controller.createfrivilligForening("Christian Madsen", "23232323", 100, "Erhvervsakademi Aarhus", 40);

        northside.createJob("T1", "Rengøring af toilet", LocalDate.of(2020, 06, 04), 100, 5);
        northside.createJob("T2", "Rengøring af toilet", LocalDate.of(2020, 06, 04), 100, 5);
        northside.createJob("T3", "Rengøring af toilet", LocalDate.of(2020, 06, 04), 100, 5);
        northside.createJob("T4", "Rengøring af toilet", LocalDate.of(2020, 06, 05), 100, 5);
        northside.createJob("T5", "Rengøring af toilet", LocalDate.of(2020, 06, 05), 100, 5);
        northside.createJob("T6", "Rengøring af toilet", LocalDate.of(2020, 06, 05), 100, 5);
        northside.createJob("T7", "Rengøring af toilet", LocalDate.of(2020, 06, 06), 100, 5);
        northside.createJob("T8", "Rengøring af toilet", LocalDate.of(2020, 06, 06), 100, 5);
        northside.createJob("T9", "Rengøring af toilet", LocalDate.of(2020, 06, 06), 100, 5);
    }

}
