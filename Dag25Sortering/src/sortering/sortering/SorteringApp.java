package sortering.sortering;

import sortering.model.Customer;
import sortering.sortering.BubbelSortering;
import sortering.sortering.InsertionSortering;
import sortering.sortering.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SorteringApp {

    public static void main(String[] args) {
        final int[] tabelInit = { 34, 12, 56, 12, 45, 89, 2 };

        System.out.println("Bubbelsortering");
        int[] tabel = Arrays.copyOf(tabelInit, tabelInit.length);
        System.out.println(Arrays.toString(tabel));
        BubbelSortering.bubbleSort(tabel);
        System.out.println(Arrays.toString(tabel));

        System.out.println("--------------------------------");

        System.out.println("Insertionsortering");
        tabel = Arrays.copyOf(tabelInit, tabelInit.length);
        System.out.println(Arrays.toString(tabel));
        SelectionSort.selectionSort(tabel);
        System.out.println(Arrays.toString(tabel));

        System.out.println("--------------------------------");

        System.out.println("Selectionsortering");
        tabel = Arrays.copyOf(tabelInit, tabelInit.length);
        System.out.println(Arrays.toString(tabel));
        InsertionSortering.insertioneSort(tabel);
        System.out.println(Arrays.toString(tabel));

        System.out.println("--------------------------------");

        System.out.println("BubbelSorteringStrings");
        String[] strings = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};
        System.out.println(Arrays.toString(strings));
        BubbelSortering.bubbleSortString(strings);
        System.out.println(Arrays.toString(strings));

        System.out.println("--------------------------------");

        System.out.println("SelectionSortStrings");
        String[] strings2 = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};
        System.out.println(Arrays.toString(strings2));
        SelectionSort.selectionSortStrings(strings2);
        System.out.println(Arrays.toString(strings2));

        System.out.println("--------------------------------");

        System.out.println("SelectionSortCustomers");
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Nørskov","Mads",23));
        customers.add(new Customer("Bering","Mathias",35));
        customers.add(new Customer("Andrei","Alin",21));
        customers.add(new Customer("Røv","Torben",92));
        System.out.println(customers);
        SelectionSort.selectionSortCustomers(customers);
        System.out.println(customers);

        System.out.println("--------------------------------");

        System.out.println("InsertionsorteringStrings");
        String[] strings3 = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};
        System.out.println(Arrays.toString(strings3));
        InsertionSortering.insertionSortStrings(strings3);
        System.out.println(Arrays.toString(strings3));

        System.out.println("--------------------------------");

        System.out.println("InsertionsorteringCustomers");
        ArrayList<Customer> customers1 = new ArrayList<>();
        customers1.add(new Customer("Nørskov","Mads",23));
        customers1.add(new Customer("Bering","Mathias",35));
        customers1.add(new Customer("Andrei","Alin",21));
        customers1.add(new Customer("Røv","Torben",92));
        System.out.println(customers1);
        InsertionSortering.insertionSortCustomers(customers1);
        System.out.println(customers1);

        System.out.println("--------------------------------");

        ArrayList<String> list = new ArrayList<String>();
        list.add("Jan");
        list.add("Bent");
        list.add("Thomas");
        list.add("Karsten");
        list.add("Dan");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        System.out.println("--------------------------------");

        ArrayList<Customer> customers2 = new ArrayList<>();
        customers2.add(new Customer("Nørskov","Mads",23));
        customers2.add(new Customer("Bering","Mathias",35));
        customers2.add(new Customer("Andrei","Alin",21));
        customers2.add(new Customer("Røv","Torben",92));
        System.out.println(customers2);
        Collections.sort(customers2);
        System.out.println(customers2 );
    }

}
