package application.model;

import java.util.ArrayList;

public class MethodsArrayListApp {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(19);
        list.add(26);
        list.add(35);
        list.add(14);
        list.add(7);
        list.add(0);
        list.add(6);
        MethodsArrayList methods = new MethodsArrayList();
        System.out.println(list);
        System.out.println("Summen af tallene i listen med for "
                + methods.sumListe(list));
        System.out.println("Summen af tallene i listen med forEach "
                + methods.sumListe2(list));

        System.out.println("Indeks for det første lige tal: "
                + methods.hasEvenAtIndex(list));

        System.out.println("Mindste tal i listen er: " + methods.min(list));
        System.out.println("Den gennemsnitlige længde på tallene i listen er: " + methods.average(list));
        System.out.println("Der er " + methods.countZeros(list) + " nul(ler) i listen");

        System.out.println("Listen med lige tal " + methods.anEvenList(list));

        methods.swapEvenWithZero(list);
        System.out.println(list);

    }

}
