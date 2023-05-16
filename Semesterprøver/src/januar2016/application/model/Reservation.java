package januar2016.application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Comparable<Reservation>{
    private LocalDate date;
    private LocalTime starttid;
    private Bane bane;
    private Medlem booker;
    private Medlem makker;

    Reservation(LocalDate date, LocalTime starttid, Bane bane, Medlem booker, Medlem makker){
        this.date = date;
        this.starttid = starttid;
        this.bane = bane;
        this.booker = booker;
        this.makker = makker;
        bane.addReservation(this);
    }

    @Override
    public int compareTo(Reservation reservation) {
        int comp = date.compareTo(reservation.getDate());
        if (comp == 0) {
            comp = starttid.compareTo(reservation.getStarttid());
        }
        if (comp == 0) {
            comp = bane.getNummer() - reservation.getBane().getNummer();
        }
        return comp;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStarttid() {
        return starttid;
    }

    public Bane getBane() {
        return bane;
    }

    public Medlem getBooker() {
        return booker;
    }

    public Medlem getMakker() {
        return makker;
    }

}
