package Svømmer;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Modellerer en svømmer
 */
public class Svømmer {
    private String navn;
    private String klub;
    private LocalDate fødselsdag;
    private ArrayList<Double> tider;

    /**
     * Initialiserer en ny svømmer med navn, fødselsdag, klub
     * og tider.
     * Pre: længden af tider er mindst 2
     */
    public Svømmer(String navn, String klub, LocalDate fødselsdag, ArrayList<Double> tider) {
        this.navn = navn;
        this.klub = klub;
        this.fødselsdag = fødselsdag;
        this.tider = tider;
    }

    /**
     * Returnerer svømmerens navn.
     */
    public String getNavn() {
        return navn;
    }

    /**
     * Returnerer svømmerens årgang.
     */
    public int getYearBorn() {
        return fødselsdag.getYear();
    }

    /**
     * Returnerer svømmerens klub.
     */
    public String getKlub() {
        return klub;
    }

    /**
     * Registrerer svømmerens klub
     *
     * @param klub
     */
    public void setKlub(String klub) {
        this.klub = klub;
    }

    /**
     * Returnerer den hurtigste tid svømmeren har opnået
     * Pre: Der er registreret mindst to tider for svømmeren
     */
    public double bedsteTid() {
        double hurtigsteTid = tider.get(0);
        for (int i = 1; i < tider.size(); i++) {
            if (tider.get(i) < hurtigsteTid) {
                hurtigsteTid = tider.get(i);
            }
        }
        return hurtigsteTid;
    }

    /**
     * Returnerer gennemsnittet af de tider svømmeren har
     * opnået
     * Pre: Der er registreret mindst to tider for svømmeren
     */
    public double gennemsnitAfTid() {
        double gennemsnitligTid = 0;
        for (int i = 0; i < tider.size(); i++) {
            gennemsnitligTid = gennemsnitligTid + tider.get(i);
        }
        gennemsnitligTid = gennemsnitligTid / tider.size();
        return gennemsnitligTid;
    }

    /**
     * Returnerer gennemsnittet af de tider svømmeren har
     * opnået i det den langsomste tid ikke er medregnet
     * Pre: Der er registreret mindst to tider for svømmeren
     */
    public double snitUdenDårligste() {
        double værsteTid = tider.get(0);
        double totaltid = 0;
        for (int i = 0; i < tider.size(); i++){
            if (tider.get(i) > værsteTid){
                værsteTid = tider.get(i);
            }
            totaltid = totaltid + tider.get(i);
        }
        return (totaltid - værsteTid) / (tider.size()-1);
    }
}
