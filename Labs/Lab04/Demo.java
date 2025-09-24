public class Demo{
	public static void main(String args[]){
		
		Game g1= new Game(3);

		g1.deal();
	
		while(Game.roundCounter < 5)
			g1.playHand();

		g1.getWinner();

	}
}