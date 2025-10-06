public class SeatID{
	private int row;
	private int column;
	private char type;

	SeatID(int row, int column, SeatType seatType){
		this.row = row;
		this.column = column;
		this.type = seatType.getId();
	}


	@Override
	public String toString(){
		return String.format("%c-%d-%03d", type,row, column);
	}

	@Override
	public boolean equals(Object o){
		SeatID s = (SeatID)o;

		if(this.row == s.row && this.column == s.column && this.type == s.type)
			return true;
		else
			return false;
	}

	public int getRow(){
		return this.row;
	}
	public int getColumn(){
		return this.column;
	}
	public char getType(){
		return this.type;
	}

}