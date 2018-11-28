import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * A class to create a game of BlackJack.
 *
 * @author Kayla Nailor
 * @version February 2nd, 2018
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
     * A static helper method to return whether you lost or won and how you did it.
     * @return string
     */
    private static int winOrLose(ArrayList<PlayingCard> playerHand,ArrayList<PlayingCard> dealerHand,boolean finished, int bet) {
    	int toReturn = 0;
        int playerTotal = totalValue(playerHand);
        int dealerTotal = totalValue(dealerHand);
        if(playerTotal > dealerTotal && playerTotal < 21) {
            System.out.println("Congrats you won! Lenny the dealer had a lower card total! ( ͡° ʖ̯ ͡°)");
            toReturn = 2 * bet;
        }
        else if(playerTotal > 21) {
        	System.out.println("You lost! You went over 21! ( ͡° ͜ʖ ͡°) Lenny the Dealer called you a moron!");
        }
        else if(playerTotal < 21 && dealerTotal > 21) {
        	System.out.println("You won because Lenny the dealer ( ͡° ʖ̯ ͡°) fucked up by going over 21!");
        	toReturn = 2 * bet;
        }
        else if(playerTotal == 21) {
        	System.out.println("Congratulations you won! You had a perfect 21! ( ͡° ʖ̯ ͡°)");
        	toReturn = 3 * bet;
        }
        else if(playerTotal < dealerTotal && dealerTotal < 21) {
        	System.out.println("Lenny the Dealer won! ( ͡° ͜ʖ ͡°) with a total card value of " + totalValue(dealerHand));
        }
        else if(dealerTotal == 21) {
        	System.out.println("Lenny the Dealer won! ( ͡° ͜ʖ ͡°) He had a perfect hand!");
        }
        else if(playerTotal == dealerTotal) {
        	System.out.println("No one wins!");
        	toReturn = bet;
        }
        return toReturn;
    }
 
    /**
     * A method to create a game of BlackJack.
     */
    public static int play(int bet) {
        Scanner input = new Scanner(System.in);
        int toReturn = bet;
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
        		toReturn = winOrLose(playerHand,dealerHand,done,bet);
        	}
            System.out.print("Would you like to recieve another card?(y/n)");
            String answer = input.next();
            if(answer.equals("y")) {
                PlayingCard newCard = PlayingCard.getRandomPlayingCard();
                playerHand.add(newCard);
                System.out.println("You recieve a " + newCard.toString());
                if(totalValue(playerHand) >= 21) {
                	done = true;
                	winOrLose(playerHand,dealerHand,done,bet);
                }
            }
            else {
                done = true;
                winOrLose(playerHand,dealerHand,done,bet);
            }
        }
        input.close();
        return toReturn;
    }
}