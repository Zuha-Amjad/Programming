package sp25_bcs;

public class Park{
	private String parkName;
	private String parkId;
	private Shape shape;
	private ParkAddress address;
	
	public Park(String parkName, Shape shape, int parkNo){
		this.parkName = parkName;
		setShape(shape);
		setParkId(parkNo);
		setAddress();
	}

	@Override
	public String toString(){
		return String.format("%-10s %-18s %5.2f sq. mtr. %32s", parkId, parkName, calArea(), address);
	}


	//Setters & getters
	public void setParkId(int parkNo){
		parkId = String.format("P-%03d", parkNo);
	}

	public void setShape(Shape shape){
		this.shape = shape;
	}

	public Shape getShape(){
		return shape;
	}

	public double calArea(){
		return shape.calArea(this.shape);
	}




	public void setAddress(){
		this.address = new ParkAddress("Block A", "LDA 1", "Lahore", parkName);
	}

}