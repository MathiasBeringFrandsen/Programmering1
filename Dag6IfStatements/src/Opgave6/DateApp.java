package Opgave6;

import java.util.Scanner;

public class DateApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Month of the year: ");
        int month = scan.nextInt();
        System.out.print("Date of the month: ");
        int day = scan.nextInt();
        Date thisDate = new Date(month, day);
        System.out.println(thisDate.getSeason());
    }
}