import java.util.Random;
 
/**
 * Represents spades, hearts, clubs, or diamonds.
 * 
 * @author Kayla Nailor
 * @version 2018-12-2
 */
public enum Suit {
    /** Spades. */
    SPADES("Spades"),
    /** Hearts. */
    HEARTS("Hearts"),
    /** Clubs. */
    CLUBS("Clubs"),
    /** Diamonds. */
    DIAMONDS("Diamonds");
     
    /** The name of this Suit. */
    private String name;
     
    /**
     * Constructs a new Suit.
     * 
     * @param theName The name of the new Suit.
     */
    private Suit(String theName) {
        name = theName;
    }
     
    /**
     * Returns the name of this Suit.
     * 
     * @return The name of this Suit.
     */
    public String getName() {
        return name;
    }
     
    /**
     * Gets a randomly-chosen Suit.
     * 
     * @return A randomly-chosen Suit.
     */
    public static Suit getRandomSuit() {
        // This class makes random numbers for us.  Make sure you import it!
        Random random = new Random();
        // Remember, all enumerations have this method automatically.
        Suit[] allSuits = Suit.values();
        // This gets me a random number between 0 and the number of suits.
        int index = random.nextInt(allSuits.length);
        // This returns whichever suit was randomly chosen.
        return allSuits[index];
    }
}