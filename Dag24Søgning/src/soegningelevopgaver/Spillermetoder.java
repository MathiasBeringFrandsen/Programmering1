package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        Spiller højestScorende = spillere.get(0);
        boolean found = false;
        int i = 1;
        while (!found && i < spillere.size()) {
            if (højestScorende.getMaal() == score) {
                found = true;
            } else {
                højestScorende = spillere.get(i);
                i++;
            }
        }
        if (!found) {
            højestScorende = null;
        }
        return højestScorende;
    }

    public Spiller findScoreBinær(ArrayList<Spiller> spillere, int score) {
        boolean found = false;
        Spiller højestScorende = null;
        int left = 0;
        int right = spillere.size() - 1;
        while (!found && left <= right) {
            int middle = (left + right) / 2;
            Spiller k = spillere.get(middle);
            if (k.getMaal() == score) {
                højestScorende = k;
                found = true;
            } else if (k.getMaal() < score) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return højestScorende;
    }

    public String godSpiller(ArrayList<Spiller> spillere) {
        String name = "";
        int i = 0;
        while (name.equals("") && i < spillere.size()) {
            Spiller k = spillere.get(i);
            if (k.getMaal() > 50 && k.getHoejde() < 170) {
                name = k.getNavn();
            } else {
                i++;
            }
        }
        return name;
    }

    // Her tilføjes metoder der løser opgve 4.2 og 4.3

    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 169, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));

        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));

        System.out.println();

        ArrayList<Spiller> sortedSpillerListe = new ArrayList<>();
        sortedSpillerListe.add(new Spiller("Finn", 194, 102, 12));
        sortedSpillerListe.add(new Spiller("Jens", 188, 109, 32));
        sortedSpillerListe.add(new Spiller("Lars", 192, 86, 35));
        sortedSpillerListe.add(new Spiller("Mads", 200, 103, 37));
        sortedSpillerListe.add(new Spiller("Hans", 196, 99, 45));
        sortedSpillerListe.add(new Spiller("Bo", 203, 89, 60));

        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreBinær(sortedSpillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreBinær(sortedSpillerListe, 30));

        System.out.println();

        System.out.println("Spiller der er mindre end 170 cm og har scoret mere end 50 mål: " + metoder.godSpiller(spillerListe));
        // Tilføj kode der afprøver opgaver 4.2 og 4.3
    }

}
