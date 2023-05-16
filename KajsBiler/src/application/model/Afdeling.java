package application.model;

import java.util.ArrayList;

public class Afdeling {
    private String adresse;
    private int tlfnr;
    private String email;
    private final ArrayList<Udlejning> udlejninger = new ArrayList<>();

    public Afdeling(String adresse, int tlfnr, String email) {
        this.adresse = adresse;
        this.tlfnr = tlfnr;
        this.email = email;
    }
    //Getter & Setter
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTlfnr() {
        return tlfnr;
    }

    public void setTlfnr(int tlfnr) {
        this.tlfnr = tlfnr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //Getter & Setter
    //Link
    public ArrayList<Udlejning> getUdlejninger(){
        return new ArrayList<>(udlejninger);
    }

    public void addUdlejning(Udlejning udlejning){
        if(!udlejninger.contains(udlejning)){
            udlejninger.add(udlejning);
            udlejning.setAfdeling(this);
        }
    }
}
