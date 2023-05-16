package januar2016.application.controller;

import januar2016.application.model.Bane;
import januar2016.application.model.Medlem;
import januar2016.application.model.Reservation;
import januar2016.storage.Storage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

    public static Bane createBane(int nummer, String baneInfo) {
        Bane bane = new Bane(nummer, baneInfo);
        Storage.addBane(bane);
        return bane;
    }

    public static Medlem createMedlem(String navn, String mobil, String mail) {
        Medlem medlem = new Medlem(navn, mobil, mail);
        Storage.addMedlem(medlem);
        return medlem;
    }

    public static Reservation createReservation(Medlem booker, Medlem makker, Bane bane, LocalDate dato, LocalTime startTid) {
        Reservation reservation = null;
        if (!booker.hasAktivReservation() && !makker.hasAktivReservation()) {
            if (bane.isLedig(dato, startTid)) {
                reservation = booker.createReservation(dato, startTid, bane, makker);
            }
        }
        return reservation;
    }

    public static void writeLedigeTider(LocalDate dato, String filnavn){
        try {
            File file = new File(filnavn);
            PrintWriter printer = new PrintWriter(file);
            int i = 0;
            while (i < Storage.getBaner().size()){
               ArrayList<LocalTime> ledigeTider = Storage.getBaner().get(i).getLedigeTiderPaaDag(dato);
               i++;
               int j = 0;
               while (j < ledigeTider.size()){
                    printer.println(ledigeTider.get(j));
                    j++;
               }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    public static void initStorage() {
        Medlem lene = Controller.createMedlem("Lene Mikkelsen", "12345678", "lm@msn.com");
        Medlem finn = Controller.createMedlem("Finn Jensen", "22331144", "fj@msn.com");

        Bane b1 = createBane(1, "Nord/syd vendt");
        Bane b2 = createBane(2, "Under Egetræet");
        Bane b3 = createBane(3, "Med tilskuerpladser");
    }

}
