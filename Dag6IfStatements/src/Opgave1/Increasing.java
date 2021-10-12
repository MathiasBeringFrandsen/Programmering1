package Opgave1;

import java.security.PublicKey;

public class Increasing {
    public Increasing(){
    }

    public String isIncreasing(int first, int second, int third){
        int one = first;
        int two = second;
        int three = third;
        String status = "";

        if (two > one && three > two){
        status = "Increasing";
        } else if (two < one && three < two){
            status = "Decreasing";
        } else {
            status = "Neither";
        }
        return status;
    }
}
