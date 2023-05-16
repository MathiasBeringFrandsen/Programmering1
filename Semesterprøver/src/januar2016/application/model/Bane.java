package januar2016.application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    private int nummer;
    private String baneInfo;
    private final ArrayList<Reservation> reservationer = new ArrayList<>();

    public Bane(int nummer, String baneInfo) {
        this.nummer = nummer;
        this.baneInfo = baneInfo;
    }

    public int getNummer() {
        return nummer;
    }

    public String getBaneInfo() {
        return baneInfo;
    }

//    public void addReservation(Reservation reservation){
//        reservationer.add(reservation);
//    }

    public void addReservation(Reservation reservation){
        int i = 0;
        boolean found = false;
        while (!found && i < reservationer.size()) {
            if (reservation.compareTo(reservationer.get(i)) < 0) {
                found = true;
            } else {
                i++;
            }
        }
        reservationer.add(i, reservation);
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public boolean isLedig(LocalDate dato, LocalTime tid) {
        boolean ledig = true;
        int i = 0;
        while (ledig && i < reservationer.size()) {
            if (reservationer.get(i).getDate().equals(dato)) {
                if (reservationer.get(i).getStarttid().equals(tid)) {
                    ledig = false;
                }
            }
            i++;
        }
        return ledig;
    }


    public ArrayList<LocalTime> getLedigeTiderPaaDag(LocalDate dato) {
        ArrayList<LocalTime> ledigeTider = new ArrayList<>();
        for (int i = 6; i < 23; i++){
            if (isLedig(dato, LocalTime.of(i,0))){
                ledigeTider.add(LocalTime.of(i,0));
            }
        }
            return ledigeTider;
    }

}
