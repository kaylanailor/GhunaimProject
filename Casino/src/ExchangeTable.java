



public class ExchangeTable {

	/** The four different chips in the casino. */
	private static int RED_CHIP, BLUE_CHIP, GREEN_CHIP, WHITE_CHIP;
	
	/** Static block. */
	static {
		RED_CHIP = 10;
		BLUE_CHIP = 50;
		GREEN_CHIP = 100;
		WHITE_CHIP = 500;
	}
	
	/** Creates a new ExchangeTable. */
	public ExchangeTable() {
		
	}
	
	/**
	 * Get Prices for total money in fannyPack.
	 * 
	 * @param fannyPack The fannyPack of the gambler.
	 * @return The total prices that can be paid out.
	 */
	public int getTotalPayOutPrice(FannyPack fannyPack) {
		return fannyPack.getTotalBlueChips() * BLUE_CHIP +
				fannyPack.getTotalGreenChips() * GREEN_CHIP + 
				fannyPack.getTotalRedChips() * RED_CHIP + 
				fannyPack.getTotalWhiteChips() * WHITE_CHIP;
	}
	
	/**
	 * Takes all the chips from the fanny pack and returns the money that 
	 * they are equivalent to.
	 * 
	 * @param fannyPack The fanny pack
	 * @return The cost of all the chips.
	 */
	public int payOutFullCash(FannyPack fannyPack) {
		int toReturn = getTotalPayOutPrice(fannyPack);
		fannyPack.emptyPack();
		return toReturn;
	}
	
	/**
	 * Empties out all of the Blue Chips and returns the cash number.
	 * 
	 * @param fannyPack The fanny pack.
	 * @return The cost of the chips.
	 */
	public int payOutBlueChips(FannyPack fannyPack) {
		int toReturn = fannyPack.getTotalBlueChips() * BLUE_CHIP;
		fannyPack.emptyBlue();
		return toReturn;
	}
	
	/**
	 * Empties out all of the Red Chips and returns the cash number.
	 * 
	 * @param fannyPack The fanny pack.
	 * @return The cost of the chips.
	 */
	public int payOutRedChips(FannyPack fannyPack) {
		int toReturn = fannyPack.getTotalRedChips() * RED_CHIP;
		fannyPack.emptyRed();
		return toReturn;
	}

	/**
	 * Empties out all of the Green Chips and returns the cash number.
	 * 
	 * @param fannyPack The fanny pack.
	 * @return The cost of the chips.
	 */
	public int payOutGreenChips(FannyPack fannyPack) {
		int toReturn = fannyPack.getTotalGreenChips() * GREEN_CHIP;
		fannyPack.emptyGreen();
		return toReturn;
	}

	/**
	 * Empties out all of the White Chips and returns the cash number.
	 * 
	 * @param fannyPack The fanny pack.
	 * @return The cost of the chips.
	 */
	public int payOutWhiteChips(FannyPack fannyPack) {
		int toReturn = fannyPack.getTotalWhiteChips() * WHITE_CHIP;
		fannyPack.emptyWhite();
		return toReturn;
	}
	
	
}
