import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * A class to create a game of BlackJack.
 *
 * @author Kayla Nailor
 * @version December 2nd, 2018
 */
@SuppressWarnings("unused")
public class Blackjack {
	
	public Blackjack() {
		
	}
    /**
     * A static helper method that returns the total value of the cards
     * @returns int
     * @param playerTotal = total value of cards
     * 
     */
    private static int totalValue(ArrayList<PlayingCard> hand) {
        int end = 0;
        for(PlayingCard element : hand) {
            Denomination denom = element.getDenomination();
            end += denom.getValue();
        }
        return end;
    }
 
    /**
     * A static helper method to get a starting hand.
     * @return ArrayList<PlayingCard>
     */
    private static ArrayList<PlayingCard> getStartingHand() {
        ArrayList<PlayingCard> startingHand = new ArrayList<PlayingCard>();
        PlayingCard firstCard = PlayingCard.getRandomPlayingCard();
        PlayingCard secondCard = PlayingCard.getRandomPlayingCard();
        startingHand.add(firstCard);
        startingHand.add(secondCard);
        return startingHand;
    }
    
    /**
     * A static helper method to calculate how much the player won based on the returned string.
     * @param condition is the returned from the winOrLose command at the end of the game
     * @param bet is the amount the player bet at the beginning of the game
     * @return the amount that the player won from the table.
     */
    private static int calculateWinnings(String condition, int bet) {
    	int winnings = 0;
    	switch(condition) {
    	case "Congrats you won! Lenny the dealer had a lower card total! ( ͡° ʖ̯ ͡°)" :
    	case "You won because Lenny the dealer ( ͡° ʖ̯ ͡°) fucked up by going over 21!":
    		winnings = 2 * bet;
    		System.out.println("You have won " + winnings);
    		break;
    	case "Congratulations you won! You had a perfect 21! ( ͡° ʖ̯ ͡°)":
    		winnings = 3 * bet;
    		System.out.println("You have won" + winnings);
    		break;
    	case "No one wins!":
    		System.out.println("You recieve your bet of " + bet + " back");
    		winnings = bet;
    	default:
    		break;
    	}
    	return winnings;
    }
 
    /**
     * A static helper method to return whether you lost or won and how you did it.
     * @return string returns a string about how the player won or lost or tied
     */
    private static String winOrLose(ArrayList<PlayingCard> playerHand,ArrayList<PlayingCard> dealerHand,boolean finished) {
    	String toReturn = "";
        int playerTotal = totalValue(playerHand);
        int dealerTotal = totalValue(dealerHand);
        if(playerTotal > dealerTotal && playerTotal < 21) {
            toReturn = "Congrats you won! Lenny the dealer had a lower card total! ( ͡° ʖ̯ ͡°)";
        	
        }
        else if(playerTotal > 21) {
        	toReturn = "You lost! You went over 21! ( ͡° ͜ʖ ͡°) Lenny the Dealer called you a moron!";
        }
        else if(playerTotal < 21 && dealerTotal > 21) {
        	toReturn = "You won because Lenny the dealer ( ͡° ʖ̯ ͡°) fucked up by going over 21!";
        	
        }
        else if(playerTotal == 21) {
        	toReturn = "Congratulations you won! You had a perfect 21! ( ͡° ʖ̯ ͡°)";
        }
        else if(playerTotal < dealerTotal && dealerTotal < 21) {
        	toReturn = "Lenny the Dealer won! ( ͡° ͜ʖ ͡°) with a total card value of " + totalValue(dealerHand);
        }
        else if(dealerTotal == 21) {
        	toReturn = "Lenny the Dealer won! ( ͡° ͜ʖ ͡°) He had a perfect hand!";
        }
        else if(playerTotal == dealerTotal) {
         	toReturn = "No one wins!";
        }
        return toReturn;
    }
 
    /**
     * A method to create a game of BlackJack.
     * @return returns an integer of how much the player won or lost
     */
    public static int play(Scanner input, int bet) {
        int toReturn = 0;
        System.out.println("Welcome to BlackJack!");
        ArrayList<PlayingCard> playerHand = getStartingHand();
        ArrayList<PlayingCard> dealerHand = getStartingHand();
        boolean done = false; 
        PlayingCard hiddenCard = dealerHand.get(0);
        PlayingCard showCard = dealerHand.get(1);
        System.out.println("Lenny the dealer ( ͡° ͜ʖ ͡°) is showing a " + showCard.toString());
        for(PlayingCard element : playerHand) {
            System.out.println("You recieve a " + element.toString());
        }
        while(done == false) {
        	if(totalValue(dealerHand) < 17) {
        		dealerHand.add(PlayingCard.getRandomPlayingCard());
        		if(totalValue(dealerHand) >= 21) {
        			done = true;
        		System.out.println(winOrLose(playerHand,dealerHand,done));
        		}
        	}
        	if(done == false) {
            System.out.print("Would you like to recieve another card?(y/n)");
            String answer = input.next();
            if(answer.equalsIgnoreCase("y")) {
                PlayingCard newCard = PlayingCard.getRandomPlayingCard();
                playerHand.add(newCard);
                System.out.println("You recieve a " + newCard.toString());
                if(totalValue(playerHand) >= 21) {
                	done = true;
                	System.out.println(winOrLose(playerHand,dealerHand,done));
                }
            }
            else if(answer.equalsIgnoreCase("n")) {
            	done = true;
                System.out.println(winOrLose(playerHand,dealerHand,done));
            }
        	}
        }
        toReturn = calculateWinnings(winOrLose(playerHand,dealerHand,done),bet);
        return toReturn;
    }
}