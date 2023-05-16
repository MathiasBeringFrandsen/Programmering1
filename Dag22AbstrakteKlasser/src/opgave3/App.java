package opgave3;

import java.util.ArrayList;

public class App {

    public static double samletLoen(ArrayList<Ansat> list){
        double samletLoen = 0;
        for(Ansat ansat : list){
            samletLoen += ansat.beregnLoen();
        }
        return samletLoen;
    }

    public static void main(String[] args) {
        Mekaniker m1 = new Mekaniker("Alin", "Tilst", 1996, 200);
        Mekaniker m2 = new Mekaniker("Mads", "ZZZvej", 2021, 80);
        Mekaniker m3 = new Mekaniker("Mathias", "Viby", 2007, 350);
        Værkfører v1 = new Værkfører("Jens", "RødeKro", 2014, 275, 2020, 0);
        Synsmand s1 = new Synsmand("Oliver", "Pas", 2005, 325, 60, 29);
        Arbejdsdreng a1 = new Arbejdsdreng("Allan", "Bævervej 22", 75);

        ArrayList<Ansat> ansatte = new ArrayList<>();
        ansatte.add(m1);
        ansatte.add(m2);
        ansatte.add(m3);
        ansatte.add(v1);
        ansatte.add(s1);
        ansatte.add(a1);

        System.out.println(samletLoen(ansatte));

        v1.setTillægPerUge(515);

        System.out.println();

        System.out.println(samletLoen(ansatte));

        s1.setSyn(80);

        System.out.println();

        System.out.println(samletLoen(ansatte));
    }
}
