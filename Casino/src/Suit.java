
public enum Suit {
	HEARTS("Hearts"),
	SPADES("Speades"),
	CLUBS("Clubs"),
	DIAMONDS("Diamonds");
	
	private String name;
	
	private Suit(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
