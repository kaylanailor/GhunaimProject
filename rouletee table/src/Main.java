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
                int bet = input.nextInt();
                table.setBet(bet);
                System.out.println("You have bet " + table.getBet() + " dollars!");
                System.out.println("Please enter a number for the square you wish to bet on");
                int number = input.nextInt();
                System.out.println("Please enter either red or black you wish to bet on");
                String color = input.next();
                System.out.println("The wheel is being spun!");
                NumberSquare randomNumber = wheel.spinTheWheel();
                System.out.println("The winning square is " + randomNumber.getNumber() + " " + randomNumber.getColor() + "!");
                if (randomNumber.getNumber() == number && randomNumber.getColor().equalsIgnoreCase(color)) {
                    int finalEarnings = bet * 2;
                    System.out.println("You have earned " + finalEarnings + " dollars!");
                }
                else {
                    System.out.println("You lost your money!");
                }
            }
            if (response.equalsIgnoreCase("n")) {
                System.out.println("Maybe next Time!");
                results = true;
            }
        }
    }
}

