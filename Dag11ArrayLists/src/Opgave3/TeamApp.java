package Opgave3;

public class TeamApp {
    public static void main(String[] args) {
        Player p1 = new Player("Mathias", 35);
        Player p2 = new Player("Jakob", 23);
        Player p3 = new Player("Lasse", 34);
        Player p4 = new Player("Rasmus", 22);
        Player p5 = new Player("Jon", 18);
        Team t1 = new Team("Danmark");
        t1.addPlayer(p1);
        t1.addPlayer(p2);
        t1.addPlayer(p3);
        t1.addPlayer(p4);
        t1.addPlayer(p5);

        System.out.println(p1.getAge());
        System.out.println(p1.getName());
        System.out.println(p1.getScore());
        p1.setScore(2);
        p1.addScore(3);
        System.out.println("Mathias har scoret " + p1.getScore() + " mål");
        System.out.println();
        System.out.println("Holdet hedder: " + t1.getName());
        System.out.println();
        t1.printPlayers();
        System.out.println();
        System.out.println("Den gennemsnitlige alder på holdet er: " + t1.getAverageAge());
        System.out.println("Det totale antal mål scoret er: " + t1.calcTotalScore());
        System.out.println("Spillerne over 23 har scoret: " + t1.calcOldPlayersScore(23) + " mål");
        System.out.println("Det højeste antal mål der er scoret er: " + t1.maxScore());
        System.out.println("Holdets bedste spiller er: " + t1.bestPlayer());
    }
}
