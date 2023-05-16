package application.model;

public class Deltagelse {
    private boolean afbud;
    private String begrundelse;
    private Spiller spiller;

    public Deltagelse(Spiller spiller, Kamp kamp){
        this.afbud = false;
        this.begrundelse = "";
        this.spiller = spiller;
    }

    public boolean isAfbud() {
        return afbud;
    }

    public String getBegrundelse() {
        return begrundelse;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public void setAfbud(boolean afbud) {
        this.afbud = afbud;
    }

    public void setBegrundelse(String begrundelse) {
        this.begrundelse = begrundelse;
    }
}
