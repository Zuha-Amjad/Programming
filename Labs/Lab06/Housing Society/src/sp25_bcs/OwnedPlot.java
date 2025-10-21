package sp25_bcs;

import java.time.LocalDate;

public class OwnedPlot extends Plot{
	private String ownerName;
	private LocalDate purchaseDate;
	private boolean isCorner;
	
	public OwnedPlot(int streetNo, int plotNo, Shape shape, PlotType plotType, boolean isCorner, ResidentialAddress address, String ownerName){
		super(streetNo, plotNo, shape, plotType, address.getBlockName(), address.getHousingSoceityName(), address.getCityName());
		setAvailability(false);
		setOwnerName(ownerName);
		setPurchaseDate();
		this.isCorner = isCorner;
	}

	public OwnedPlot(int streetNo, int plotNo, Shape shape, PlotType plotType, double price, boolean isCorner, ResidentialAddress address, String ownerName){
		super(streetNo, plotNo, shape, plotType, address.getBlockName(), address.getHousingSoceityName(), address.getCityName());
		setAvailability(false);
		setOwnerName(ownerName);
		setPurchaseDate();
		setPrice(price);
		this.isCorner = isCorner;
	}


	public OwnedPlot(){
	}

	@Override
	public String toString(){
		return String.format("%s %-15s %-15s", super.toString(), ownerName, purchaseDate);
	}


	public void setOwnerName(String ownerName){
		this.ownerName = ownerName;
	}

	public void setPurchaseDate(){
		this.purchaseDate = LocalDate.now();
	}

	public String getOwnerName(){
		return ownerName;
	}

	public LocalDate getPurchaseDate(){
		return purchaseDate;
	}

	public boolean isCorner(){
		return isCorner;
	}

}