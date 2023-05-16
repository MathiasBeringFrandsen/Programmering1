package opgave2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GangMedTo {
    public static void main(String[] args) {
        try {
            File filein = new File("C:/Users/Frand/Random/tal.txt");
            Scanner scan = new Scanner(filein);
            while (scan.hasNext()){
                System.out.println(scan.nextInt() * 2);
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
