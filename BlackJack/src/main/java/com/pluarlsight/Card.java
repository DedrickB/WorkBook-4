package com.pluarlsight;
public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false; // Cards are initially face down
    }

    public String getSuit() {
        if (isFaceUp) {
            return suit;
        } else {
            return "#"; // Represents a face-down card
        }
    }

    public String getValue() {
        if (isFaceUp) {
            return value;
        } else {
            return "#"; // Represents a face-down card
        }
    }

    public int getPointValue() {
        if (isFaceUp) {
            switch (this.value) {
                case "A":
                    return 11;
                case "K":
                case "Q":
                case "J":
                    return 10;
                // For numeric cards 2-10
                case "10":
                case "9":
                case "8":
                case "7":
                case "6":
                case "5":
                case "4":
                case "3":
                case "2":
                    return Integer.parseInt(this.value);
                default:
                    return 0; // Should not happen with standard cards
            }
        }
        return 0; // Card is face down
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }

    // Helper for displaying card info, regardless of current flip state for game logic
    public String getCardInfo(boolean forceFaceUp) {
        if (forceFaceUp || isFaceUp) {
            return value + " of " + suit;
        }
        return "Hidden Card";
    }
}


