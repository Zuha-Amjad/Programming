package sp25_bcs;

public class Block{
	private String blockName;
	private Plot plots[][];
	private Park parks[];
	private CommercialMarket commercialMarkets[];
	
		
	public Block(String blockName, String housingSocietyName, String cityName){
		this.blockName = blockName;

		plots = new Plot[5][];

		int counter = 10;

		for(int i = 0; i < plots.length; i++){
			plots[i] = new Plot[counter++];

			for(int j = 0; j < plots[i].length; j++){
				//Corner Plots exception
				if(j > 0 && j < (plots[i].length-1))
					plots[i][j] = new Plot((i+1), (j+1), blockName, housingSocietyName, cityName);
				
				else
					plots[i][j] = new CornerPlot((i+1), (j+1), blockName, housingSocietyName, cityName);
				setStreetType(plots[i][j], i);
			}

		}

		parks = new Park[2];

		for(int i = 0; i < parks.length; i++)
			parks[i] = new Park("Park " + (i+1), Shape.RECTANGLE, (i+1));
		

		commercialMarkets = new CommercialMarket[1];

		for(int i = 0; i < commercialMarkets.length; i++)
			commercialMarkets[i] = new CommercialMarket("Commercial Market " + (i+1));

	}

	public Block(){
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();

		String s = "=============================";

		sb.append(String.format("%53s\n %40s \n%53s \n", s, blockName, s));

		for(int i = 0; i < plots.length; i++){
			for(int j = 0; j < plots[i].length; j++){
				sb.append(String.format("\n%s", plots[i][j].toString()));
			}
			sb.append("\n");
		}
		sb.append("\n===== PARKS =====\n");

		for(int i = 0; i < parks.length; i++)
			sb.append(parks[i].toString() + "\n");

		sb.append("\n");

		for(int i = 0; i < commercialMarkets.length; i++)
			sb.append(commercialMarkets[i].toString() + "\n");


		return sb.toString();
	}

	public String displayCompact(){
		StringBuilder sb = new StringBuilder();

		sb.append("\n" + blockName + " | Layouts\n");

		for(int i = 0; i < plots.length; i++){
			for(int j = 0; j < plots[i].length; j++){
				sb.append(String.format("%-10s", plots[i][j].displayCompact()));
			}
			sb.append("\n");
		}
		sb.append(String.format("Total Plots: %-10d Total Parks: %d",getTotalPlotCount(), getParkCount()));

		return sb.toString();
	}

	public String bookPlot(String plotId, String ownerName){
		Plot plot = findPlotById(plotId);
		OwnedPlot o = null;

		if(plot.getPlotId() != null){
			o = plot.bookPlot(ownerName);
			if(o != null){
				replacePlotWithOwnedPlot(plotId, o);
				return String.format("%s > Plot %s is Booked SUCCESSFULLY.", blockName, plotId);
			}
			else{
				return String.format("FAILED! Plot %s is ALREADY Booked.", plotId);
			}
		}
					
		else	
			return String.format("FAILED! %s > Plot ID %s is incorrect.", blockName, plotId);
	}

	public String bookPlot(int streetNo, int plotNo, String ownerName){
		Plot p = null;
		if(checkBounds((streetNo-1), (plotNo-1))){
			//Plot indices
			p = plots[streetNo-1][plotNo-1].bookPlot(ownerName);
			if(p != null){
				plots[streetNo-1][plotNo-1] = p;
				return String.format("%s > Plot %d-%03d is Booked SUCCESSFULLY.", blockName, streetNo, plotNo);
			}
			else
				return String.format("FAILED! Plot %s-%03d is ALREADY Booked.", streetNo, plotNo);
		}

		else
			return String.format("FAILED! %s > Plot %s-%03d is incorrect.", blockName, streetNo , plotNo);
	}

	public String cancelPlot(String plotId){
		Plot plot = findPlotById(plotId);
		Plot p = null;

		if(plot.getPlotId() != null){
			p = plot.cancelPlot();	
			if(p != null){
				replaceOwnedPlotWithPlot(plotId, p);
				return String.format("Booking of Plot %s is CANCELLED Successfully.", plotId);
			}
			else
				return String.format("CANCELLATION FAILED! Plot %s is NOT Booked.", plotId);
		}
		else	
			return String.format("FAILED! %s > Plot ID %s is incorrect.", blockName, plotId);
	}

