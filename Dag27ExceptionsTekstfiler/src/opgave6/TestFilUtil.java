package opgave6;

import java.io.File;
import java.io.IOException;

public class TestFilUtil {
    public static void main(String[] args) {
        try {
            FilUtil util = new FilUtil();

            System.out.println("Max tal1 " + util.max("C:/Users/Frand/Random/tal1.txt"));
            System.out.println("Max tal2 " + util.max("C:/Users/Frand/Random/tal2.txt"));

            System.out.println();

            System.out.println(util.min("C:/Users/Frand/Random/tal1.txt"));
            System.out.println(util.min("C:/Users/Frand/Random/tal2.txt"));

            System.out.println();

            System.out.println(util.gennemsnit("C:/Users/Frand/Random/tal1.txt"));
            System.out.println(util.gennemsnit("C:/Users/Frand/Random/tal2.txt"));

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
