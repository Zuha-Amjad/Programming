package sp25_bcs_145;

public class SeatDemo{

	public static void main(String args[]){

		Seat seat1 = new Seat(SeatType.VIP, 1, 3, SeatType.VIP.getPRICE());
		Seat seat2 = new Seat(SeatType.PREMIUM, 1, 4, SeatType.PREMIUM.getPRICE());

		System.out.println(seat1);
		System.out.println(seat2);

		seat1.bookSeat();
		seat1.bookSeat();  //Double Booking not allowed

		seat2.bookSeat();
		seat2.cancelSeat();
	
		System.out.println(seat1);
		System.out.println(seat2);

		seat1.setTicketPrice(1400);
		System.out.println(seat1);
	}
}