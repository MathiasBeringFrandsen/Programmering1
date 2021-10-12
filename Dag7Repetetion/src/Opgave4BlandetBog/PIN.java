package Opgave4BlandetBog;

import java.util.Scanner;

public class PIN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int realPin = 1234;

        System.out.print("Enter PIN: ");
        int pin = scan.nextInt();
        if (pin == realPin) {
            System.out.println("Your PIN is Correct");
        } else {
            System.out.println("Your PIN is incorrect");
            pin = scan.nextInt();
            if (pin == realPin) {
                System.out.println("Your PIN is Correct");
            } else {
                System.out.println("Your PIN is incorrect");
                pin = scan.nextInt();
                if (pin == realPin) {
                    System.out.println("Your PIN is Correct");
                }else {
                    System.out.println("Your card is blocked");
                }
            }
        }
        scan.close();
    }
}
