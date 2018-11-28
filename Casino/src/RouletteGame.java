import java.util.Scanner;

public class RouletteGame {
	public static int play(int bet) {
        System.out.println("Welcome to the Roulette Table!");
        RouletteTable table = new RouletteTable(5);
        TheWheel wheel = new TheWheel();
        int finalEarnings = 0;
        for (int index = 0; index < 36; index++) {
            if (index % 2 == 0) {
                NumberSquare black = new NumberSquare("black", index);
                wheel.add(black);
            } else {
                NumberSquare red = new NumberSquare("red", index);
                wheel.add(red);
            }
        }
        boolean results = false;
        while (results == false) {
        	Scanner input = new Scanner(System.in);
                table.setBet(bet);
                System.out.println("You have bet " + bet + " dollars!");
                    
                        System.out.println("Please pick a color: red or black");
                        String color = input.next();
                        if (color.equalsIgnoreCase("red")) {
                            System.out.println("The wheel is being spun!");
                            NumberSquare randomNumber = wheel.spinTheWheel();
                            System.out.println("The winning color is " + randomNumber.getColor() + "!");
                            if (color.equalsIgnoreCase(randomNumber.getColor())) {
                                finalEarnings = bet * 2;
                                System.out.println("You have earned " + finalEarnings + " dollars!");
                                results = true;
                            }
                            else {
                                System.out.println("You lost your money!");
                                results = true;
                            }
                        }
                        else if (color.equalsIgnoreCase("black")) {
                            System.out.println("The wheel is being spun!");
                            NumberSquare randomNumber = wheel.spinTheWheel();
                            System.out.println("The winning square is " + randomNumber.getColor() + "!");
                            if (color.equalsIgnoreCase(randomNumber.getColor())) {
                                finalEarnings = bet * 2;
                                System.out.println("You have earned " + finalEarnings + " dollars!");
                                results = true;
                            }
                            else {
                                System.out.println("You lost your money!");
                                results = true;
                            }
                        }
                    }
                        
                    
        
		return finalEarnings;

    }

}
