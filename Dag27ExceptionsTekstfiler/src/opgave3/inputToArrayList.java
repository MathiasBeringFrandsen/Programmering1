package opgave3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class inputToArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        try {
            File file = new File("C:/Users/Frand/Random/tal.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                ints.add(scan.nextInt());
            }
            for (int i = ints.size() - 1; i >= 0; i--) {
                System.out.println(ints.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
