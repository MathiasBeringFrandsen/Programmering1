package Opgave3;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<Player>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void printPlayers() {
        for (Player player : players) {
            System.out.println("navn: " + player.getName());
            System.out.println("Alder: " + player.getAge());
            System.out.println("Mål: " + player.getScore());
            System.out.println("----------------");
        }
    }

    public double getAverageAge() {
        double totalAge = 0;
        for (Player player : players) {
            totalAge = totalAge + player.getAge();
        }
        return totalAge / players.size();
    }

    public int calcTotalScore() {
        int totalscore = 0;
        for (Player player : players) {
            totalscore = totalscore + player.getScore();
        }
        return totalscore;
    }

    public int calcOldPlayersScore(int ageLimit) {
        int totalScore = 0;
        for (Player player : players) {
            if (player.getAge() > ageLimit) {
                totalScore = totalScore + player.getScore();
            }
        }
        return totalScore;
    }

    public int maxScore() {
        int highestScore = 0;
        for (Player player : players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
            }
        }
        return highestScore;
    }

    public String bestPlayer() {
        String playerNrOne = "";
        int maxScore = maxScore();
        for (Player player : players) {
            if (player.getScore() == maxScore) {
                playerNrOne = player.getName();
            }
        }
        return playerNrOne;
    }
}