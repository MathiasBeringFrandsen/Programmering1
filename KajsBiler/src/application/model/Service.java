package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Service {

    //Link Attributes
    private Værksted værksted;
    private Bil bil;

    //Instance Variables
    private LocalDate startDato;
    private LocalDate slutDato;
    private int id;
    private final ArrayList<String> opgaver = new ArrayList<>();


    public Service(LocalDate startDato, LocalDate slutDato, int id, Bil bil){
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.id = id;
    }



    public void setVærksted(Værksted værksted){
        if(this.værksted != værksted){
            this.værksted = værksted;
            værksted.addService(this);
        }
    }

    public Værksted getVærksted(){return værksted;}

    public Bil getBil(){return bil;}

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
