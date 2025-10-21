package sp25_bcs;

public class Plot{
	private String plotId;
	private Shape shape;
	private PlotType plotType;
	private double price;
	private boolean isAvailable;
	private int plotNo;
	private int streetNo;
	private ResidentialAddress address;

	//For house
	public Plot(int streetNo, int plotNo, Shape shape, PlotType plotType, String blockName, String housingSocietyName, String cityName){
		this(streetNo, plotNo, blockName, housingSocietyName, cityName);
		setPlotType(plotType);
		this.shape = shape;
		setPrice();
	}


	//For shop
	public Plot(int plotNo, Shape shape, PlotType plotType){
		this.plotNo = plotNo;
		setPlotId(plotNo);
		
		setAvailability(true);
		setPlotType(plotType);
		this.shape = shape;
		setPrice();
	}


	public Plot(int streetNo, int plotNo, String blockName, String housingSocietyName, String cityName){
		setPlotId(streetNo, plotNo);
		this.address = new ResidentialAddress(cityName, housingSocietyName, blockName, streetNo, plotNo);
		this.streetNo = streetNo;
		this.plotNo = plotNo;
		setAvailability(true);
	}

	public Plot(){
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%-10s %-18s %,.2f sq.mtr.   PKR %,-18.2f %-10b", this.getPlotId(), plotType, calArea(), price, isAvailable));

		return sb.toString();
	}
	
	public double calArea(){
		return shape.calArea(this.shape);
	}

	public OwnedPlot bookPlot(String ownerName){
		OwnedPlot ownedPlot = null;

		if(this.isAvailable){
			if(this instanceof CornerPlot){
				ownedPlot = new OwnedPlot(this.streetNo, this.plotNo, this.shape, this.plotType, this.price, true, this.address, ownerName);

			} else{
				ownedPlot = new OwnedPlot(this.streetNo, this.plotNo, this.shape, this.plotType, false, this.address, ownerName);
			}
		}
		
		return ownedPlot;
	}

	public Plot cancelPlot(){
		Plot plot = null;

		if(!(this.isAvailable)){
			//Downcast
			OwnedPlot o = (OwnedPlot)this;
			if(o.isCorner())
				plot = new CornerPlot(this.streetNo, this.plotNo, this.shape, this.plotType, this.address.getBlockName(), this.address.getHousingSoceityName(), this.address.getCityName());	
			else
				plot = new Plot(this.streetNo, this.plotNo, this.shape, this.plotType, this.address.getBlockName(), this.address.getHousingSoceityName(), this.address.getCityName());	
			
		}
		return plot;
	}

	public String displayCompact(){
		char c = 'B';
		
		if(isAvailable){
			c = 'A';
		}
		return String.format("[%s:%c]", plotId, c);
	}


	//Setters & getters
	//For House
	public void setPlotId(int streetNo, int plotNo){
		plotId = String.format("%d-%03d",streetNo, plotNo);
	}
	
	//For Shop
	public void setPlotId(int shopNo){
		plotId = String.format("C-%03d", shopNo);
	}

	public String getPlotId(){
		return this.plotId;
	}

	public void setAvailability(boolean isAvailable){
		this.isAvailable = isAvailable;
	}
	public boolean getAvailability(){
		return isAvailable;
	}
	public void setPlotType(PlotType plotType){
		this.plotType = plotType;
	}

	public void setShape(Shape shape){
		this.shape = shape;
	}

	public Shape getShape(){
		return shape;
	}

	public PlotType getPlotType(){
		return plotType;
	}

	public void setPrice(){
		price = getPlotType().getPrice();
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public int getPlotNo(){
		return plotNo;
	}

	public int getStreetNo(){
		return streetNo;
	}

	public ResidentialAddress getAddress(){
		return address;
	}

}