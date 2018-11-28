

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		//Create a new Fanny Pack.
		FannyPack fannyPack = new FannyPack();
		
		//Creates a new Gambler.
		Gambler gambler = new Gambler(fannyPack);

		//Creates a scanner.
		Scanner scanner = new Scanner(System.in);
		
		gambler.setName(getName(scanner));
		gambler.setAge(getAge(scanner));
		
		
		
		//Giving the Gambler an assortment of chips.
		fannyPack.addBlueChips(5);
		fannyPack.addGreenChips(10);
		fannyPack.addRedChips(12);
		fannyPack.addWhiteChips(15);
		ExchangeTable table = new ExchangeTable();
		sendToExchangeTable(scanner, gambler, table);
		System.out.println("Welcome to Lenny's Casino ( ͡° ͜ʖ ͡°)");
		boolean leftCasino = false;
		while (leftCasino == false) {
			System.out.println("Here are your options!\n"
			 + "A. Exchange Table\n"
					+ "B. Blackjack\n"
			 + "C. Roulette Table\n"
					+ "D. Exit\n");
			String answer = scanner.next();
			switch(answer) {
				case "A" :
					
					break;
				case "B" :
					boolean stillPlaying = true;
					while(stillPlaying == true) {
					System.out.println("How much would you like to bet?");
					int bet = scanner.nextInt();
					playBlackjack(bet);
					}
					break;
				case "C" :
					stillPlaying = true;
					while(stillPlaying == true) {
					System.out.println("How much would you like to bet?");
					int bet = scanner.nextInt();
					RouletteGame.play(bet);
					System.out.println("Would you like to keep playing? (Y/N)");
					if(scanner.next().equalsIgnoreCase("N")) {
						stillPlaying = false;
					}
					}
					break;
				case "D" :
					System.out.println("Lenny is sad pwease don't weave.");
					leftCasino = true;
					break;
				default:
					System.out.println("Invalid answer");
					break;
					
			}
		}
		
	}
	
	private static int playBlackjack(int bet) {
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
        		done = winOrLose(playerHand,dealerHand,done,bet);
        	}
        	if (done == false) {
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
        }
        input.close();
        return toReturn;
	}
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
    private static boolean winOrLose(ArrayList<PlayingCard> playerHand,ArrayList<PlayingCard> dealerHand,boolean finished, int bet) {
    	boolean toReturn = false;
        int playerTotal = totalValue(playerHand);
        int dealerTotal = totalValue(dealerHand);
        if(playerTotal > dealerTotal && playerTotal < 21) {
            System.out.println("Congrats you won! Lenny the dealer had a lower card total! ( ͡° ʖ̯ ͡°)");
            toReturn = true;
        }
        else if(playerTotal > 21) {
        	System.out.println("You lost! You went over 21! ( ͡° ͜ʖ ͡°) Lenny the Dealer called you a moron!");
        	toReturn = true;
        }
        else if(playerTotal < 21 && dealerTotal > 21) {
        	System.out.println("You won because Lenny the dealer ( ͡° ʖ̯ ͡°) fucked up by going over 21!");
        	toReturn = true;
        }
        else if(playerTotal == 21) {
        	System.out.println("Congratulations you won! You had a perfect 21! ( ͡° ʖ̯ ͡°)");
        	toReturn = true;
        }
        else if(playerTotal < dealerTotal && dealerTotal < 21) {
        	System.out.println("Lenny the Dealer won! ( ͡° ͜ʖ ͡°) with a total card value of " + totalValue(dealerHand));
        	toReturn = true;
        }
        else if(dealerTotal == 21) {
        	System.out.println("Lenny the Dealer won! ( ͡° ͜ʖ ͡°) He had a perfect hand!");
        	toReturn = true;
        }
        else if(playerTotal == dealerTotal) {
        	System.out.println("No one wins!");
        	toReturn = true;
        }
        return toReturn;
    }
	//Sends the gambler to the Exchange table.
	public static void sendToExchangeTable(Scanner scanner, Gambler gambler, ExchangeTable exchangeTable) {
		FannyPack fannyPack = gambler.getFannyPack();
		
		System.out.println("Welcome to the exchange table.\n Your options are: \n"
				+ "1. Exchange all chips \n"
				+ "2. Exchange blue chips \n"
				+ "3. Exchange red chips \n"
				+ "4. Exchange green chips \n"
				+ "5. Exchange white chips \n"
				+ "6. Get blue chips \n"
				+ "7. Get red chips \n"
				+ "8. Get green chips \n"
				+ "9. Get white chips \n"
				+ "10. Return to casino");
		
		
		
		
		boolean validAnswer = false;
		boolean wantsToQuit = false;
		while (!validAnswer || !wantsToQuit) {
			System.out.print("Enter the number 1 - 10 for the action you would like to do:");

		int answer = scanner.nextInt();
		int cash = 0;
		int gamblersCash = gambler.getCash();
		switch(answer) {
			case 1:
				if (fannyPack.getTotalBlueChips() == 0 && fannyPack.getTotalGreenChips() == 0 && fannyPack.getTotalRedChips() == 0 && fannyPack.getTotalWhiteChips() == 0) {
					System.out.println("You dont have any chips to exchange!");

				}
				else {
				System.out.println("You exchanged all of your chips for cash.");
				cash = exchangeTable.payOutFullCash(fannyPack);
				 gambler.setCash(cash);
				 System.out.println("You got " + cash + "! It has been added to your wallet.");
				}
				validAnswer = true;
			break;
		
			case 2:
				if (fannyPack.getTotalBlueChips() == 0) {
					System.out.println("You dont have any chips to exchange!");

				}
				else {
				System.out.println("You exchanged all of your blue chips for cash.");
				cash = exchangeTable.payOutBlueChips(fannyPack);
				gambler.setCash(cash);
				System.out.println("You got " + cash + "! It has been added to your wallet.");
				}
				validAnswer = true;
			break;
			
			case 3:
				if (fannyPack.getTotalRedChips() == 0) {
					System.out.println("You dont have any chips to exchange!");

				}
				else {
				System.out.println("You exchanged all of your red chips for cash.");
				cash = exchangeTable.payOutRedChips(fannyPack);
				gambler.setCash(cash);
				System.out.println("You got " + cash + "! It has been added to your wallet.");
				}
				validAnswer = true;
			break;
		
			case 4:
				if (fannyPack.getTotalGreenChips() == 0) {
					System.out.println("You dont have any chips to exchange!");
				}
				else {
				System.out.println("You exchanged all of your green chips for cash.");
				cash = exchangeTable.payOutGreenChips(fannyPack);
				gambler.setCash(cash);
				System.out.println("You got " + cash + "! It has been added to your wallet.");
				}
				validAnswer = true;
			break;
		
			case 5:
				if (fannyPack.getTotalWhiteChips() == 0) {
					System.out.println("You dont have any chips to exchange!");

				}
				else {
				System.out.println("You exchanged all of your white chips for cash.");
				cash = exchangeTable.payOutWhiteChips(fannyPack);
				gambler.setCash(cash);
				System.out.println("You got " + cash + "! It has been added to your wallet.");
				}
				validAnswer = true;
			break;
			
			case 6:
				System.out.println("How many chips would you like: ");
				int numberOfBlueChips = scanner.nextInt();
				if (numberOfBlueChips * 50 > gamblersCash) {
					System.out.println("You cant afford that!");
				}
				else {
					System.out.print("You exchanged " + numberOfBlueChips * 50 + " dollars for " + numberOfBlueChips + " blue chips!");
					gamblersCash = gamblersCash - (numberOfBlueChips * 50);
					fannyPack.addBlueChips(numberOfBlueChips);
				}
				
			break;
			
			case 7:
				System.out.println("How many chips would you like: ");
				int numberOfRedChips = scanner.nextInt();
				if (numberOfRedChips * 10 > gamblersCash) {
					System.out.println("You cant afford that!");
				}
				else {
					System.out.print("You exchanged " + numberOfRedChips * 10 + " dollars for " +  numberOfRedChips + " red chips!");
					gamblersCash = gamblersCash - (numberOfRedChips * 10);
					fannyPack.addRedChips(numberOfRedChips);
				}
				
			break;
			
			case 8:
				System.out.println("How many chips would you like: ");
				int numberOfGreenChips = scanner.nextInt();
				if (numberOfGreenChips * 100 > gamblersCash) {
					System.out.println("You cant afford that!");
				}
				else {
					System.out.print("You exchanged " + numberOfGreenChips * 100 + " dollars for " +  numberOfGreenChips + " green chips!");
					gamblersCash = gamblersCash - (numberOfGreenChips * 100);
					fannyPack.addGreenChips(numberOfGreenChips);
				}
				
			break;
			
			case 9:
				System.out.println("How many chips would you like: ");
				int numberOfWhiteChips = scanner.nextInt();
				if (numberOfWhiteChips * 500 > gamblersCash) {
					System.out.println("You cant afford that!");
				}
				else {
					System.out.print("You exchanged " + numberOfWhiteChips * 500 + " dollars for " + numberOfWhiteChips + " white chips!");
					gamblersCash = gamblersCash - (numberOfWhiteChips * 500);
					fannyPack.addWhiteChips(numberOfWhiteChips);
				}
				
			break;
		
			case 10:
				wantsToQuit = true;
				validAnswer = true;
				System.out.println("Goodbye.");
			break;
				
			default:
				System.out.println("The int you entered is not 1 - 6!");
			}
		}
		
		
	}
	
	//Gets the gamblers name.
	private static String getName(Scanner scanner) {
		String toReturn = "";
		
		System.out.print("What is your name? : ");
		
		toReturn = scanner.nextLine();
		
		return toReturn;
		
	}
	
	//Gets the gamblers age.
	private static int getAge(Scanner scanner) {
		int toReturn = 0;
		
		System.out.print("What is your age? : ");
		
		toReturn = scanner.nextInt();
		
		return toReturn;
		
	}
}
