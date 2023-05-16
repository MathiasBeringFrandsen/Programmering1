package opgave5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave5 {
    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/Frand/Random/unequal.txt");
            PrintWriter out = new PrintWriter(file);
            Scanner scan = new Scanner(System.in);
            int i = 0;
            while (i != -1) {
                System.out.print("Next number:");
                i = scan.nextInt();
                if (i != -1) {
                    out.println(i);
                }
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
