package application.model;

import java.util.Scanner;

public class SongApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Song s1 = new Song("Blue", "Eiffel 65", 128);
        Song s2 = new Song("Trumpets", "Dj Kakah", 152);

        s1.setBpm(120);

        System.out.print("Hvad er titlen på sangen? ");
        String title = scan.next();
        System.out.print("Hvad hedder kunstneren? ");
        String artist = scan.next();
        System.out.print("Hvor hurtig er sangen? ");
        int bpm = scan.nextInt();
        Song s3 = new Song(title, artist, bpm);

        s3.printSong();

    }
}
