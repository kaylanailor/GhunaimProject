/**
 * This will represent a Roulette Table.
 *
 * @author Nick.
 * version 11-11-18.
 */
public class TheWheel {
    /**This will represent a list of all the numbers that are on the wheel.*/
    private Bag wheel;
    /**This will represent the winning numberSquare for the round.*/
    private NumberSquare winningNumberSquare;

    /**
     * Constructor for TheWheel of the roulette table.
     */
    public TheWheel() {
        wheel = new Bag();
        winningNumberSquare = null;
    }

    /**
     * Method for adding a specific value to the Bag.
     *
     * @param newValue This will be the value added to the ArrayList.
     */
    public void add(NumberSquare newValue) {
        wheel.add(newValue);
    }

    /**
     * Accessor method for getting the winning NumberSquare.
     *
     * @return This will return the winning NumberSquare.
     */
    public NumberSquare getWinningNumberSquare() {
        return winningNumberSquare;
    }

    /**
     * Mutator method for setting the winning NumberSquare.
     *
     * @parem newValue This will be the new value.
     */
    public void setWinningNumberSquare(NumberSquare newValue) {
        winningNumberSquare = newValue;
    }

    /**
     * Method for spinning the wheel.
     *
     * @return This will return a numberSquare after spinning the wheel.
     */
    public NumberSquare spinTheWheel() {
        return (NumberSquare)wheel.randomEntry();
    }

    /**
     * Method for getting the size of the wheel.
     *
     * @return This will return the size of the wheel.
     */
    public int getSize() {
        return wheel.getCurrentSize();
    }
}
