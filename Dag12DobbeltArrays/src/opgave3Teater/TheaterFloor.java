package opgave3Teater;

import java.util.Scanner;

public class TheaterFloor {
    int[][] seats = {{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10}, {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {20, 20, 30, 30, 40, 40, 30, 30, 20, 20}, {20, 30, 30, 40, 50, 50, 40, 30, 30, 20},
            {30, 40, 50, 50, 50, 50, 50, 50, 40, 30}};

    /**
     * Hvis plads seat på række row er ledig reserveres pladsen og prisen på pladsen
     * returneres. Der returneres 0 hvis pladsen er optaget.
     */

    public int buySeat(int row, int seat) {
        int returnValue = 0;
        if (seats[row - 1][seat - 1] != 0) {
            returnValue = seats[row - 1][seat - 1];
            seats[row - 1][seat - 1] = 0;
            System.out.println("God fornøjelse med dit køb");
        } else {
            System.out.println("pladsen er allerede solgt");
        }
        return returnValue;
    }

    /**
     * Hvis der er en plads ledig med den pågældende pris, reserveres pladsen og
     * prisen returneres. Der returneres 0, hvis der ikke er nogen pladser ledige
     * til den pågældende pris.
     */
    public int buySeat(int price) {
        int returnValue = 0;
        boolean seatBought = false;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == price && !seatBought) {
                    returnValue = price;
                    seats[i][j] = 0;
                    seatBought = true;
                    System.out.println("God fornøjelse med dit køb");
                }
            }
        }
        return returnValue;
    }

    public void printTheaterFloor() {
        System.out.println("    Sæde :   1   2  3   4   5   6   7   8   9   10");
        System.out.print("            --------------------------------------");
        for (int i = 0; i < seats.length; i++) {
            System.out.println();
            System.out.print("Række " + (i + 1) + "  :  ");
            for (int j = 0; j < seats[i].length; j++) {
                if (j == seats[i].length - 1) {
                    System.out.print(seats[i][j]);
                } else {
                    System.out.print(seats[i][j] + ", ");
                }
            }
        }
    }

    public void buyTicket() {
        Scanner scan = new Scanner(System.in);
        boolean ticketBought = false;
        while (!ticketBought) {
            System.out.println("vil du købe en bestemt plads eller til en bestemt pris?");
            String købsMetode = scan.nextLine();
            if (købsMetode.equalsIgnoreCase("pris")) {
                System.out.println("Hvad skal billetten koste?");
                buySeat(scan.nextInt());
                ticketBought = true;
            } else if (købsMetode.equalsIgnoreCase("plads")) {
                System.out.println("Hvor vil du sidde? Først række, så sæde");
                buySeat(scan.nextInt(), scan.nextInt());
                ticketBought = true;
            }
        }
        scan.close();
    }
}