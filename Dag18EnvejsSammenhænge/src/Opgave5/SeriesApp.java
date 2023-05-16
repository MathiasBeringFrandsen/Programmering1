package Opgave5;

import java.util.ArrayList;

public class SeriesApp {
    public static void main(String[] args) {
        ArrayList<String> actors = new ArrayList<>();
        actors.add("Jon Snow");
        actors.add("Arya Stark");
        actors.add("Daenerys Targaryen");
        actors.add("Tyrion Lannister");

        ArrayList<String> guests1 = new ArrayList<>();
        guests1.add("Cersei Lannister");
        guests1.add("Jamie Lannister");
        guests1.add("Sansa Stark");

        Series s1 = new Series("The Simpsons", actors);

        ArrayList<String> guests2 = new ArrayList<>();
        guests2.add("Homer Simpson");
        guests2.add("Marge Simpson");
        guests2.add("Bart Simpson");
        guests2.add("Lisa Simpson");
        guests2.add("Maggie Simpson");

        s1.createEpisode(1, 74, guests1);
        s1.createEpisode(2, 73, guests2);

        System.out.println("Total length of all episodes: " + s1.totalLength());
        System.out.println();
        System.out.println("List of all guest actors: " + s1.getGuestActors());
    }
}
