/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Harsh Rathi Studentid - 991707292
 */
import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomNumber());
            c.setSuit(Card.SUITS[generateRandomNumber(0, 3)]);
            magicHand[i] = c;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of your card: ");
        int userValue = scanner.nextInt();

        System.out.print("Enter the suit of your card (0-3): ");
        int userSuit = scanner.nextInt();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuit]);

        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry! Your card is not in the magic hand.");
        }
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(13) + 1; // Generates a random number between 1 and 13 (inclusive)
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min; // Generates a random number between min and max (inclusive)
    }
}
