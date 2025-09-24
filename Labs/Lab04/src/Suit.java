public enum Suit{
	SPADES('s'), HEARTS('h'), CLUBS('c'), DIAMONDS('d');

	private char symbol;
	Suit(char symbol){
		this.symbol = symbol;
	}

	public char getSymbol(){
		return symbol;
	}
}