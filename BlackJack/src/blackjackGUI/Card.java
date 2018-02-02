package blackjackGUI;

import java.util.Arrays;

/*********************************************************************
 * Card.java
 *
 * Represents a Card with a face, suit, and value.
 * 
 * @author Cade
 * @version 11/29/2017
 ***********************************************************************/
public class Card
{
    private String face;
    private String suit;
    private int value;
    private static String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    
    /**
     * Initializes the card to specified face, suit, and value.
     * @param cardFace - Face as a String
     * @param cardSuit - Suit as a String
     * @param cardVal - Numeric value of card
     */
    public Card (String cardFace, String cardSuit, int cardVal)
    {
        face = cardFace;
        suit = cardSuit;
        value = cardVal;
    }

    /**
     * String representation of the card.
     * @return a String representing the card
     */
    public String toString(){
        return face + " of " + suit;
    }
    
    /**
     * Returns the face of the card
     * @return the face of the card
     */
    public String getFace(){
        return face;
    }
 
    /**
     * Returns card's value
     * @return the card's numeric value
     */
    public int getValue(){
        return value;
    }
    
    /**
     * Used for getting the card in a 2D Array of 52 Cards.
     * @return the index of the face in the faces[] array
     */
    public int getFaceAsInt(){
    	return Arrays.asList(faces).indexOf(face);
    }
    
    /**
     * Gets the suit as a String
     * @return the suit of the card as a String
     */
    public int getSuit(){
    	if(suit.equalsIgnoreCase("hearts"))
    		return 0;
    	if(suit.equalsIgnoreCase("diamonds"))
    		return 1;
    	if(suit.equalsIgnoreCase("clubs"))
    		return 2;
    	if(suit.equalsIgnoreCase("spades"))
    		return 3;
    	else
    		return 0;
    }

}