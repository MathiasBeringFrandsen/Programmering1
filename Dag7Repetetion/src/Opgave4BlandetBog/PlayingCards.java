package Opgave4BlandetBog;

public class PlayingCards {
    private String cardNotation = "";

    public PlayingCards(String cardNotation) {
        this.cardNotation = cardNotation.toUpperCase();
    }

    public String getDescription() {
        if (cardNotation.length() == 0) {
            return "Unknown";
        }
        String name = cardNotation.substring(0, cardNotation.length() - 1);
        String suit = cardNotation.substring(cardNotation.length() - 1);
        if (name.equals("A") || name.equals("1")) {
            name = "Ace";
        } else if (name.equals("J")) {
            name = "Jack";
        } else if (name.equals("Q")) {
            name = "Queen";
        } else if (name.equals("K")) {
            name = "King";
        } else if (name.equals("10")) {
            name = "10";
        } else if (Character.isDigit(cardNotation.charAt(0)) && name.length() == 1) {
            name = cardNotation.substring(0, 1);
        } else {
            return "Unknown";
        }
        if (suit.equals("D")) {
            suit = "Diamonds";
        } else if (suit.equals("H")) {
            suit = "Hearts";
        } else if (suit.equals("S")) {
            suit = "Spades";
        } else if (suit.equals("C")) {
            suit = "Clubs";
        } else {
            return "Unknown";
        }
        return name + " of " + suit;
    }
}