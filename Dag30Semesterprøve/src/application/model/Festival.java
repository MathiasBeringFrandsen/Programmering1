package application.model;

import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {
    private String navn;
    private LocalDate fraDato;
    private LocalDate tilDato;
    private final ArrayList<Job> jobs = new ArrayList<>();

    public Festival(String navn, LocalDate fraDato, LocalDate tilDato) {
        this.navn = navn;
        this.fraDato = fraDato;
        this.tilDato = tilDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public ArrayList<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    public Job createJob(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        Job job = new Job(kode, beskrivelse, dato, timeHonorar, antalTimer);
        jobs.add(job);
        return job;
    }

    public int budgetteretJobUdgift() {
        int samletUdgift = 0;
        for (Job job : jobs) {
            samletUdgift += job.getAntalTimer() * job.getTimeHonorar();
        }
        return samletUdgift;
    }

    public int realiseretJobUdgift() {
        int realiseretUdgift = 0;
        for (Job job : jobs) {
            for (Vagt vagt : job.getVagter())
                realiseretUdgift += vagt.getTimer() * job.getTimeHonorar();
        }
        return realiseretUdgift;
    }

    public ArrayList<Frivillig> gaverTilFrivillige() {
        ArrayList<Frivillig> frivillige = new ArrayList<>();
        int i = 0;
        while (i < Storage.getFrivillige().size() - 1)
            if (Storage.getFrivillige().get(i).getVagter().get(0) != null) {
                if (Storage.getFrivillige().get(i).getNavn().compareTo(Storage.getFrivillige().get(i + 1).getNavn()) < 0) {
                    frivillige.add(Storage.getFrivillige().get(i));
                }
            } else {
                i++;
            }
        return frivillige;
    }

    public String toString(){
        return navn + " " + fraDato + " " + tilDato;
    }

}
