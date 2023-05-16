package opgave7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave7 {
    public static String linFileSearchPerson(String fileName, String target) {
        String person = "";
        try {
            File filein = new File(fileName);
            boolean found = false;
            Scanner scanner = new Scanner(filein);
            while (!found && scanner.hasNext()) {
                String[] temp = scanner.nextLine().split(" ");
                if (temp[2].equalsIgnoreCase(target)) {
                    person = temp[1] + " " + temp[2];
                    found = true;
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return person;
    }

    public static void main(String[] args) {
            System.out.println(linFileSearchPerson("C:/Users/Frand/Random/personer.txt", "Olsen"));

    }
}
