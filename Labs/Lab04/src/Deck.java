import java.util.Random;

public class Deck{

	private Card cards[];
	
	public Deck(){
		cards = new Card[52];
		Suit suits[] = Suit.values();  //Store the values of suit in an array
		Rank ranks[] = Rank.values();

		int count =0;
		for(int i = 0; i < suits.length; i++)
			for(int j = 0; j < ranks.length; j++)
			{	
				cards[count++] = new Card(suits[i], ranks[j]);
			}
	}


	public void displayDeck(){
		System.out.println("\n====Deck=====");
		for(int i = 0; i < cards.length; i++)
			System.out.println(cards[i].toString());

		System.out.println("");
	}

	
	public void shuffle(){
		Random rand = new Random();
		Card temp;
		for(int i =0; i<2000; i++)
		{
			int ran = rand.nextInt(52);

			temp = cards[0];
			cards[0] = cards[ran]; 
			cards[ran] = temp;
		}
	}


	public Card getCard(int index){
		return this.cards[index];
	}
}