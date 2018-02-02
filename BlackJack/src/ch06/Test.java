package ch06;

import java.util.ArrayList;
import java.util.Scanner;

import blackjackGUI.BlackjackEngine;
import blackjackGUI.Card;

public class Test {
	public static void main(String[] args){
		BlackjackEngine game = new BlackjackEngine();
		Scanner scan = new Scanner(System.in);
		String playerAction = "";
		
		System.out.print("Would you like to play BlackJack? (Y/N): ");
    	playerAction = scan.next();
    	
    	while(playerAction.equalsIgnoreCase("y")){    		
	        game = new BlackjackEngine();
			boolean comp = true;
	        
	        System.out.println("Your cards are: " + printArrayList(game.getPlayer()) + "\tTotal: " + game.getPlayerTotal());
	        
	        if(game.getPlayerTotal() == 21)
	            System.out.println("BlackJack!");
	        
	        System.out.print("(H)it or (S)tand: ");
	        playerAction = scan.next();
	        
	        while(playerAction.equalsIgnoreCase("H")){
	            if(playerAction.equalsIgnoreCase("H")){
	                game.playerHit();
	                System.out.println("Your cards are: " + printArrayList(game.getPlayer()) + "\tTotal: " + game.getPlayerTotal());
	                
	                if(game.checkPlayerBust()){
	                    System.out.println("Busted");
	                    comp = false;
	                    break;
	                }
	            }
	            System.out.print("(H)it or (S)tand: ");
	            playerAction = scan.next();
	        }
	        
	        if(comp){
		        System.out.println("\nDealer's Cards are: " + printArrayList(game.getComp()) + "\tTotal: " + game.getCompTotal());
		        
		        while(game.getCompTotal() < 17){
		        	game.compHit();
		            System.out.println("Dealer's Cards are: " + printArrayList(game.getComp()) + "\tTotal: " + game.getCompTotal());
	
			        if(game.checkCompBust()){
			        	System.out.println("Dealer busted.  You win!");
			        	comp = false;
			        	break;
			        }
		        }
		        
		        if(comp){
		        	System.out.println("Dealer stands.");
			        System.out.println(game.results());
		        }
	        }

	        System.out.print("\n\n\nWould you like to play again? (Y/N): ");
	        playerAction = scan.next();
    	}
    }
    
    public static String printArrayList(ArrayList<Card> a){
    	String ret = "";
    	for(int i = 0; i < a.size(); i++){
    		ret += a.get(i) + (i != a.size() - 1 ? ", " : "");
    	}
    	return ret;
    
	}
}
