package com.pluarlsight;


public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        this.hand.deal(card);
    }

    public int getHandValue() {
        return this.hand.getValue();
    }

    public void displayHand() {
        System.out.print(name + "'s hand: ");
        if (hand.getSize() == 0) {
            System.out.println("is empty.");
            return;
        }
        for (int i = 0; i < hand.getCards().size(); i++) {
            Card card = hand.getCards().get(i);
            // We want to display the card's actual value, so we'll use getCardInfo(true)
            System.out.print(card.getCardInfo(true)); // Force display
            if (i < hand.getCards().size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" (Value: " + getHandValue() + ")");
    }
}
