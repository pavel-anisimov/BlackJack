package pavel.game.bj;

public class Game {
	
	private int userScore;
	private int compScore;
	private int [] score;
	private Deck deck;
	private Card [][] hand;
	private Card lastCard;
	private int curentCard;
	private int playingUser;
	private boolean ace;
	private boolean plusTen;
	
	public Game() {
		ace = false;
		plusTen = false;
		score = new int [2];
		score[0] = 0;
		score[1] = 0;
		playingUser = 0;
		deck = new Deck();
		hand = new Card [2][7];
	}
	
	public void userPlayCard(int usr) {
		lastCard = deck.drawFromDeck();
		hand[usr][curentCard] = lastCard;
		this.curentCard++;
		System.out.println(curentCard + " is the curent card");
	}
	
	public void compPlayCard() {
		
	}
	
	public int showUserScore (int usr) {
		score[usr] = 0;
		int tempScore;
		for (int i = 0; i < curentCard; i++) {
			tempScore = hand[usr][i].getValue();
			if (tempScore == 1)
				ace = true;
			score[usr] = score[usr] + tempScore;
			System.out.println (score[usr] + " curent score");
		}
		if (ace == true && score[usr] <= 11) {
			score[usr] = score[usr] + 10;
			plusTen = true;
		}
		if (ace == true && score[usr] > 21 && plusTen == true) {
			score[usr] = score[usr] - 10;
			plusTen = false;
		}
		return score[usr];
	}

	public int showCompScore () {
		return compScore;
	}
	
	public Card showLastCard (){
		return lastCard;
	}
	
	public int showPlayingUser(){
		return playingUser;
	}
	
	public void changePlaingUser (int usr) {
		this.playingUser = usr;
	}
	
	public int showCurentCard (){
		return curentCard;
	}
	
	public boolean checkBust(int points) {
		if (points > 21) 
			return true;
		else 
			return false;
	}
	public boolean checkBlackJack(int points) {
		if (points == 21 && 
				this.showCurentCard() == 2 && 
				(hand[playingUser][0].getRank() != "10" || hand[playingUser][0].getRank() != "10") )
				 
			return true;
		else 
			return false;
	}
	
	@SuppressWarnings("unused")
	private void setScore(int u) {
		
	}

}


