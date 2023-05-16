package application.model;

import java.util.ArrayList;

public class Frivillig {
    private String navn;
    private String mobil;
    private int maksAntalTimer;
    private final ArrayList<Vagt> vagter = new ArrayList<>();

    public Frivillig(String navn, String mobil, int maksAntalTimer) {
        this.navn = navn;
        this.mobil = mobil;
        this.maksAntalTimer = maksAntalTimer;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public int getMaksAntalTimer() {
        return maksAntalTimer;
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public void setMaksAntalTimer(int timer){
        this.maksAntalTimer = timer;
    }

    public void addVagt(Vagt vagt) {
        if (!vagter.contains(vagt)) {
            vagter.add(vagt);
        }
    }

    public int ledigeTimer() {
        int ledigeTimer = maksAntalTimer;
        for (Vagt vagt : vagter) {
            ledigeTimer -= vagt.getTimer();
        }
        return ledigeTimer;
    }

    public String toString() {
        return navn + " " + mobil + " " + maksAntalTimer;
    }

    public StringBuilder jobsOutput() {
        StringBuilder sbJobs = new StringBuilder();
        sbJobs.append(navn + "\nMaks timer der ønskes er " + maksAntalTimer + "\n");
        for (Vagt vagt : vagter) {
            sbJobs.append(vagt + "\n");
        }
        return sbJobs;
    }

}
