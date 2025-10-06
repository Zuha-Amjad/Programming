public class CityCinema{
	String cityName;
	private Cinema[] cinemas;
	private int noOfCinemas;

	public CityCinema(String cityName, int noOfCinemas, int noOfScreens){
		setCityName(cityName);
		setNoOfCinemas(noOfCinemas);
	
		cinemas= new Cinema[noOfCinemas];

		//Take input through loop to enter cinema Names
		//while(i < noOfCinemas){}
		String name1 = "Centaurus Megaplex";
		

		//Initilize the cinemas
		for(int  i= 0; i< cinemas.length; i++){
			cinemas[i] = new Cinema("Cinema " + (i+1), noOfScreens);
		}
	}


	@Override 
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("\n         " + cityName);

		for(int i =0; i < cinemas.length; i++){
			str.append(cinemas[i].toString());
		}
		return str.toString();
	}



	public void bookSeat(int cinemaNo, int screenNo ,int row, int column){
		System.out.print("Cinema " + cinemaNo + " > ");
		if(checkBounds(cinemaNo)){
			//Index is 1 less than original No
			cinemas[cinemaNo-1].bookSeat(screenNo, row, column);
		}
		else
			System.out.println("FAILED: Cinema Info is Incorrect!\n");
	}

	public void cancelSeat(int cinemaNo, int screenNo ,int row, int column){
		System.out.print("Cinema " + cinemaNo + " > ");

		if(checkBounds(cinemaNo)){
			//Index is 1 less than original No
			this.cinemas[cinemaNo-1].cancelSeat(screenNo, row, column);
		}
		else
			System.out.println("FAILED: Cinema Info is Incorrect!\n");
	}

	public void bookSeat(int cinemaNo, int screenNo, SeatID seatId){
		System.out.print("Cinema " + cinemaNo + " > ");

		if(checkBounds(cinemaNo)){
			//Index is 1 less than original No
			cinemas[cinemaNo-1].bookSeat(screenNo, seatId);
		}
		else
			System.out.println("FAILED: Cinema Info is Incorrect!\n");
	}
	public void cancelSeat(int cinemaNo, int screenNo, SeatID seatId){
		System.out.print("Cinema " + cinemaNo + " > ");

		if(checkBounds(cinemaNo)){
			//Index is 1 less than original No
			cinemas[cinemaNo-1].cancelSeat(screenNo, seatId);
		}
		else
			System.out.println("FAILED: Cinema Info is Incorrect!\n");
	}

	private boolean checkBounds(int i){
		if(i < 1 || i > cinemas.length)
			return false;
		else
			return true;
	}

	public String displayLayout(){
		StringBuilder str = new StringBuilder();

		str.append("=== CITY: " + cityName + " |" + " Layouts ===\n");

		for(int i =0; i < cinemas.length; i++)
			str.append(cinemas[i].displayLayout());

		return str.toString();
	}
	public Seat findFirstAvailable(int cinemaNo,int screenNo, SeatType seatType){
		return cinemas[cinemaNo].findFirstAvailable(screenNo,seatType);
	}
	public Seat[] listAvailable(int cinemaNo, int screenNo, SeatType seatType){
		return 	cinemas[cinemaNo].listAvailable(screenNo, seatType);	
	}

	public void addScreen(int cinemaNo, String screenName, String movieName, int rowLength){
		cinemas[cinemaNo].addScreen(screenName, movieName, rowLength);
	}

	public void addCinema(String cinemaName, int noOfScreens){
		Cinema[] newCinemas = new Cinema[cinemas.length+1];
		int i =0;
		for(i =0; i< cinemas.length; i++)
			newCinemas[i] = cinemas[i];

		//i has the last index
		newCinemas[i] = new Cinema(cinemaName, noOfScreens);

		//Reinitialize the original array
		Cinema[] cinemas = new Cinema[newCinemas.length];

		this.cinemas = newCinemas;

		System.out.println(String.format("%s > %s Added Successfully!\n", this.cityName, cinemaName));
	}

	public void removeCinema(String cinemaName){

		Cinema[] newCinemas = new Cinema[cinemas.length-1];

		boolean flag = false;
		for(int i =0; i< cinemas.length; i++){
			if(cinemas[i].getCinemaName().equals(cinemaName)){
				flag = true;
				break;
			}
		}

		int counter = 0;
		if(flag){
			for(int i =0; i <cinemas.length; i++){
				if(cinemas[i].getCinemaName().equals(cinemaName))
					continue;
				newCinemas[counter] = cinemas[i];
				counter++;
			}

		//Reinitialize the original array
		Cinema[] cinemas = new Cinema[newCinemas.length];

		this.cinemas = newCinemas;

		System.out.println(String.format("%s > %s Removed Successfully!\n", this.cityName, cinemaName));
		}

		else
			System.out.println("FAILED Cinema Removal: INCORRECT Name entered!\n");
	}

	//Setters and Getters
	public void setCityName(String cityName){
		this.cityName = cityName;
	}	

	public void setNoOfCinemas(int noOfCinemas){
		this.noOfCinemas = noOfCinemas;
	}

	public Cinema getCinema(int index){
		return this.cinemas[index];
	}

	public int getTotalSeatCount(){
		int totalSeats = 0;

		for(int i = 0; i < cinemas.length; i++){
			 totalSeats += cinemas[i].getTotalSeatCount();
		}

		return totalSeats;
	}

	public int getAvailableSeatCount(){
		int availableSeats = 0;

		for(int i = 0; i < cinemas.length; i++){
			 availableSeats += cinemas[i].getAvailableSeatCount();
		}

		return availableSeats;
	}

	public double getTicketPrice(String cinemaName, String screenName, SeatID seatID){

		double p = 0;
		System.out.print(String.format("%s > ", cinemaName));

		for(int i = 0; i < cinemas.length; i++){
			if(cinemaName.equals(cinemas[i].getCinemaName()))
				p = cinemas[i].getTicketPrice(screenName, seatID);

		}

		return p;
	}

	
	public String displayCompact(){	
		return String.format("Name: %-15sCinema Count: %-10dTotal Seats: %-10dAvailable Seats: %d", cityName, noOfCinemas, this.getTotalSeatCount(), this.getAvailableSeatCount());
	}

}