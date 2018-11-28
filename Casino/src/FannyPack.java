

public class FannyPack {

	
	/** The total chips of each color in the FannyPack. */
	private int totalRedChips, totalBlueChips, totalGreenChips, totalWhiteChips;
	
	/** Creates a new FannyPack. */
	public FannyPack() {
		totalRedChips = 0;
		totalBlueChips = 0;
		totalGreenChips = 0;
		totalWhiteChips = 0;
	}

	
	
	// Getters and Setters for red, blue, green and white chips.
	public int getTotalWhiteChips() {
		return totalWhiteChips;
	}

	public void addWhiteChips(int whiteChips) {
		this.totalWhiteChips = whiteChips + getTotalWhiteChips();
	}

	public int getTotalGreenChips() {
		return totalGreenChips;
	}

	public void addGreenChips(int greenChips) {
		this.totalGreenChips = greenChips + getTotalGreenChips();
	}

	public int getTotalBlueChips() {
		return totalBlueChips;
	}

	public void addBlueChips(int blueChips) {
		this.totalBlueChips = blueChips + getTotalBlueChips();
	}

	public int getTotalRedChips() {
		return totalRedChips;
	}

	public void addRedChips(int redChips) {
		this.totalRedChips = redChips + getTotalRedChips();
	}
	
	/**
	 * Empties all chips from the bag.
	 */
	public void emptyPack() {
		this.totalBlueChips = 0;
		this.totalGreenChips = 0;
		this.totalRedChips = 0;
		this.totalWhiteChips = 0;
	}
	
	/**
	 * Empties all blue chips from the bag.
	 */
	public void emptyBlue() {
		this.totalBlueChips = 0;
	}
	
	/**
	 * Empties all red chips from the bag.
	 */
	public void emptyRed() {
		this.totalRedChips = 0;
	}
	
	/**
	 * Empties all green chips from the bag.
	 */
	public void emptyGreen() {
		this.totalGreenChips = 0;
	}
	
	/**
	 * Empties all white chips from the bag.
	 */
	public void emptyWhite() {
		this.totalWhiteChips = 0;
	}
}
