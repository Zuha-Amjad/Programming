package sp25_bcs;

public class Address{
	private String blockName;
	private String housingSoceityName;
	private String cityName;

	public Address(String blockName, String housingSoceityName, String cityName){
		setBlockName(blockName);
		setHousingSoceityName(housingSoceityName);
		setCityName(cityName);
	}
	

	@Override
	public String toString(){
		return String.format("%s, %s, %-10s", blockName, housingSoceityName, cityName);
	}

	public void setBlockName(String blockName){
		this.blockName = blockName;
	}

	public String getBlockName(){
		return blockName;
	}
	public void setHousingSoceityName(String housingSoceityName){
		this.housingSoceityName = housingSoceityName;
	}

	public void setCityName(String cityName){
		this.cityName = cityName;
	}
	public String getHousingSoceityName(){
		return housingSoceityName;
	}

	public String getCityName(){
		return cityName;
	}
}



class ResidentialAddress extends Address{
	private int houseNo;
	private int streetNo;

	public ResidentialAddress(String cityName, String housingSoceityName, String blockName, int streetNo, int houseNo){
		super(blockName, housingSoceityName, cityName);
		setPlotNo(houseNo);
		setStreetNo(streetNo);
	}

	@Override
	public String toString(){
		return String.format("H# %-3d, St.%d, %s", houseNo, streetNo, super.toString());
	}

	//Setters & Getters
	public void setPlotNo(int houseNo){
		this.houseNo = houseNo;
	}

	public void setStreetNo(int streetNo){
		this.streetNo = streetNo;
	}

	public int getPlotNo(){
		return houseNo;
	}

	public int getStreetNo(){
		return streetNo;
	}
}


class ParkAddress extends Address{
	private String parkName;
	
	public ParkAddress(String blockName, String housingSoceityName, String cityName, String parkName){
		super(blockName, housingSoceityName, cityName);
		setParkName(parkName);
	}

	@Override
	public String toString(){
		return String.format("%s, %s", parkName, super.toString());
	}

	//Setters & Getters
	public void setParkName(String parkName){
		this.parkName = parkName;
	}

	public String getParkName(){
		return parkName;
	}

}