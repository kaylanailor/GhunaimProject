
/**
 * This will represent a Roulette Table.
 *
 * @author Nick.
 * version 11-11-18.
 */


public class RouletteTable {
    /**This will represent how much it costs to play the game.*/
    private int minimumBet;
    /**This will represent the amount of money won.*/
    private int earnings;
    /**This will represent the amount of money bet on the table.*/
    private int bet;

    /**
     * Constructor for the RouletteTable
     *
     * @param minimumBet This will be the minimum bet to enter the table.
     */
    public RouletteTable(int minimumBet) {
        this.minimumBet = minimumBet;
        this.earnings = 0;
        this.bet = 0;
    }

    /**
     * Accessor method for getting the minimumBet.
     *
     * @return This will return the minimum bet.
     */
    public int getMinimumBet() {
        return minimumBet;
    }

    /**
     * Mutator method for changing the minimumBet.
     *
     * @param newBet This will be the new minimum bet.
     */
    public void setMinimumBet(int newBet) {
        minimumBet = newBet;
    }

    /**
     * Accessor method for the amount of money won.
     *
     * @return This will return the amount of money won.
     */
    public int getEarnings() {
        return earnings;
    }

    /**
     * Mutator method for the setting the earnings.
     *
     * @param newEarnings This will be the new earnings for the player.
     */
    public void setEarnings(int newEarnings) {
        earnings = newEarnings;
    }

    /**
     * Accessor method for getting the bet.
     *
     * @return This will return the bet placed by the player.
     */
    public int getBet() {
        return bet;
    }

    /**
     * Mutator method for setting the bet by the player.
     *
     * @param playerBet This will represent the bet set by the player.
     */
    public void setBet(int playerBet) {
        bet = playerBet;
    }
}
