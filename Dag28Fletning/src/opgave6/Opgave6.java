package opgave6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave6 {

    public static void findfællesTal(String fileName1, String fileName2, String fileNameNy) {
        try {
            File file1 = new File(fileName1);
            File file2 = new File(fileName2);
            Scanner scan1 = new Scanner(file1);
            Scanner scan2 = new Scanner(file2);
            PrintWriter write = new PrintWriter(fileNameNy);
            int i = scan1.nextInt();
            int j = scan2.nextInt();
            while (i < Integer.MAX_VALUE && j < Integer.MAX_VALUE) {
                if (i == j) {
                    write.println(i);
                    i = scan1.nextInt();
                    j = scan2.nextInt();
                } else if (i < j) {
                    i = scan1.nextInt();
                } else {
                    j = scan2.nextInt();
                }
            }
            scan1.close();
            scan2.close();
            write.flush();
            write.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        findfællesTal("C:/Users/Frand/Random/Talfil.txt", "C:/Users/Frand/Random/tal1.txt", "C:/Users/Frand/Random/FlettedeHeltal.txt");
    }
}