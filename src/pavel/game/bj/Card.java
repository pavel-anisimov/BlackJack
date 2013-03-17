package pavel.game.bj;

public class Card {
	private int id;
	private String rank;
	private String suit;
	private int value;
	
	
	Card(int id, String suit, String rank, int value) {
		this.rank = rank;
		this.suit = suit;
		this.value = value;
		this.id = id;
	}
	
	public @Override String toString() {
		return rank + " of " + suit;
	}
		
	public String getRank() {
         return rank;
    }

	public String getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	
}
