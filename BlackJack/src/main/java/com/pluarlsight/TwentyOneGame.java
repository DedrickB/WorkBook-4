package com.pluarlsight;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwentyOneGame {
    private List<Player> players;
    private Deck deck;
    private Scanner scanner;

    public TwentyOneGame() {
        players = new ArrayList<>();
        deck = new Deck();
        scanner = new Scanner(System.in);
    }

    public void setupPlayers() {
        System.out.print("How many players are playing? ");
        int numPlayers = 0;
        while (numPlayers <= 0) {
            try {
                numPlayers = Integer.parseInt(scanner.nextLine());
                if (numPlayers <= 0) {
                    System.out.println("Please enter a positive number of players.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }


        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }
    }

    public void dealInitialCards() {
        System.out.println("\nDealing cards...");
        for (int i = 0; i < 2; i++) { // Deal 2 cards to each player
            for (Player player : players) {
                Card card = deck.deal();
                if (card != null) {
                    player.addCardToHand(card);
                } else {
                    System.out.println("Deck ran out of cards during initial deal!");
                    return; // Or handle more gracefully
                }
            }
        }
    }

    public void displayAllHands() {
        System.out.println("\n--- Player Hands ---");
        for (Player player : players) {
            player.displayHand();
        }
        System.out.println("--------------------");
    }

    public void determineWinner() {
        Player winner = null;
        int bestScore = 0; // Best score that is <= 21

        System.out.println("\n--- Determining Winner ---");
        for (Player player : players) {
            int playerScore = player.getHandValue();
            System.out.println(player.getName() + " has a score of " + playerScore);

            if (playerScore <= 21) {
                if (playerScore > bestScore) {
                    bestScore = playerScore;
                    winner = player;
                } else if (playerScore == bestScore) {
                    // Handle ties - current logic: first player to reach bestScore wins.
                    // Or, you could declare a draw or list multiple winners.
                    // For this simple version, we'll stick to a single winner.
                    // If you want to declare a draw:
                    // winner = null; // Invalidate current winner if it's a tie for the best score.
                    // Or have a list of winners.
                    // For now, let's just say the current winner stands if scores are equal.
                }
            }
        }

        if (winner != null) {
            System.out.println("\n" + winner.getName() + " is the winner with a score of " + bestScore + "!");
        } else if (players.isEmpty()){
            System.out.println("\nNo players in the game.");
        }
        else {
            System.out.println("\nNo winner. All players went over 21 or no valid scores.");
        }
    }

    public void play() {
        System.out.println("Welcome to the Game of Twenty-One!");

        setupPlayers();

        if (players.isEmpty()) {
            System.out.println("No players to start the game. Exiting.");
            scanner.close();
            return;
        }

        System.out.println("\nShuffling the deck...");
        deck.shuffle();

        dealInitialCards();
        displayAllHands();
        determineWinner();

        scanner.close();
        System.out.println("\nThanks for playing!");
    }

    public static void main(String[] args) {
        TwentyOneGame game = new TwentyOneGame();
        game.play();
    }
}

