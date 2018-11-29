
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Create a new Fanny Pack.
		FannyPack fannyPack = new FannyPack();

		// Creates a new Gambler.
		Gambler gambler = new Gambler(fannyPack);

		// Creates a scanner.
		Scanner scanner = new Scanner(System.in);

		gambler.setName(getName(scanner));
		gambler.setAge(getAge(scanner));

		// Giving the Gambler an assortment of chips.
		fannyPack.addBlueChips(5);
		fannyPack.addGreenChips(10);
		fannyPack.addRedChips(12);
		fannyPack.addWhiteChips(15);
		ExchangeTable table = new ExchangeTable();
		System.out.println("Welcome to Lenny's Casino ( ͡° ͜ʖ ͡°)");
		System.out.println("Since this is your first time here, we encourage you to exchange your chips for money.");
		boolean leftCasino = false;
		while (leftCasino == false) {
			System.out.println("Here are your options!\n" + "A. Exchange Table\n" + "B. Blackjack\n"
					+ "C. Roulette Table\n" + "D. Exit\n");
			String answer = scanner.next();
			switch (answer) {
			case "A":
			case "a":
				sendToExchangeTable(scanner, gambler, table);
				break;
			case "B":
			case "b":
				boolean stillPlaying = true;
				while (stillPlaying == true) {
					System.out.println("How much would you like to bet?");
					int bet = scanner.nextInt();
					gambler.setCash(-bet);
					int winnings = Blackjack.play(scanner, bet);
					gambler.setCash(winnings);
					System.out.println("You currently have " + gambler.getCash() + " in cash.");
					if (gambler.getCash() != 0) {
						System.out.println("Would you like to keep playing? (Y/N)");
						String next = scanner.next();
						if (next.equalsIgnoreCase("N")) {
							stillPlaying = false;
						}
					}
					else if(gambler.getCash() == 0 && (fannyPack.getTotalBlueChips() != 0 || fannyPack.getTotalGreenChips() != 0 || fannyPack.getTotalRedChips() != 0 || fannyPack.getTotalWhiteChips() != 0)) {
						System.out.println("You have no cash but you have more chips. If you want to continue playing please go to the Exchange Table.");
						stillPlaying = false;
					}
					else {
						System.out.println("You have no money or chips! The casino has kicked you out!");
						leftCasino = true;
						stillPlaying = false;
					}
				}
				break;
			case "C":
			case "c":
				stillPlaying = true;
				while (stillPlaying == true) {
					System.out.println("How much would you like to bet?");
					int bet = scanner.nextInt();
					gambler.setCash(-bet);
					int winnings = RouletteGame.play(bet, scanner);
					gambler.setCash(winnings);
					System.out.println("You currently have " + gambler.getCash() + " in cash.");
					if (gambler.getCash() > 0) {
						System.out.println("Would you like to keep playing? (Y/N)");
						String next = scanner.next();
						if (next.equalsIgnoreCase("N")) {
							stillPlaying = false;
						}
					}
					else if(gambler.getCash() <= 0 && (fannyPack.getTotalBlueChips() != 0 || fannyPack.getTotalGreenChips() != 0 || fannyPack.getTotalRedChips() != 0 || fannyPack.getTotalWhiteChips() != 0)) {
						System.out.println("You have no cash but you have more chips. If you want to continue playing please go to the Exchange Table.");
						stillPlaying = false;
					}
					else {
						System.out.println("You have no money or chips! The casino has kicked you out!");
						leftCasino = true;
						stillPlaying = false;
					}
					
				}
				break;
			case "D":
			case "d":
				System.out.println("Lenny is sad pwease don't weave.");
				leftCasino = true;
				break;
			default:
				System.out.println("Invalid answer");
				break;

			}
		}

	}

	// Sends the gambler to the Exchange table.
	public static void sendToExchangeTable(Scanner scanner, Gambler gambler, ExchangeTable exchangeTable) {
		FannyPack fannyPack = gambler.getFannyPack();

		System.out.println("Welcome to the exchange table.\n Your options are: \n" + "1. Exchange all chips \n"
				+ "2. Exchange blue chips \n" + "3. Exchange red chips \n" + "4. Exchange green chips \n"
				+ "5. Exchange white chips \n" + "6. Get blue chips \n" + "7. Get red chips \n"
				+ "8. Get green chips \n" + "9. Get white chips \n" + "10. Return to casino");

		boolean validAnswer = false;
		boolean wantsToQuit = false;
		while (!validAnswer || !wantsToQuit) {
			System.out.print("Enter the number 1 - 10 for the action you would like to do:");

			int answer = scanner.nextInt();
			int cash = 0;
			int gamblersCash = gambler.getCash();
			switch (answer) {
			case 1:
				if (fannyPack.getTotalBlueChips() == 0 && fannyPack.getTotalGreenChips() == 0
						&& fannyPack.getTotalRedChips() == 0 && fannyPack.getTotalWhiteChips() == 0) {
					System.out.println("You dont have any chips to exchange!");

				} else {
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

				} else {
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

				} else {
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
				} else {
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

				} else {
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
				} else {
					System.out.print("You exchanged " + numberOfBlueChips * 50 + " dollars for " + numberOfBlueChips
							+ " blue chips!");
					gamblersCash = gamblersCash - (numberOfBlueChips * 50);
					fannyPack.addBlueChips(numberOfBlueChips);
				}

				break;

			case 7:
				System.out.println("How many chips would you like: ");
				int numberOfRedChips = scanner.nextInt();
				if (numberOfRedChips * 10 > gamblersCash) {
					System.out.println("You cant afford that!");
				} else {
					System.out.print("You exchanged " + numberOfRedChips * 10 + " dollars for " + numberOfRedChips
							+ " red chips!");
					gamblersCash = gamblersCash - (numberOfRedChips * 10);
					fannyPack.addRedChips(numberOfRedChips);
				}

				break;

			case 8:
				System.out.println("How many chips would you like: ");
				int numberOfGreenChips = scanner.nextInt();
				if (numberOfGreenChips * 100 > gamblersCash) {
					System.out.println("You cant afford that!");
				} else {
					System.out.print("You exchanged " + numberOfGreenChips * 100 + " dollars for " + numberOfGreenChips
							+ " green chips!");
					gamblersCash = gamblersCash - (numberOfGreenChips * 100);
					fannyPack.addGreenChips(numberOfGreenChips);
				}

				break;

			case 9:
				System.out.println("How many chips would you like: ");
				int numberOfWhiteChips = scanner.nextInt();
				if (numberOfWhiteChips * 500 > gamblersCash) {
					System.out.println("You cant afford that!");
				} else {
					System.out.print("You exchanged " + numberOfWhiteChips * 500 + " dollars for " + numberOfWhiteChips
							+ " white chips!");
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

	// Gets the gamblers name.
	private static String getName(Scanner scanner) {
		String toReturn = "";

		System.out.print("What is your name? : ");

		toReturn = scanner.nextLine();

		return toReturn;

	}

	// Gets the gamblers age.
	private static int getAge(Scanner scanner) {
		int toReturn = 0;

		System.out.print("What is your age? : ");

		toReturn = scanner.nextInt();

		return toReturn;

	}
}
