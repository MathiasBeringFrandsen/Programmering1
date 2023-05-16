package application.model;

import java.util.ArrayList;

public class Spiller {
    private String navn;
    private int årgang;
    private final ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Spiller(String navn, int årgang) {
        this.navn = navn;
        this.årgang = årgang;
    }

    public String getNavn() {
        return navn;
    }

    public int getÅrgang() {
        return årgang;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public double kampHonorar() {
        double honorar = 0;
        int tilmeldelser = 0;
        for (Deltagelse deltagelse : deltagelser) {
            if (!deltagelse.isAfbud()) {
                tilmeldelser++;
            }
        }
        honorar = tilmeldelser * 10;
        return honorar;
    }



}
