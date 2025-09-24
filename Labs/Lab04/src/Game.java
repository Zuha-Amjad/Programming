public class Game{
	Player players[];
	Deck deck;
	Card inPlayCards[];

	static int roundCounter = 0;

	

	public Game(final int noOfPlayers){
		
		deck = new Deck();
		deck.shuffle();
		deck.displayDeck();
 
		players = new Player[noOfPlayers];

		int count = 1;  //For player name

		for(int  i = 0; i < players.length; i++)
			players[i] = new Player("Player "+ count++, 52/players.length); 

		roundCounter = 0;
		
	}

	public void deal(){
		int count = 0; 
		for(int i = 0; i < players.length; i++)
			for(int j = 0; j < 52/players.length; j++)
				players[i].setHand(j, deck.getCard(count++));
		for(int i = 0; i < players.length; i++)
			players[i].showHand();
		
	}


	public void playHand(){
		
		inPlayCards = new Card[players.length];

		//Loop to through a card
		for(int i = 0; i < players.length; i++)
			inPlayCards[i] = players[i].throwCard();
		
		System.out.println("\n==========Round " + (roundCounter+1) + "==========");
		System.out.println("\nCards Thrown:");
		for(int i = 0; i < players.length; i++){

			System.out.println("Player " + (i+1)+ ": " + inPlayCards[i]);
		}

		int roundWinner;

		//To get winner
		if(inPlayCards[0].getRank().getValue() > inPlayCards[1].getRank().getValue() && inPlayCards[0].getRank().getValue() > inPlayCards[2].getRank().getValue())
				roundWinner = 0;
		else if(inPlayCards[1].getRank().getValue() > inPlayCards[0].getRank().getValue() && inPlayCards[1].getRank().getValue() > inPlayCards[2].getRank().getValue())
				roundWinner = 1;
		else	
				roundWinner = 2;
		


		//Add points
		int points = 10;
		players[roundWinner].calculateScore(points);

		//Dislpay Score

		System.out.println("\n==========Score Board==========");
		for(int i = 0; i < players.length; i++)
			players[i].scoreBoard(i);

		//Round added
		roundCounter++;
	}


	public void getWinner(){
		

		//Array to store scores
		int score[] = new int[3];

		for(int i = 0; i < players.length; i++)
			score[i] = players[i].getCurrentScore();

		int winner;

		if(score[0] > score[1]  && score[0]  > score[2] )
				winner = 0;
		else if(score[1] > score[0]  && score[1]  > score[2] )
				winner = 1;
		else if(score[2] > score[1]  && score[2]  > score[1] )
				winner = 2;
		else
				winner = 3;

		if(winner == 0 || winner ==1 || winner ==2)
			System.out.println("\nCongratualtions! PLAYER "+ (winner+1) + " won!");

		else
			System.out.println("\nIt's a TIE!");
		System.out.print("GAME OVER! ");
	}
	
	public int getRoundCounter(){
		return roundCounter;
	}

}