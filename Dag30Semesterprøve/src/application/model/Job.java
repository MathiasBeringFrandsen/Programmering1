package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Job {
    private String kode;
    private String beskrivelse;
    private LocalDate dato;
    private int timeHonorar;
    private int antalTimer;
    private ArrayList<Vagt> vagter = new ArrayList<>();

    Job(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        this.kode = kode;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.timeHonorar = timeHonorar;
        this.antalTimer = antalTimer;
    }

    public String getKode() {
        return kode;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getTimeHonorar() {
        return timeHonorar;
    }

    public int getAntalTimer() {
        return antalTimer;
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public void setAntalTimer(int timer){
        this.antalTimer = timer;
    }

    public Vagt createVagt(int timer, Frivillig frivillig) {
        Vagt vagt = new Vagt(timer, frivillig, this);
        vagter.add(vagt);
        frivillig.setMaksAntalTimer(frivillig.getMaksAntalTimer() - timer);
        return vagt;
    }

    public int ikkeBesatteTimer() {
        int ledigeTimer = 0;
        for (Vagt vagt : vagter){
            if (vagt.getFrivillig() == null){
                ledigeTimer += vagt.getTimer();
            }
        }
        return ledigeTimer;
    }

    public String toString(){
        return kode + " " + beskrivelse + " " + antalTimer;
    }
}
