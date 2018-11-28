


public class Gambler {

	
	/** The name of the gambler. */
	private String name;
	
	/** The age of the gambler. */
	private int age;
	
	/** The total amount of cash the gambler has. */
	private int cash;
	
	/** The fanny pack of the gambler. */
	private FannyPack fannyPack;
	
	/** Creates a new Gambler. */
	public Gambler(FannyPack fannyPack) {
		this.name = "tempName";
		this.setFannyPack(fannyPack);
		this.cash = 0;
	}
	
	/** Sets the name of the Gambler.
	 * 
	 * @param name The name of the Gambler.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** Gets the name of the Gambler. 
	 * 
	 * @return The name of the Gambler.
	 */
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setCash(int newAmmount) {
		this.cash = cash + newAmmount;
	}
	
	public int getCash() {
		return cash;
	}

	public FannyPack getFannyPack() {
		return fannyPack;
	}

	public void setFannyPack(FannyPack fannyPack) {
		this.fannyPack = fannyPack;
	}
}
