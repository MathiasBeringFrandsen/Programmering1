package Opgave1;

import java.util.Scanner;

public class IncreasingApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Indtast tre tal: ");
        int et = input.nextInt();
        int to = input.nextInt();
        int tre = input.nextInt();
        Increasing inc = new Increasing();
        System.out.println(inc.isIncreasing(et, to, tre));
    }
}
