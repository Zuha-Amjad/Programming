package sp25_bcs_145;

public class CinemaDemo{

	static{
		System.out.println("Welcome to the CinePlex!\n");
	}

	public static void main(String [] args){
	
		CityCinema cityCinema1 = new CityCinema("ISLAMABAD", 2, 3);
		System.out.println(cityCinema1.toString());

		CityCinema cityCinema2 = new CityCinema("LAHORE", 3, 5);
		System.out.println(cityCinema2.toString());
		
		CityCinema cityCinema3 = new CityCinema("KARACHI", 2, 1);
		System.out.println(cityCinema3.toString());

		//ARGUMENTS:Cinema No, Screen No, Seat No(row,column)
		cityCinema1.bookSeat(1,2, 4, 0);
		cityCinema1.bookSeat(1,3, 3, 2);
		cityCinema1.bookSeat(1,1, 1, 1);
	
		SeatID s = new SeatID(4, 1, SeatType.VIP);
		cityCinema1.bookSeat(1, 1, s);

		cityCinema1.cancelSeat(1,3,3,2);

		System.out.println("Row Length: " + cityCinema1.getCinema(0).getScreen(0).getRowLength(0));


		//Variable to take INPUT
		SeatType seatType = SeatType.STANDARD;

		Seat seat= cityCinema1.findFirstAvailable(0,0,seatType); //ARGUMENTS: Cinema No, Screen No, Seat Type

		if(seat == null)
			System.out.println("SORRY! Fully Booked!");
		else
		System.out.println(String.format("Cinema %d > Screen-%d > Seat %s (%s, %.2f PKR)\n", 1, 1, seat.getSeatId(), seatType, seatType.getPRICE()));


		Seat[] seats = cityCinema1.listAvailable(0, 0, SeatType.VIP); 
		System.out.println("Available VIP Seats \n" + Seat.arrayToString(seats));

  
		cityCinema1.addScreen(0, "Hall 9", "Godfather", 6); 

		cityCinema1.addCinema("Multiplex Centaurus", 3);

		cityCinema1.removeCinema("Cinema 2");

		System.out.println(cityCinema1.displayLayout());
		
		System.out.println(cityCinema2.displayLayout());

		SeatID si = new SeatID(4, 1, SeatType.VIP);
		System.out.println(cityCinema1.getTicketPrice("Cinema 1", "Screen 2", si)+ " PKR");

		System.out.println(cityCinema1.displayCompact());


	}


}