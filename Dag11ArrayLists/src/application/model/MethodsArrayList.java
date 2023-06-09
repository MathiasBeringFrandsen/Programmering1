package application.model;

import java.util.ArrayList;

public class MethodsArrayList {

    /**
     * @param list
     * @return sums the mumbers in the list using a for loop
     */
    public int sumListe(ArrayList<Integer> list) {
        int resultat = 0;
        for (int i = 0; i < list.size(); i++) {
            int tal = list.get(i);
            resultat = resultat + list.get(i);
        }
        return resultat;
    }

    /**
     * @param list
     * @return sums the mumbers in the list using a forEach loop
     */
    public int sumListe2(ArrayList<Integer> list) {
        int resultat = 0;
        for (int tal : list) {
            resultat = resultat + tal;
        }
        return resultat;
    }

    /**
     * @param list
     * @return index at the first even number
     */
    public int hasEvenAtIndex(ArrayList<Integer> list) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < list.size()) {
            if (list.get(i) % 2 == 0) {
                index = i;
            }
            i++;
        }
        return index;
    }

    public int min(ArrayList<Integer> list) {
        int min = list.get(0);
        for (Integer tal : list) {
            if (tal < min) {
                min = tal;
            }
        }
        return min;
    }

    public int average(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer tal : list) {
            sum = sum + tal;
        }
        return sum / list.size();
    }

    public int countZeros(ArrayList<Integer> list) {
        int nuller = 0;
        for (Integer tal : list) {
            if (tal == 0) {
                nuller++;
            }
        }
        return nuller;
    }

    public void swapEvenWithZero(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0){
                list.set(i, 0);
            }
        }
    }

    public ArrayList<Integer> anEvenList(ArrayList<Integer> list){
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) % 2 == 0){
                evenList.add(list.get(i));
            }
        }
        return evenList;
    }

}
