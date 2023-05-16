package soegningelevopgaver;

public class Soegning {

    public boolean findUlige(int[] tabel) {
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {
            if (tabel[i] % 2 == 1) {
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }

    public int containsTenToFifteen(int[] tabel) {
        int indeks = -1;
        int i = 0;
        while (indeks == -1 && i < tabel.length) {
            if (tabel[i] >= 10 && tabel[i] <= 15) {
                indeks = tabel[i];
            } else {
                i++;
            }
        }
        return indeks;
    }

    public boolean twoOfAKind(int[] tabel){
        boolean found = false;
        int i = 1;
        int lastNumber = tabel[0];
        while (!found && i < tabel.length){
            if (lastNumber == tabel[i]){
                found = true;
            }else{
                lastNumber = tabel[i];
                i++;
            }
        }
        return found;
    }
}
