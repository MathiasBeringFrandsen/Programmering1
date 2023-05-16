package opgave4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class unequalOverZeroUnderHundred {
    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/Frand/Random/unequal.txt");
            PrintWriter out = new PrintWriter(file);
            int i = 0;
            while (i <= 100){
                if (i % 2 == 1) {
                    out.println(i);
                }
                i++;
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
