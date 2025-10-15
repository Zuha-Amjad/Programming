public class Plot{
	private String plotId;
	private Shape shape;
	private boolean isAvailable;
	private PlotType plotType;
	private double price;


	public Plot(int streetNo, int houseNo, Shape shape, PlotType plotType){
		setPlotId(streetNo, houseNo);
		this.shape = shape;
		setAvailability(true);
		setPlotType(plotType);
		setPrice(plotType.getPrice());
	}


	@Override
	public String toString(){
		return String.format("%-10s %-18s %,.2f sq.mtr.   PKR %,-18.2f %-10b", plotId, plotType, calArea(), price, isAvailable);
	}
	
	public double calArea(){
		return shape.calArea(this.shape);
	}

	public void bookPlot(){
		if(this.isAvailable)
			setAvailability(false);
			
	}

	public void cancelPlot(){
		if(!(this.isAvailable))
			setAvailability(true);
	}

	public String displayCompact(){
		return String.format("%-10s", plotId);
	}



	//Setters & getters
	public void setPlotId(int streetNo, int houseNo){
		plotId = String.format("%d-%03d",streetNo, houseNo);
	}

	public String getPlotId(){
		return this.plotId;
	}
	public void setAvailability(boolean isAvailable){
		this.isAvailable = isAvailable;
	}

	public void setPlotType(PlotType plotType){
		this.plotType = plotType;
	}

	public Shape getShape(){
		return this.shape;
	}

	public PlotType getPlotType(){
		return this.plotType;
	}

	public void setPrice(double price){
		this.price = price;
	}


}