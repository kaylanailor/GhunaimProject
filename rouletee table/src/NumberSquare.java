/**
 * This will represent a square on the table.
 *
 * @author Nick.
 * version 11-11-18.
 */
public class NumberSquare {
    /**This will represent the color of the square.*/
    private String color;
    /**This will represent the number of the square.*/
    private int number;

    /**
     * Constructor for the NumberSquare Class.
     *
     * @param color This will represent the color.
     *
     * @param number This will represent the number.
     */
    public NumberSquare(String color, int number) {
        this.color = color;
        this.number = number;
    }

    /**
     * Accesor method for the color.
     *
     * @return This will return the color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Accessor method for the number.
     *
     * @return This will return the number of the square.
     */
    public int getNumber() {
        return number;
    }
}