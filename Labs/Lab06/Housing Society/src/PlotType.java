public enum PlotType{
	RES_5_MARLA(4000000), RES_10_MARLA(7500000), RES_1_KANAL(14000000), COMM_SHOP(3000000), COMM_OFFICE(5000000), PARKING(200000);

	private double price;

	PlotType(double price){
		this.price = price;
	} 

	public double getPrice(){
		return this.price;
	}

}