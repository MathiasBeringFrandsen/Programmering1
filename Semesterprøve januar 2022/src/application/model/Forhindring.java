package application.model;

import java.util.ArrayList;

public class Forhindring {
    private int nummer;
    private String navn;
    private final ArrayList<Løb> løb = new ArrayList<>();

    public Forhindring(int nummer, String navn){
        this.nummer = nummer;
        this.navn = navn;
    }

    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Løb> getLøb() {
        return new ArrayList<>(løb);
    }

    private void addLøb(Løb løb){
        if (!this.løb.contains(løb)) {
            this.løb.add(løb);
        }
    }

    private void removeLøb(Løb løb){
        if (this.løb.contains(løb)){
            this.løb.remove(løb);
        }
    }

}
