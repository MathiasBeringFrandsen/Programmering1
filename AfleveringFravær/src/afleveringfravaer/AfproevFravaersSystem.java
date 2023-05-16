package afleveringfravaer;

public class AfproevFravaersSystem {

    public static void main(String[] args) {
        int[][] fravaer21S = { { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
                { 5, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0 } };

        FravaersSystem fraværsSystem = new FravaersSystem();
        System.out.println();
        System.out.println("Samlet fravær for en bestemt elev " + fraværsSystem.samletFravaer(fravaer21S, 5));
        System.out.println("Gennemsnitligt fravær for en bestemt elev " + fraværsSystem.gennemsnit(fravaer21S, 5));
        System.out.println("Antal elever uden fravær: " + fraværsSystem.antalUdenFravaer(fravaer21S));
        System.out.println("Eleven med mest fravær: " + fraværsSystem.mestFravaer(fravaer21S));
        fraværsSystem.nulstil(fravaer21S, 4);
//        fraværsSystem.udskrivFravaer(fravaer21S);

    }
}
