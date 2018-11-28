import java.util.Random;
/**
 * What the card can be.
 *
 * @author Kayla Nailor
 * @version February 16th, 2018
 */
public enum Denomination
{
    /** Ace */
    ACE('A',11),
    /** One */
    ONE('1',1),
    /** Two */
    TWO('2',2),
    /** Three */
    THREE('3',3),
    /** Four */
    FOUR('4',4),
    /** Five */
    FIVE('5',5),
    /** Six */
    SIX('6',6),
    /** Seven */
    SEVEN('7',7),
    /** Eight */
    EIGHT('8',8),
    /** Nine */
    NINE('9',9),
    /** Ten */
    TEN('0',10),
    /** Jack */
    JACK('J',10),
    /** Queen */
    QUEEN('Q',10),
    /** King */
    KING('K',10);
    /** one letter name for denomination */
    private char denomName;
    /** a field to store the value of a card */
    private int value;
    /**
     * A private constructor for Denomination.
     * @param denomName = one-letter name of denomination
     * @param value = value of card
     */
    private Denomination(char denomName, int value) {
        this.denomName = denomName;
        this.value = value;
    }
    /**
     * Accessor method for denomination char
     * @return char
     */
    public char getDenomName() {
        return denomName;
    }
    /**
     * Accessor method for value for card.
     * @return int
     */
    public int getValue() {
        return value;
    }
    /**
     * A static method to return a random denomination.
     */
    public static Denomination getRandomDenomination() {        
        Random random = new Random();
        Denomination[] allDenominations = Denomination.values();
        int index = random.nextInt(allDenominations.length);
        return allDenominations[index];
    }
}