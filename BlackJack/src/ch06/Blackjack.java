package ch06;

import java.util.*;
import blackjackGUI.Card;
import blackjackGUI.DeckOfCards;

/**
 * Blackjack game.
 * @author Cade
 * @version 11/29/2017
 */
public class Blackjack
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String playerAction;
        boolean comp;
        DeckOfCards masterDeck;
        ArrayList<Card> playerDeck, compDeck;
        double balance = 2500;
    	double bet;
    	boolean doubling;
        
    	System.out.print("Would you like to play BlackJack? (Y/N): ");
    	playerAction = scan.next();
    	
    	while(playerAction.equalsIgnoreCase("y")){    		
	        masterDeck = new DeckOfCards();
	        comp = true;
	        doubling = false;
	        
	        masterDeck.shuffle(); // put Card objects in random order
	        playerDeck = new ArrayList<>();
	        compDeck = new ArrayList<>();
	        
	        System.out.printf("Your balance: $%.2f\n", balance);
	        System.out.print("Place your bet: ");
	        bet = scan.nextDouble();
	        
	        for(int i = 0; i < 2; i++){
	            playerDeck.add(masterDeck.dealCard());
	            compDeck.add(masterDeck.dealCard());
	        }
	        
	        System.out.println("Your cards are: " + printArrayList(playerDeck) + "\tTotal: " + getTotal(playerDeck));
	        
	        if(getTotal(playerDeck) == 21) {
	            System.out.println("BlackJack!");
	            bet *= 2.5;
	            balance += bet;
	        	System.out.printf("You earned $%.2f!\n", bet);
	        } else {
		        System.out.print("Double down? (Y/N): ");
		        playerAction = scan.next();
		        if(playerAction.equalsIgnoreCase("y")) {
		        	bet *= 2;
		        	doubling = true;
		        }
		        System.out.printf("You bet $%.2f\n", bet);
		        
		        if(!doubling) {
		        	System.out.print("(H)it or (S)tand: ");
		        	playerAction = scan.next();
		        } else {
		        	playerAction = "h";
		        	System.out.println("You are dealt one card.");
		        }
		        
		        while(playerAction.equalsIgnoreCase("H")){
		            if(playerAction.equalsIgnoreCase("H")){
		                playerDeck.add(masterDeck.dealCard());
		                System.out.println("Your cards are: " + printArrayList(playerDeck) + "\tTotal: " + getTotal(playerDeck));
		                
		                if(getTotal(playerDeck) > 21){
		                    System.out.println("Busted");
				        	System.out.printf("You lost $%.2f\n", bet);
		                    balance -= bet;
		                    comp = false;
		                    break;
		                }
		            }
		            if(doubling)
		            	break;
		            
		            System.out.print("(H)it or (S)tand: ");
		            playerAction = scan.next();
		        }
		        
		        if(comp){
			        System.out.println("\nDealer's Cards are: " + printArrayList(compDeck) + "\tTotal: " + getTotal(compDeck));
			        
			        while(getTotal(compDeck) < 17){
			        	compDeck.add(masterDeck.dealCard());
			            System.out.println("Dealer hits.");
			            System.out.println("Dealer's Cards are: " + printArrayList(compDeck) + "\tTotal: " + getTotal(compDeck));
		
				        if(getTotal(compDeck) > 21){
				        	System.out.println("Dealer busted.  You win!");
				        	comp = false;
				        	break;
				        }
			        }
			        
			        if(comp){
			        	System.out.println("Dealer stands.\n");
				        if(getTotal(compDeck) > getTotal(playerDeck)){
				        	System.out.println("Computer wins!");
				        	balance -= bet;
				        	System.out.printf("You lost $%.2f\n", bet);
				        } else if(getTotal(playerDeck) > getTotal(compDeck)){
				        	System.out.println("You win!");
				        	balance += bet;
				        	System.out.printf("You earned $%.2f!\n", bet);
				        } else {
				        	System.out.println("Draw!");
				        	System.out.println("Your bet is returned to you.");
				        }
			        }
		        }
	        }
	        
		    System.out.printf("Your balance: $%.2f\n", balance);
		    
		    System.out.print("\n\n\nWould you like to play another round? (Y/N): ");
		    playerAction = scan.next();
    	}
    	
    	System.out.printf("Your final balance: $%.2f\n", balance);
    	System.out.println("Thanks for playing! Come again.");
    }
    
    /**
     * Prints a nicely formatted ArrayList.  
     * @param a - ArrayList to be printed
     * @return a nicely formatted ArrayList as a String.
     */
    public static String printArrayList(ArrayList<Card> a){
    	String ret = "";
    	for(int i = 0; i < a.size(); i++){
    		ret += a.get(i) + (i != a.size() - 1 ? ", " : "");
    	}
    	return ret;
    }
    
    /**
     * Separate method to get the totals to account for aces 
     * being worth either 1 or 11.
     * @param a - ArrayList/Hand to get the desired total from
     * @return the total of the card values, taking into account the aces.
     */
    static int getTotal(ArrayList<Card> a){
		int t = 0;
		int aces = 0;
		for(Card x : a){
			t += x.getValue();
			if(x.getValue() == 1){
				aces ++;
			}
		}
		if(t + 10 <= 21 && aces > 0){
			t += 10;
		}
		return t;
	}
	
}