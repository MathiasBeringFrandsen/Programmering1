package januar2018.application.model;

import java.util.ArrayList;

public class Tutor {
    private String navn;
    private String email;
    private Hold hold;
    private ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public Hold getHold() {
        return hold;
    }

    public void setHold(Hold hold) {
        this.hold = hold;
    }

    public ArrayList<Arrangement> getArrangementer() {
        return arrangementer;
    }

    public void addArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    public void removeArrangement(Arrangement arrangement) {
        arrangementer.remove(arrangement);
    }

    public double arrangementsPris() {
        double totalPris = 0;
        for (Arrangement arrangement : arrangementer) {
            totalPris += arrangement.getPris();
        }
        return totalPris;
    }

    public boolean overlap(Arrangement arrangement) {
        boolean isOverlap = false;
        for (Arrangement arrangement1 : arrangementer) {
            if (arrangement.getDate().equals(arrangement1.getDate())) {
                if (arrangement.getStartTid().isBefore(arrangement1.getSlutTid()) && arrangement1.getStartTid().isBefore(arrangement.getSlutTid())) {
                    isOverlap = true;
                }
            }
        }
        return isOverlap;
    }

    public String toString(){
        return navn + " " + email;
    }
}
