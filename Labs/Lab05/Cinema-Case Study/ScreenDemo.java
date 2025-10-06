public class ScreenDemo{

	public static void main(String[] args){
		/*Screen screen1 = new Screen("IMAX", "Top-Gun Maverick");
		//System.out.println(screen1);
		
		//Locate Seat by Coordinates
		System.out.println(screen1.getSeat(1,5));

		//Locate Seat by ID
		SeatID s = new SeatID(5,3,SeatType.RECLINER);
		System.out.println(screen1.getSeat(s) + "\n");

		
		screen1.bookSeat(1,1); //By Coordinates
		screen1.bookSeat(4,2);
		screen1.bookSeat(s);   //By ID
		screen1.bookSeat(5,1);
		screen1.bookSeat(4,1);
		screen1.bookSeat(1,3);

		screen1.cancelSeat(1,3);

		//System.out.println(screen1);

		//Seat Details
		System.out.println("Total Seats: " + screen1.getTotalSeatCount());
		System.out.println("Available Seats: " + screen1.getAvailableSeatCount());

		System.out.println("\nAvailable VIP Seats:" + screen1.getAvailableSeatTypeCount(SeatType.VIP));	
		System.out.println("Total VIP Seats: " + screen1.getTotalSeatTypeCount(SeatType.VIP));
		System.out.println("\nList of Available VIP Seats: " + Seat.arrayToString(screen1.listAvailable(SeatType.VIP)));
		System.out.println("\nFirst Available STANDARD Seat: " + screen1.findFirstAvailable(SeatType.STANDARD));


		screen1.displayLayout();
		System.out.println(screen1.toString());	
		*/

		Cinema c1 = new Cinema("Atrium Saddar", 2);
		System.out.println(c1);

		c1.addScreen("IMAX", "Oppenheimer", 5);


		SeatID s = new SeatID(5,3,SeatType.RECLINER);
		c1.bookSeat(0, s);
		System.out.println(c1.displayLayout());

		c1.removeScreen("Screen 2");

		System.out.println(c1.displayLayout());

	}

}