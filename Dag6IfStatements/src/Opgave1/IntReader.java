package Opgave1;
import java.util.Scanner;

public class IntReader {


    public IntReader(){

    }

    public String negZeroPos(int i) {
        int integer = i;
        String plusMinus = "";
        if (integer == 0) {
            plusMinus = "Tallet er nul";
        }
        else if (integer > 0){
            plusMinus = "Tallet er større end nul";
        }
        else if (integer < 0){
            plusMinus = "Tallet er mindre en nul";
        }

        return plusMinus;
    }
}
