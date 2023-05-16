package opgave4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileChecker {

    public static boolean linFileSearch(String fileName, int target) {
        boolean foundTarget = false;
        try {
            File filein = new File(fileName);
            Scanner scanner = new Scanner(filein);
            while (scanner.hasNext() && !foundTarget) {
                if (scanner.nextInt() == target) {
                    foundTarget = true;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return foundTarget;
    }

    public static void main(String[] args) {
            System.out.println(linFileSearch("C:/Users/Frand/Random/Talfil.txt", 959));
    }
}
