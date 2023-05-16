package application.model;

public class ProfSpiller extends Spiller {
    private double kampHonorar;

    public ProfSpiller(String navn, int årgang, double kampHonorar){
        super(navn, årgang);
        this.kampHonorar = kampHonorar;
    }

    public double getKampHonorar() {
        return kampHonorar;
    }

    public double kampHonorar() {
        double honorar;
        double tilmeldinger = 0;
        double afbud = 0;
        for (Deltagelse deltagelse : getDeltagelser()) {
            tilmeldinger++;
            if (deltagelse.isAfbud()) {
                afbud++;
            }
        }
        double deltagelser = tilmeldinger - afbud;
        double procent = afbud / tilmeldinger;
        honorar = deltagelser * procent;
        return honorar;
    }
}
