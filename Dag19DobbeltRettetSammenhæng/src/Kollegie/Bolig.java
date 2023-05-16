package Kollegie;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bolig {
    private int kvm;
    private String adresse;
    private int prisPrMaaned;
    private final ArrayList<LejeAftale> lejeaftaler = new ArrayList<>();
    private Kollegie kollegie;

    public Bolig(int kvm, String adresse, int prisPrMaaned, Kollegie kollegie){
        this.kvm = kvm;
        this.adresse = adresse;
        this.prisPrMaaned = prisPrMaaned;
        this.kollegie = kollegie;
    }

    public int getKvm() {
        return kvm;
    }

    public void setKvm(int kvm) {
        this.kvm = kvm;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPrisPrMaaned() {
        return prisPrMaaned;
    }

    public void setPrisPrMaaned(int prisPrMaaned) {
        this.prisPrMaaned = prisPrMaaned;
    }

    public LejeAftale createLejeaftale(){
        LejeAftale lejeAftale = new LejeAftale(this);
        lejeaftaler.add(lejeAftale);
        return lejeAftale;
    }

    public ArrayList<LejeAftale> getLejeAftaler(){
        return new ArrayList<>(lejeaftaler);
    }

    public void opsigLejeAftale(LejeAftale lejeAftale){
        lejeAftale.setTilDato(LocalDate.now());
    }

    public void setKollegie(Kollegie kollegie){
        this.kollegie = kollegie;
    }

}