	public String cancelPlot(int streetNo, int plotNo){
		Plot plot = null;

		if(checkBounds((streetNo-1), (plotNo-1))){
			//Plot indices
			plot = plots[streetNo-1][plotNo-1].cancelPlot();
			if(plot != null){
				plots[streetNo-1][plotNo-1] = plot;
				return String.format("%s > Plot %d-%03d is CANCELLED Successfully.", blockName, streetNo, plotNo); 
			}else
				return String.format("CANCELLATION FAILED! Plot %s-%03d is NOT Booked.", streetNo, plotNo);
		}
		else
			return String.format("FAILED! %s > Plot %s-%s is incorrect.", blockName, streetNo , plotNo);	
	}

	public Plot findPlotById(String plotId){
		Plot plot = new Plot();
		boolean flag = false;

		for(int i = 0; i < plots.length; i++){
			if(!(flag)){
				for(int j = 0; j < plots[i].length; j++){
					if(!(flag)){
						if(plotId.equals(plots[i][j].getPlotId())){
								plot = plots[i][j];
								flag = true;
						} 
					}
				}
			}else{
				break;
			}
		}
		return plot;
	}

	public boolean checkBounds(int i, int j){
		if(i >= 0 && i < plots.length && j >= 0 && j < plots[i].length)
			return true;
			
		else
			return false;
	}

	public void replacePlotWithOwnedPlot(String plotId, OwnedPlot o){
		Plot plot = findPlotById(plotId);
		int i = (plot.getStreetNo() - 1);
		int j = (plot.getPlotNo()-1);

		plots[i][j] = o;
	}

	public void replaceOwnedPlotWithPlot(String plotId, Plot p){
		Plot plot = findPlotById(plotId);

		int i = (plot.getStreetNo() - 1);
		int j = (plot.getPlotNo()-1);

		plots[i][j] = p;
	}

	public void setStreetType(Plot plot, int i){
		int streetNo = i + 1;

		if(streetNo == 1){
			plot.setShape(Shape.RECTANGLE);
			plot.setPlotType(PlotType.RES_5_MARLA);
		}
		else if(streetNo == 2){
			plot.setShape(Shape.RECTANGLE);
			plot.setPlotType(PlotType.RES_10_MARLA);
		}
		else if(streetNo == 3){
			plot.setShape(Shape.TRAPEZOID);
			plot.setPlotType(PlotType.RES_1_KANAL);
		}
		else if(streetNo == 4){	
			if(plot.getPlotNo() == 5)
				plot.setPlotType(PlotType.PARKING);
		
			else
				plot.setPlotType(PlotType.COMM_SHOP);

			plot.setShape(Shape.RECTANGLE);
		}
		else{
			plot.setShape(Shape.RECTANGLE);
			plot.setPlotType(PlotType.COMM_OFFICE);
		}

		if(plot instanceof CornerPlot){
			CornerPlot c = (CornerPlot)plot;
			plot.setPrice(c.getPrice());
		} else{
			plot.setPrice(plot.getPlotType().getPrice());
		}	
	}

		
	public String getReport(){
		return String.format("REPORT of %s \n- Total Residential Plots: %d \n- Total Commercial Plots: %d \n- Amenities \n    ~ Total Parks: %d \n    ~ Total Commercial Complex: %d\n         ~ Total Shops: %d\n", blockName, getResidentialPlotCount(), getCommercialPlotCount(), getParkCount(), getCommercialMarketsCount(), getCommercialShopCount());
	}


	//Setters & getters

	public String getBlockName(){
		return blockName;
	}
	public int getStreetCount(){
		return plots.length;	
	}
	public int getParkCount(){
		return parks.length;	
	}

	//Commercial Market shops
	public int getCommercialShopCount(){
		int count = 0;

		for(int i = 0; i < commercialMarkets.length; i++)
			count += commercialMarkets[i].getShopCount();
		
		return count;	
	}


	public int getResidentialPlotCount(){
		int plotCount = 0;

		for(int  i= 0; i < plots.length; i++){
			for(int j = 0; j < plots[i].length; j++)
				if(plots[i][j].getPlotType() == PlotType.RES_5_MARLA || plots[i][j].getPlotType() == PlotType.RES_10_MARLA || plots[i][j].getPlotType() == PlotType.RES_1_KANAL)
					plotCount++;						
		}

		return plotCount;
	}


