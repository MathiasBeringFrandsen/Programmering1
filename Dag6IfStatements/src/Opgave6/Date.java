package Opgave6;

import java.util.Scanner;

public class Date {
    private int month;
    private int day;

    public Date(int month , int day) {
        this.month = month;
        this.day = day;
    }

    public String getSeason() {
        String season = "";

        if (month <= 3) {
            season = "Winter";
        } else if (month <= 6) {
            season = "Spring";
        } else if (month <= 9) {
            season = "Summer";
        } else if (month <= 12) {
            season = "Fall";
        }
        if (month % 3 == 0 && day >= 21) {
            if (season.equals("Winter")) {
                season = "Spring";
            } else if (season.equals("Spring")) {
                season = "Summer";
            } else if (season.equals("Summer")) {
                season = "Fall";
            } else if (season.equals("Fall")) {
                season = "Winter";
            }
        }
        return season;
    }


}
