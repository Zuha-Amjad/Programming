//SP25-BCS-145

public class Screen{

	private String screenName;
	private String movieName;
	private Seat[][] seats;
	private int DEFAULT_NUM_ROWS = 5;


	public Screen(String screenName,String movieName){
		this(screenName, movieName, -1);
	}

	//Add screen with custom Row length
	public Screen(String screenName, String movieName, int rowLength){
		setScreenName(screenName);
		setMovieName(movieName);

		//Default Row Length's Constructor calls set default row Length
		if(rowLength == -1){
			//Fixed rows
			seats = new Seat[DEFAULT_NUM_ROWS][];

			int counter = 10;

			//Loop to initialize array with different columns
			for(int i = 0; i < seats.length;i++){
				seats[i] = new Seat[counter]; //variable columns 
				counter+= 1;
			}
		}

		//Set Custom row Length
		else{
			//Fixed rows & Columns
			seats = new Seat[DEFAULT_NUM_ROWS][rowLength];
		}

		//Initialize Objects
		for(int i = 0; i < seats.length;i++){
			setRowType(seats, i);
		}
	}

	public Screen(){
	}

	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();

		str.append("         "+ screenName + "\n" );
		str.append(String.format("Movie:     %-20s\n=====================================\n", movieName));
		for(int i = 0; i < seats.length;i++){
			for(int j = 0; j < seats[i].length;j++){
				str.append(seats[i][j]);
				str.append("\n");
			}
			str.append("");
		}
		return str.toString();
	}

	//By Coordinates
	public void bookSeat(int row, int column){
		if(checkBounds(row, column)){
			//Indices are '1' less than the SeatID which is given by user
			seats[row-1][column-1].bookSeat();  
		}
		else
			System.out.println(String.format("SORRY! The Requested Seat %d-%03d is Incorrect!\nTry Again!\n", row,column));
	}

	//By ID
	public void bookSeat(SeatID seatID){
		int row = seatID.getRow();
		int column = seatID.getColumn();

		if(checkBounds(row, column) && seatID.getType() == seats[row][column].getSeatId().getType())	
				seats[row-1][column-1].bookSeat(); 
		else
			System.out.println(String.format("SORRY! The Requested SeatID %s is Incorrect!\nTry Again!\n", seatID));
	}

	public void cancelSeat(int row, int column){
		if(checkBounds(row, column)){
			//Indices are '1' less than the SeatID which is given by user
			seats[row-1][column-1].cancelSeat();
		}
		else
			System.out.println("SORRY! The SeatID is Incorrect!\nTry Again!");
	}

	public void cancelSeat(SeatID seatID){	
		int row = seatID.getRow();
		int column = seatID.getColumn();

		if(checkBounds(row, column)){
			seats[row-1][column-1].cancelSeat(); 
		}
		else
			System.out.println("SORRY! The Requested SeatID is Incorrect!\nTry Again!\n");
	}

	public String displayLayout(){
		StringBuilder str = new StringBuilder();

		str.append("=== " + screenName + " |" + " Layout ===\n");
		for(int i =0; i < seats.length; i++){
			for(int j = 0;j < seats[i].length; j++){
				char c;
				if(seats[i][j].getIsAvailable())
					c = 'A';
				else
					c = 'B';
				
				str.append("[" + seats[i][j].getSeatId() + ":" + c + "] ");
			}
			str.append("\n");
		}
		str.append("Total: " + getTotalSeatCount() + ", Available: " + getAvailableSeatCount()+"\n");
		return str.toString();	
	}

	public Seat findFirstAvailable(SeatType seatType){
		Seat seat = new Seat();
		for(int i =0; i < seats.length; i++){
			for(int j = 0;j < seats[i].length; j++){
				if(seats[i][j].getIsAvailable()){
					if(seats[i][j].getSeatType() == seatType){
						seat = seats[i][j];
						break;	
					}
				}
			}
			if(!(seat == null))
				break;
		}

		return seat;
	}

	public Seat[] listAvailable(SeatType seatType){
		int available = 0;
		for(int i =0; i < seats.length; i++){
			for(int j = 0;j < seats[i].length; j++){
				if(seats[i][j].getIsAvailable()){
					if(seats[i][j].getSeatType() == seatType){
						available += 1;
					}
				}
			}
		}
		Seat[] seat = new Seat[available];
		int counter = 0;

		for(int i =0; i < seats.length; i++){
			for(int j = 0;j < seats[i].length; j++){
				if(seats[i][j].getIsAvailable()){
					if(seats[i][j].getSeatType() == seatType){
						seat[counter] = seats[i][j]; 
						counter++;
					}
				}
			}
		}
		return seat;
	}

	private boolean checkBounds(int i, int j){
		if(i < 1 || i > DEFAULT_NUM_ROWS)
			return false;
		else if(j < 1 || j > getRowLength(i-1)) //Since index is row-1
			return false;	
		else
			return true;
	}
	public int getTotalSeatCount(){
		int totalSeats = 0;
		for(int i = 0; i < seats.length; i++)
			totalSeats += seats[i].length;
		
		return totalSeats;
	}

	public int getAvailableSeatCount(){
		int availableSeats = 0;
		for(int i =0; i < seats.length; i++){
			for(int j = 0;j < seats[i].length; j++){
				if(seats[i][j].getIsAvailable() == true){
					availableSeats += 1;		
				}
			}
		}
		return availableSeats;
	}
	
	public int getAvailableSeatTypeCount(SeatType seatType){
		int seatCount = 0;

		for(int i =0; i < seats.length; i++){
			for(int j = 0;j < seats[i].length; j++){
				if(seats[i][j].getIsAvailable()){
					if(seatTypeFor(i, j) == seatType)
						seatCount += 1;
				}
			}
		}
		return seatCount;
	}

	public int getTotalSeatTypeCount(SeatType seatType){
		int seatCount = 0;

		for(int i =0; i < seats.length; i++){
			for(int j = 0;j < seats[i].length; j++){
				if(seatTypeFor(i, j) == seatType)
					seatCount += 1;	
			}
		}
		return seatCount;
	}

	//Setters and Getters
	public void setScreenName(String screenName){
		this.screenName = screenName;

	}

	public void setMovieName(String movieName){
		this.movieName = movieName;
	}
	public String getScreenName(){
		 return this.screenName;
	}

	public Seat getSeat(int i, int j){
		checkBounds(i,j);
		return seats[i][j];
	}

	
	public Seat getSeat(SeatID seatId){
		Seat seat = new Seat();
		for(int i = 0; i < seats.length; i++){
			for(int j =0; j < seats[i].length; j++){
				if(seats[i][j].getSeatId().equals(seatId)){
					seat = seats[i][j];
					break;
				}
			}
		}

		if(seat.getSeatId() == null){
			System.out.println("SORRY! Invalid Seat ID entered!\nTry Again!");
			return seat;
		}
		else
			return seat;
	}

	private SeatType seatTypeFor(int row, int column){
		return seats[row][column].getSeatType();
	}

	private double priceFor(SeatType seatType){
		return seatType.getPRICE();
	}

	public void setRowType(Seat[][] seats, int i){
		for(int j = 0; j < seats[i].length;j++){
			//Assign seats accordingly
			if(i <= (seats.length - 4))
				seats[i][j] = new Seat(i, j, SeatType.STANDARD, SeatType.STANDARD.getPRICE());
			else if(i == (seats.length - 3))
				seats[i][j] = new Seat(i, j, SeatType.PREMIUM, SeatType.PREMIUM.getPRICE());
			else if(i == (seats.length - 2))
				seats[i][j] = new Seat(i, j, SeatType.VIP, SeatType.VIP.getPRICE());
			else
				seats[i][j] = new Seat(i, j, SeatType.RECLINER, SeatType.RECLINER.getPRICE());
		}
	}

	public int getRowLength(int rowNo){	
		return seats[rowNo].length;
	}
	public double getTicketPrice(SeatID seatID){
		System.out.print(String.format("%s > TICKET PRICE ", seatID));

		//Indices are 1 less
		return seats[seatID.getRow()-1][seatID.getColumn()-1].getTicketPrice();

	}

	public int getBookedSeats(){
		return (getTotalSeatCount() - getAvailableSeatCount());
	}

}