package afleveringfravaer;

public class FravaersSystem {
    /**
     * Fraværstallene udskrives på skærmen
     *
     * @param fravaer
     */
    public void udskrivFravaer(int[][] fravaer) {
        for (int i = 0; i < fravaer.length; i++) {
            System.out.println();
            System.out.println();
            System.out.print("Elev " + (i + 1) + ": ");
            for (int j = 0; j < fravaer[i].length; j++) {
                System.out.print("Måned " + (j + 1) + ": " + fravaer[i][j] + " dages fravær. ");
            }
        }
    }

    /**
     * Returnerer det samlede antal fravaerdage over 12 måneder for eleven med
     * elevnr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public int samletFravaer(int[][] fravaer, int elevNr) {
        int sum = 0;
        for (int i = 0; i < fravaer[elevNr - 1].length; i++) {
            sum = sum + fravaer[elevNr - 1][i];
        }
        return sum;
    }

    /**
     * Returnerer det gennemsnitlige antal fraværsdage pr måned for eleven med
     * elevNr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public double gennemsnit(int[][] fravaer, int elevNr) {
        double sum = 0;
        for (int i = 0; i < fravaer[elevNr - 1].length; i++) {
            sum = (sum + fravaer[elevNr - 1][i]);
        }
        return sum / fravaer[elevNr - 1].length;
    }

    /**
     * Returnerer antallet af elever der ikke har haft fravær i de 12 måneder.
     *
     * @param fravaer
     * @return
     */
    public int antalUdenFravaer(int[][] fravaer) {
        int antalUdenFravaer = 0;
        for (int i = 1; i <= fravaer.length; i++) {
            if (samletFravaer(fravaer, i) == 0) {
                antalUdenFravaer++;
            }
        }
        return antalUdenFravaer;
    }

    /**
     * Returnerer elevNr for den elev der har haft mest fravær igennem de 12
     * måneder. Hvis flere elever har haft højst fravær, returneres elevnummer
     * for en af disse.
     *
     * @param fravaer
     * @return
     */
    public int mestFravaer(int[][] fravaer) {
        int højesteFraværsTimer = 0;
        int værsteElev = 0;
        for (int i = 1; i <= fravaer.length; i++) {
            if (samletFravaer(fravaer, i) > højesteFraværsTimer) {
                højesteFraværsTimer = samletFravaer(fravaer, i);
                værsteElev = i;
            }
        }
        return værsteElev;
    }

    /**
     * Registrerer at elenven med elevNr ikke har haft fravær i nogen af de 12
     * måneder.
     *
     * @param fravaer
     * @param elevNr
     */
    public void nulstil(int[][] fravaer, int elevNr) {
        for (int i = 0; i < fravaer.length; i++) {
            fravaer[elevNr - 1][i] = 0;
        }
    }
}