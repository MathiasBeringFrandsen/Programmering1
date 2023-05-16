package application.model;

import java.util.ArrayList;

public class Parkeringshus {
    private String adresse;
    private int saldo;
    private final ArrayList<Parkeringsplads> parkeringspladser = new ArrayList<>();

    public Parkeringshus(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public int getSaldo() {
        return saldo;
    }

    public Parkeringsplads createParkeringsplads(int nummer) {
        Parkeringsplads parkeringsplads = new Parkeringsplads(nummer);
        parkeringsplads.setParkeringshus(this);
        parkeringspladser.add(parkeringsplads);
        return parkeringsplads;
    }

    public Invalideplads createInvalideplads(int nummer, double areal) {
        Invalideplads invalideplads = new Invalideplads(nummer, areal);
        invalideplads.setParkeringshus(this);
        parkeringspladser.add(invalideplads);
        return invalideplads;
    }

    public void removeParkeringsplads(Parkeringsplads parkeringsplads) {
        parkeringsplads.setParkeringshus(null);
        parkeringspladser.remove(parkeringsplads);
    }

    public void removeInvalideplads(Invalideplads invalideplads) {
        invalideplads.setParkeringshus(null);
        parkeringspladser.remove(invalideplads);
    }

    public ArrayList<Parkeringsplads> getParkeringspladser() {
        return new ArrayList<>(parkeringspladser);
    }

    public int antalLedigePladser() {
        int tommepladser = 0;
        for (Parkeringsplads pPlads : parkeringspladser) {
            if (pPlads.getBil() == null) {
                tommepladser++;
            }
        }
        return tommepladser;
    }

    public int findPladsMedBil(String regNr) {
        int plads = -1;
        int i = 0;
        while (plads == -1) {
            if (parkeringspladser.get(i).getBil() != null) {
                if (parkeringspladser.get(i).getBil().getRegNr().equalsIgnoreCase(regNr)) {
                    plads = parkeringspladser.get(i).getNummer();
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return plads;
    }

    public void setSaldo(int saldo) {
        this.saldo += saldo;
    }

    public int findAntalBiler(Bilmærke mærke) {
        int antalBiler = 0;
        for (Parkeringsplads parkeringsplads : parkeringspladser) {
            if (parkeringsplads.getBil() != null) {
                if (parkeringsplads.getBil().getBilmærke().equals(mærke)) {
                    antalBiler++;
                }
            }
        }
        return antalBiler;
    }

    public ArrayList<String> optagnePladser(){
        ArrayList<String> pladserMedBiler = new ArrayList<>();
        for (Parkeringsplads pPlads : parkeringspladser){
            if (pPlads.getBil() != null){
                String bil = "Plads " + pPlads.getNummer() + ": " + pPlads.getBil().getRegNr() + ", " + pPlads.getBil().getBilmærke();
                pladserMedBiler.add(bil);
            }
        }
        return  pladserMedBiler;
    }

    public String toString(){
        return adresse;
    }

}
