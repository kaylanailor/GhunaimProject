import java.util.Scanner;
import java.util.Random;
/**
 * This will test our code.
 *
 * @author Nick
 * @version 11-11-18
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Roulette Table!");
        RouletteTable table = new RouletteTable(5);
        TheWheel wheel = new TheWheel();
        for (int index = 0; index < 36; index++) {
            if (index % 2 == 0) {
                NumberSquare black = new NumberSquare("black", index);
                wheel.add(black);
            } else {
                NumberSquare red = new NumberSquare("red", index);
                wheel.add(red);
            }
        }
        System.out.println("This table costs " + table.getMinimumBet() + " dollars to play");
        boolean results = false;
        while (results == false) {
            System.out.println("Would you like to bet? y/n");
            Scanner input = new Scanner(System.in);
            String response = input.next();
            if (response.equalsIgnoreCase("y")) {
                System.out.print("Enter the numerical amount you would like to bet: ");
                boolean success = false;
                int bet = 0;
                while (success == false) {
                    if (input.hasNextInt()) {
                        bet = input.nextInt();
                        if (bet >= table.getMinimumBet()) {
                            success = true;
                        }
                        else if (bet < table.getMinimumBet()) {
                            System.out.println("Please place a bet greater than the house bet: " + table.getMinimumBet() + " dollars!");
                        }
                    }
                    else {
                        input.next();
                        System.out.println("Invalid bet please enter a valid number!");
                    }
                }
                table.setBet(bet);
                System.out.println("You have bet " + table.getBet() + " dollars!");
                    System.out.println("What would you like to bet on?");
                    System.out.println("A. A color");
                    System.out.println("B. A specific square");
                    String chooseOfBet = input.next();
                    if (chooseOfBet.equalsIgnoreCase("a")) {
                        System.out.println("Please pick a color: red or black");
                        String color = input.next();
                        if (color.equalsIgnoreCase("red")) {
                            System.out.println("The wheel is being spun!");
                            NumberSquare randomNumber = wheel.spinTheWheel();
                            System.out.println("The winning color is " + randomNumber.getColor() + "!");
                            if (color.equalsIgnoreCase(randomNumber.getColor())) {
                                int finalEarning = bet * 2;
                                System.out.println("You have earned " + finalEarning + " dollars!");
                            }
                            else {
                                System.out.println("You lost your money!");
                            }
                        }
                        else if (color.equalsIgnoreCase("black")) {
                            System.out.println("The wheel is being spun!");
                            NumberSquare randomNumber = wheel.spinTheWheel();
                            System.out.println("The winning square is " + randomNumber.getColor() + "!");
                            if (color.equalsIgnoreCase(randomNumber.getColor())) {
                                int finalEarning = bet * 2;
                                System.out.println("You have earned " + finalEarning + " dollars!");
                            }
                            else {
                                System.out.println("You lost your money!");
                            }
                        }
                    }
                    else if (chooseOfBet.equalsIgnoreCase("b")) {
                        System.out.println("There are a total of 36 number squares you can choose.");
                        System.out.println("Please enter a number for the square you wish to bet on");
                        int number = input.nextInt();
                        System.out.println("Please enter either red or black you wish to bet on");
                        String color = input.next();
                        System.out.println("The wheel is being spun!");
                        NumberSquare randomNumber = wheel.spinTheWheel();
                        System.out.println("The winning square is " + randomNumber.getNumber() + " " + randomNumber.getColor() + "!");
                        if (randomNumber.getNumber() == number && randomNumber.getColor().equalsIgnoreCase(color)) {
                            int finalEarnings = bet * 10;
                            System.out.println("You have earned " + finalEarnings + " dollars!");
                        }
                        else {
                            System.out.println("You lost your money!");
                        }
                    }
                }
            if (response.equalsIgnoreCase("n")) {
                System.out.println("Maybe next Time!");
                results = true;
            }
        }
    }
}



