public class Seat{

	private SeatID seatId;
	private SeatType seatType;
	private double ticketPrice;
	private boolean isAvailable;

	//For Array Indexes the ID would be different
	public Seat(int i, int j, SeatType seatType, double ticketPrice){
		setSeatId( i+1, j+1, seatType);
		setSeatType(seatType);	
		setTicketPrice(ticketPrice);
		this.isAvailable = true;	
	}

	//For Normal Seat
	public Seat(SeatType seatType, int row, int column, double ticketPrice){
		setSeatId(row, column, seatType);
		setSeatType(seatType);	
		setTicketPrice(ticketPrice);
		this.isAvailable = true;	
	}


	public Seat(){
	}

	@Override
	public String toString(){
		return String.format("%-10s %-10s %10.2f %7b", seatId,seatType, ticketPrice, isAvailable);
	}


	public void bookSeat(){
		//Check If already Booked
		if(this.isAvailable == true){
			this.isAvailable = false;
			System.out.println(String.format("CONGRATULATIONS! Seat %s is Booked!\nThank You!\n", seatId));
		}
		else
			System.out.println(String.format("SORRY! Seat %s is Already Booked!\n", this.seatId));
		
	}

	public void cancelSeat(){
		if(this.isAvailable == true){
			System.out.println(String.format("CANCELLATION REQUEST: Requested Seat %s isn't Booked!\n", this.seatId));
		}
		else{
			this.isAvailable = true;
			System.out.println(String.format("SUCCESSFUl: Cancellation of Seat %s is Confirmed!\n", this.seatId));
		}
	}


	public static String arrayToString(Seat[] seats){
		StringBuilder str = new StringBuilder();
	
		str.append("\n=== SEATS ===\n");

		for(int i = 0; i < seats.length; i++){
			str.append(String.format("[%s] ", seats[i].getSeatId()));
		}
		return str.toString();
	}
	


	//Setters & Getters

	//Set the Seat ID
	public void setSeatId(int row, int column, SeatType type){
		this.seatId = new SeatID((row), (column), type);
	}

	public void setSeatType(SeatType seatType){
		this.seatType = seatType;

	}
	public void setTicketPrice(double ticketPrice){
		this.ticketPrice = ticketPrice;

	}
	public void setisAvailabe(boolean isAvailable){
		this.isAvailable = isAvailable;

	}
	public boolean getIsAvailable(){
		return this.isAvailable;

	}
	public SeatID getSeatId(){
		 return this.seatId;
	}
	public SeatType getSeatType(){
		return this.seatType;

	}
	public double getTicketPrice(){
		return this.ticketPrice;
	}
}


enum SeatType{
	STANDARD('S', 500), PREMIUM('P', 750), VIP('V', 1000), RECLINER('R',1200);
	
	private char id;
	private final double PRICE;
		
	SeatType(char id, double PRICE){
		this.id = id;
		this.PRICE = PRICE;
	}

	public char getId(){
		return id;
	}

	public double getPRICE(){
		return PRICE;
	}

}