//ZUHA AMJAD
//SP25-BCS-145

public class CinemaDemo{

	static{
		System.out.println("Welcome to the CinePlex!\n");
	}

	public static void main(String [] args){
	
		CityCinema cityCinema1 = new CityCinema("ISLAMABAD", 2, 3);
		System.out.println(cityCinema1.toString());

		CityCinema cityCinema2 = new CityCinema("LAHORE", 3, 5);
		System.out.println(cityCinema2.toString());


		System.out.println("Select ANY:");
		//System.out.println("1. Book a Seat\n2. Cancel a Seat\n3. Display Screen Details\n");
		
		//cityCinema1.bookSeat(0,0, 3, 7);  //ARGUMENTS:Cinema No, Screen No, Seat No(row,column)
		//cityCinema1.bookSeat(0,0, 1, 5);
		cityCinema1.bookSeat(1,2, 4, 0);
		cityCinema1.bookSeat(1,3, 3, 2);
		cityCinema1.bookSeat(1,1, 1, 1);
		cityCinema1.bookSeat(1,1, 1, 5);

		SeatID s = new SeatID(4, 1, SeatType.VIP);
		cityCinema1.bookSeat(0, 1, s);

		cityCinema1.cancelSeat(0,0,2,4);

		//cityCinema1.getCinema(0).getScreen(0).displayDetails();
		System.out.println("Row Length: " + cityCinema1.getCinema(0).getScreen(0).getRowLength(0));
		System.out.println("TOTAL: "+cityCinema1.getCinema(0).getScreen(0).getTotalSeatCount());


		//Variable to take INPUT
		SeatType seatType = SeatType.STANDARD;

		//Call the Method
		Seat seat= cityCinema1.findFirstAvailable(0,0,seatType); //ARGUMENTS: Cinema No, Screen No, Seat Type

		if(seat == null)
			System.out.println("SORRY! Fully Booked!");
		else
		System.out.println(String.format("Cinema %d > Screen-%d > Seat %s (%s, %.2f PKR)\n", 1, 1, seat.getSeatId(), seatType, seatType.getPRICE()));




		//Seat[] s = cityCinema1.listAvailable(0, 0, SeatType.VIP); 
		//System.out.println("Available VIP Seats \n" + Seat.arrayToString(s));

		cityCinema1.addScreen(0, "Hall 9", "Saiyyara", 6); 

		cityCinema1.addCinema("Multiplex Centaurus", 3);

		cityCinema1.removeCinema("Cinema 2");

		System.out.println(cityCinema1.displayLayout()); 

		SeatID si = new SeatID(4, 1, SeatType.VIP);
		System.out.println(cityCinema1.getTicketPrice("Cinema 1", "Screen 2", si)+ " PKR");

		System.out.println(cityCinema1.displayCompact());
	}


}