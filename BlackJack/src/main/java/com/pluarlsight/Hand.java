package com.pluarlsight;
import java.util.ArrayList;
import java.util.List; // Using List interface

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void deal(Card card) {
        if (card != null) {
            cards.add(card);
        }
    }

    public int getSize() {
        return cards.size();
    }

    // Calculates the total point value of the hand
    public int getValue() {
        int totalValue = 0;
        for (Card card : cards) {
            boolean originallyFaceUp = card.isFaceUp();
            if (!originallyFaceUp) {
                card.flip(); // Temporarily flip to read value
            }
            totalValue += card.getPointValue();
            if (!originallyFaceUp) {
                card.flip(); // Flip back to original state
            }
        }
        return totalValue;
    }

    // Returns a copy of the cards in hand for display or other read-only operations
    public List<Card> getCards() {
        return new ArrayList<>(cards); // Return a copy to prevent external modification
    }
}