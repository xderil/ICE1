/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import card.Card;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * edited by deril 
 */

public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        
        // Fill the magicHand array with random cards
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // generate random values between 1 and 13
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // generate random suits
            magicHand[i] = c;
        }
        
        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a card value (1-13): ");
        int value = scanner.nextInt();
        System.out.println("Enter a suit (0=Hearts, 1=Diamonds, 2=Spades, 3=Clubs): ");
        String suit = Card.SUITS[scanner.nextInt()];

        Card userCard = new Card();
        userCard.setValue(value);
        userCard.setSuit(suit);

        // Search for the user's card in the magicHand array
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report the result
        if (found) {
            System.out.println("Your card was found in the magic hand!");
        } else {
            System.out.println("Your card was not found in the magic hand.");
        }
    } 
}