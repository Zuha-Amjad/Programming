public class CornerPlot extends Plot{
	private double width;
	private double depth;
	private final double CORNER_PREMIUM_RATE = 0.08;

	public CornerPlot(int streetNo, int houseNo, Shape shape, PlotType plotType, double width, double depth){
		super(streetNo, houseNo, shape, plotType);
		this.width = width;
		this.depth = depth;

		//Add corner premium
		this.setPrice(getPrice());
	}

	@Override 
	public double calArea(){
		return (super.calArea() + (width * depth));
	}	

	public double getPrice(){
		double basePrice = this.getPlotType().getPrice();
		return (CORNER_PREMIUM_RATE * basePrice)+ basePrice;
	}

}