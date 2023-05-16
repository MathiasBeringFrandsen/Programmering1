package Opgave1;

import java.util.ArrayList;

public class App {

    public static double samletLoen(ArrayList<Mekaniker> list){
        double samletLoen = 0;
        for(Mekaniker mekaniker : list){
            samletLoen += mekaniker.beregnLoen();
        }
        return samletLoen;
    }

    public static void main(String[] args) {
        Mekaniker m1 = new Mekaniker("Alin", "Tilst", 1996, 200);
        Mekaniker m2 = new Mekaniker("Mads", "ZZZvej", 2021, 80);
        Mekaniker m3 = new Mekaniker("Mathias", "Viby", 2007, 350);
        Værkfører v1 = new Værkfører("Jens", "RødeKro", 2014, 275, 2020, 0);
        Synsmand s1 = new Synsmand("Oliver", "Pas", 2005, 325, 60, 29);

        ArrayList<Mekaniker> mekanikere = new ArrayList<>();
        mekanikere.add(m1);
        mekanikere.add(m2);
        mekanikere.add(m3);
        mekanikere.add(v1);
        mekanikere.add(s1);

        System.out.println(samletLoen(mekanikere));

        v1.setTillægPerUge(515);

        System.out.println();

        System.out.println(samletLoen(mekanikere));

        s1.setSyn(80);

        System.out.println();

        System.out.println(samletLoen(mekanikere));
    }
}
