public class Cinema{

	private String cinemaName;
	private int noOfScreens;
	private Screen[] screens;
	
	public Cinema(String name, int noOfScreens){
		setCinemaName(name);
		setNoOfScreens(noOfScreens);

		screens = new Screen[noOfScreens];

		//Iniliatize the Screen objects
		for(int i =0; i < screens.length; i++){
			screens[i] = new Screen("Screen " + (i+1), "Top-Gun Maverick");
		}
	}

	public Cinema(){		
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		
		str.append("\n+++++++++++++++++++++++++++++++++++++\n         " + cinemaName + "\n+++++++++++++++++++++++++++++++++++++\n");

		for(int i =0; i < screens.length; i++){
			str.append(screens[i].toString() + "\n");
		}
		return str.toString();
	}


	public void bookSeat(int screenNo, int row, int column){
		System.out.print("Screen " + screenNo + " > ");

		if(checkBounds(screenNo)){
			//Index is 1 less than original No
			screens[screenNo-1].bookSeat(row, column);
		}
		else
			System.out.println("FAILED: Screen Info is Incorrect!\n");
	}

	public void cancelSeat(int screenNo, int row, int column){
		System.out.print("Screen " + screenNo + " > ");

		if(checkBounds(screenNo)){
			//Index is 1 less than original No
			screens[screenNo-1].cancelSeat(row, column);
		}
		else
			System.out.println("FAILED: Screen Info is Incorrect!\n");
	}

	public void bookSeat(int screenNo, SeatID seatId){
		System.out.print("Screen " + screenNo + " > ");

		if(checkBounds(screenNo)){
			//Index is 1 less than original No
			screens[screenNo-1].bookSeat(seatId);
		}
		else
			System.out.println("FAILED: Screen Info is Incorrect!\n");

		
	}
	public void cancelSeat(int screenNo, SeatID seatId){
		System.out.print("Screen " + screenNo + " > ");

		if(checkBounds(screenNo)){
			//Index is 1 less than original No
			screens[screenNo].cancelSeat(seatId);
		}
		else
			System.out.println("FAILED: Screen Info is Incorrect!\n");		
	}

	public String displayLayout(){
		StringBuilder str = new StringBuilder();

		str.append("=== CINEMA: " + cinemaName + " |" + " Layouts ===\n");
		for(int i =0; i < screens.length; i++){
			str.append(screens[i].displayLayout());
		}
		return str.toString();
	}

	public Seat findFirstAvailable(int screenNo, SeatType seatType){
		return screens[screenNo].findFirstAvailable(seatType);
	}

	public Seat[] listAvailable(int screenNo, SeatType seatType){
		return 	screens[screenNo].listAvailable(seatType);	
	}

	public void addScreen(String screenName, String movieName, int rowLength){
		Screen newScreens[] = new Screen[(screens.length + 1)];

		int i = 0;
		for(i = 0; i < screens.length; i++){
			newScreens[i] = screens[i];
		}
		
		Screen s = new Screen(screenName, movieName, rowLength);

		//i has the last index
		newScreens[i] = s;

		//Reinitialize the original array with new Length
		Screen screens[] = new Screen[newScreens.length];

		//Store new in original
		this.screens = newScreens;

		System.out.println("Screen Added Successfully!\n");		
	}

	public void removeScreen(String screenName){

		//Temporray array to store screens
		Screen newScreens[] = new Screen[(screens.length-1)];
		
		boolean flag = false;
		int screenNo = 0;

		for(int i =0; i < screens.length; i++){
			//Check for screen Name
			if(screenName.equals(screens[i].getScreenName())){
				flag = true;
				screenNo = i; //Store index no.
				break;
			}
		}


		//Screen Name is correct
		int counter = 0;
		if(flag){
			for(int i = 0; i < screens.length; i++){	
				//Skip the index
				if(i == screenNo){
					continue;
				}
				newScreens[counter++] = this.screens[i];
			}

			//Reinitilize the original array with new length
			Screen screens[] = new Screen[newScreens.length];
		
			//Store new in original
			this.screens = newScreens;

			System.out.println(String.format("%s > %s Removed Successfully!\n",this.cinemaName, screenName));
		}
		else
			System.out.println("FAILED: Screen Info is incorrect.");

	}

	//Setters & Getters
	public void setCinemaName(String name){
		this.cinemaName = name;

	}
	public void setNoOfScreens(int noOfScreens){
		if(noOfScreens < 0){
			System.out.println("INVALID number of Screens!");
		}
		else
			this.noOfScreens = noOfScreens;
	}
	public String getCinemaName(){
		 return this.cinemaName;
	}

	public Screen getScreen(int index){
		return screens[index];
	}

	public Screen getScreen(String screenName){
		int index = -1;
		for(int i = 0; i< screens.length; i ++){
			if(screens[i].getScreenName() == screenName)
				index = i;
		}
		if(index == -1){
			System.out.println("The Screen Name is Incorrect!");
			return screens[0];
		}
		else
			return screens[index];
	}
	private boolean checkBounds(int i){
		if(i < 1 || i > screens.length)
			return false;
		else
			return true;
	}

	public double getTicketPrice(String screenName, SeatID seatID){
		double p = 0;
		System.out.print(String.format("%s > ", screenName));

		for(int i = 0 ; i < screens.length; i++){
			if(screenName.equals(screens[i].getScreenName()))
				p = screens[i].getTicketPrice(seatID);
		}

		return p;
	}

	public int getTotalSeatCount(){
		int totalSeats = 0;

		for(int i = 0; i < screens.length; i++){
			 totalSeats += screens[i].getTotalSeatCount();
		}

		return totalSeats;
	}

	public int getAvailableSeatCount(){
		int availableSeats = 0;

		for(int i = 0; i < screens.length; i++){
			 availableSeats += screens[i].getAvailableSeatCount();
		}

		return availableSeats;
	}

	public String displayCompact(){	
		return String.format("Name: %-15sScreen Count: %-10dTotal Seats: %-10dAvailable Seats: %d", cinemaName, noOfScreens, this.getTotalSeatCount(), this.getAvailableSeatCount());
	}


}