	//Part of Plot Grid
	public int getCommercialPlotCount(){
		int plotCount = 0;

		for(int  i= 0; i < plots.length; i++){
			for(int j = 0; j < plots[i].length; j++)
				if(plots[i][j].getPlotType() == PlotType.COMM_OFFICE || plots[i][j].getPlotType() == PlotType.COMM_SHOP || plots[i][j].getPlotType() == PlotType.PARKING)
					plotCount++;						
		}

		return plotCount;
	}

	public int getTotalPlotCount(){
		return (getResidentialPlotCount() + getCommercialPlotCount());
	}



	public int getCommercialMarketsCount(){
		return commercialMarkets.length;
	}


	public double getTotalPlotPrice(){
		double totalPrice = 0;
		for(int i = 0; i < plots.length; i++){
			for(int j = 0; j < plots[i].length; j++){
				 totalPrice += plots[i][j].getPrice();
			}
		}

		return totalPrice;
	}


	public double getAnnualRevenue(int year){
		double price = 0;

		if(year > 2015){
			for(int i = 0; i < plots.length; i++){
				for(int j = 0; j < plots[i].length; j++){
					if(plots[i][j] instanceof OwnedPlot){
						OwnedPlot o = (OwnedPlot)plots[i][j];
						if(o.getPurchaseDate().getYear() == year)
							price += plots[i][j].getPrice();
					}
				}
			}
		}
		return price;
	}
	public double calTotalRevenue(){
		double price = 0;
		for(int i = 0; i < plots.length; i++){
				for(int j = 0; j < plots[i].length; j++){
					if(plots[i][j] instanceof OwnedPlot){
						OwnedPlot o = (OwnedPlot)plots[i][j];
						price += plots[i][j].getPrice();
					}
				}
			}

		return price;
	}

	public Plot[] listBooked(){
		Plot[] bookedPlots;
		int bookedCount = 0;
		
		for(int i =0; i< plots.length; i++){
			for(int j = 0;j <plots[i].length;j++){
				if(!(plots[i][j].getAvailability()))
					bookedCount += 1;
			}
		}

		bookedPlots = new Plot[bookedCount];
		int counter = 0;

		for(int i =0; i< plots.length; i++){
			for(int j = 0;j <plots[i].length;j++){
				if(!(plots[i][j].getAvailability()))
					bookedPlots[counter++] = plots[i][j];
			}
		}
		
		return bookedPlots;
	}

	public Plot[] listAvailable(){
		Plot[] availablePlots;
		int availableCount = 0;
		
		for(int i =0; i< plots.length; i++){
			for(int j = 0;j <plots[i].length;j++){
				if(plots[i][j].getAvailability())
					availableCount += 1;
			}
		}

		availablePlots = new Plot[availableCount];
		int counter = 0;

		for(int i =0; i< plots.length; i++){
			for(int j = 0;j <plots[i].length;j++){
				if(plots[i][j].getAvailability())
					availablePlots[counter++] = plots[i][j];
			}
		}
		
		return availablePlots;
	}

	public CornerPlot[] listCornerPlots(){
		CornerPlot[] cornerPlots;
		int cornerCount = 0;
		
		for(int i =0; i < plots.length; i++){
			for(int j = 0;j < plots[i].length;j++)
				if(plots[i][j] instanceof CornerPlot){
					cornerCount += 1;
				}
				else if(plots[i][j] instanceof OwnedPlot){
					OwnedPlot ownedPlot = (OwnedPlot)plots[i][j];
					if(ownedPlot.isCorner())
						cornerCount += 1;
				} else{
					//pass
				}
		}

		cornerPlots = new CornerPlot[cornerCount];
		int counter = 0;

		for(int i =0; i< plots.length; i++){
			for(int j = 0; j < plots[i].length;j++){
				if(plots[i][j] instanceof CornerPlot){
					cornerPlots[counter++] = (CornerPlot)plots[i][j];
				}
				else if(plots[i][j] instanceof OwnedPlot){
					OwnedPlot ownedPlot = (OwnedPlot)plots[i][j];
					if(ownedPlot.isCorner()){
						//Copy owned into corner to store it safely
						CornerPlot corner = new CornerPlot(ownedPlot);
						cornerPlots[counter++] = corner;
					}
				} else{
					//pass
				} 
			}
		}
		
		return cornerPlots;

	}

}