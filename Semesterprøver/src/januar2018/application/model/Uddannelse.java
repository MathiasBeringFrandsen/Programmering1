package januar2018.application.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Uddannelse {
    private String navn;
    private final ArrayList<Hold> holdene = new ArrayList<>();

    public Uddannelse(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public Hold createHold(String betegnelse, String holdleder) {
        Hold hold = new Hold(betegnelse, holdleder, this);
        holdene.add(hold);
        return hold;
    }

    public void addHold(Hold hold) {
        holdene.add(hold);
    }

    public ArrayList<Hold> getHold() {
        return new ArrayList<>(holdene);
    }

    public ArrayList<String> tutorOversigt() {
        ArrayList<String> tutorliste = new ArrayList<>();
        for (Hold hold : holdene) {
            int i = 0;
            while (i < hold.getTutors().size()) {
                tutorliste.add(hold.getTutors().get(i).getNavn() + "  " + this.navn + "   " + hold.getBetegnelse() +
                        "   " + hold.getTutors().get(i).getEmail() + "  " + hold.getHoldleder() + "\n");
                i++;
            }
        }
        return tutorliste;
    }

}
