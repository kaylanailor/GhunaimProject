/**
 * A card that is used to play games in blackjack.
 *
 * @author Kayla Nailor
 * @version February 16th, 2018
 */
public class PlayingCard {
    /** A field that stores the suit of the card. */
    public Suit suit;
    /** A field that stores the denomination of the card. */
    public Denomination denomination;
    /**
     * A constructor for class PlayingCard.
     */
    public PlayingCard(Suit suit, Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }
    /**
     * An accessor method for the card's suit
     * @return Suit
     */
    public Suit getSuit() {
        return suit;
    }
    /**
     * An accessor method for the card's denomination
     */
    public Denomination getDenomination() {
        return denomination;
    }
    /**
     * A toString method to give a representation of the cards.
     * @return String
     */
    public String toString() {
        String value = String.format("%s of %s",denomination.getDenomName(),suit.getName());
        return value;
    }
    /**
     * A static method to return a random playing card.
     * @return playing card
     */
    public static PlayingCard getRandomPlayingCard() {
        Suit newSuit = Suit.getRandomSuit();
        Denomination newDenomination = Denomination.getRandomDenomination();
        return new PlayingCard(newSuit,newDenomination);
    }
}
