package sp25_bcs;


public class CornerPlot extends Plot{
	private double width;
	private double depth;
	private final double CORNER_PREMIUM_RATE = 0.08;

	public CornerPlot(int streetNo, int houseNo, Shape shape, PlotType plotType, String blockName, String housingSoceityName, String cityName, double width, double depth){
		super(streetNo, houseNo, shape, plotType, blockName, housingSoceityName, cityName);
		this.width = width;
		this.depth = depth;

		//Add corner premium
		this.setPrice(getPrice());
	}

	public CornerPlot(int streetNo, int houseNo, Shape shape, PlotType plotType,String blockName, String housingSoceityName, String cityName){
		super(streetNo, houseNo, shape, plotType,  blockName, housingSoceityName, cityName);
		//Add corner premium
		this.setPrice(getPrice());
	}

	public CornerPlot(int streetNo, int houseNo, String blockName,  String housingSoceityName, String cityName){
		super(streetNo, houseNo, blockName, housingSoceityName, cityName);
	}

	//Copy Constructor
	public CornerPlot(Plot p){
		super(p.getStreetNo(), p.getPlotNo(), p.getAddress().getBlockName(), p.getAddress().getHousingSoceityName(), p.getAddress().getCityName());
		setAvailability(false);  //Owned Plot
	}

	public CornerPlot(){}

	@Override 
	public double calArea(){
		return (super.calArea() + (width * depth));
	}	

	public double getPrice(){
		double basePrice = this.getPlotType().getPrice();
		return (CORNER_PREMIUM_RATE * basePrice)+ basePrice;
	}

	public double getWidth(){
		return width;
	}
}