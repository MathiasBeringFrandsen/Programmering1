package opgave6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilUtil {

    public int max(String filename) throws IOException {
        File filein = new File(filename);
        Scanner scan = new Scanner(filein);
        int max = Integer.MIN_VALUE;
        while (scan.hasNext()) {
            int scanTal = scan.nextInt();
            if (max < scanTal) {
                max = scanTal;
            }

        }
        return max;
    }


    public int min(String filename) throws IOException {
        File filein = new File(filename);
        Scanner scan = new Scanner(filein);
        int min = scan.nextInt();
        while (scan.hasNext()) {
            int scanTal = scan.nextInt();
            if (min > scanTal) {
                min = scanTal;
            }
        }
        return min;
    }

    public double gennemsnit(String filename) throws IOException {
        File filein = new File(filename);
        Scanner scan = new Scanner(filein);
        double average = 0;
        double sum = 0;
        while (scan.hasNext()) {
            sum += scan.nextInt();
            average++;
        }
        average = sum / average;
        return average;
    }
}
