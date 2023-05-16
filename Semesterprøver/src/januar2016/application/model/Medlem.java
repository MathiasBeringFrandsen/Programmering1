package januar2016.application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {
    private String navn;
    private String mobil;
    private String mail;
    private final ArrayList<Reservation> reservationer = new ArrayList<>();

    public Medlem(String navn, String mobil, String mail){
        this.navn = navn;
        this.mobil = mobil;
        this.mail = mail;
    }

    public Reservation createReservation(LocalDate date, LocalTime starttid, Bane bane, Medlem makker){
        Reservation reservation = new Reservation(date, starttid, bane, this, makker);
        reservationer.add(reservation);
        reservation.getMakker().reservationer.add(reservation);
        return reservation;
    }

    public boolean hasAktivReservation(){
        boolean aktiv = false;
        int i = 0;
        while (!aktiv && i < reservationer.size()){
            if (reservationer.get(i).getDate().isAfter(LocalDate.now())){
                aktiv = true;
            } else if (reservationer.get(i).getDate().isEqual(LocalDate.now())){
                if (reservationer.get(i).getStarttid().isAfter(LocalTime.now())){
                    aktiv = true;
                }
            }
            i++;
        }
        return aktiv;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public String getMail() {
        return mail;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation(Reservation reservation){
        if (!reservationer.contains(reservation)){
            reservationer.add(reservation);
        }
    }

}
