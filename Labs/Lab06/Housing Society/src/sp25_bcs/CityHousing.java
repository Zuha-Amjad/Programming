package sp25_bcs;


public class CityHousing{
	private HousingSociety housingSocieties[];
	private int noOfHousingSocieties;
	private String cityName;

	public CityHousing(String cityName, int noOfHousingSocieties){
		this.cityName = cityName;
		this.noOfHousingSocieties = noOfHousingSocieties;

		housingSocieties = new HousingSociety[noOfHousingSocieties];

		for(int i = 0; i < housingSocieties.length; i++)
			housingSocieties[i] = new HousingSociety("LDA AVENUE " + (i+1), 3, cityName);
	}
	public CityHousing(){
	}
	@Override 
	public String toString(){
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("%30s\n" ,cityName));
		for(int i = 0; i < housingSocieties.length; i++)
			sb.append(housingSocieties[i].toString() + "\n");

		return sb.toString();
	
	}

	public String displayCompact(){
		StringBuilder sb= new StringBuilder();

		sb.append(String.format("%s | Layouts\n" , cityName));
		for(int i = 0; i < housingSocieties.length; i++)
			sb.append(String.format("%s", housingSocieties[i].displayCompact() + "\n"));

		return sb.toString();
	}


	public String bookPlot(String housingSocietyName, String blockName, String plotId, String ownerName){
		HousingSociety housingSociety = findHousingSocietyByName(housingSocietyName);

		if(housingSociety != null)
			return String.format("%s > %s", cityName, housingSociety.bookPlot(blockName, plotId, ownerName));
					
		else	
			return String.format("FAILED! %s > Housing Society Name %s is incorrect.", cityName, housingSocietyName);
	}

	public String bookPlot(String housingSocietyName, String blockName, int streetNo, int plotNo, String ownerName){
		int index = findHousingSocietyIndexByName(housingSocietyName);

		if(checkBounds(index)){
			//Plot indices
			return String.format("%s > %s", cityName, housingSocieties[index].bookPlot(blockName, streetNo, plotNo, ownerName));
		}
		else
			return String.format("FAILED! %s > Housing Society Name %s is incorrect.", cityName, housingSocietyName);
	}

	public String cancelPlot(String housingSocietyName, String blockName, String plotId){
		HousingSociety housingSociety = findHousingSocietyByName(housingSocietyName);

		if(housingSociety != null)
			return String.format("%s > %s", cityName, housingSociety.cancelPlot(blockName, plotId));
					
		else	
			return String.format("FAILED! %s > Housing Society Name %s is incorrect.", cityName, housingSocietyName);
	}

	public String cancelPlot(String housingSocietyName, String blockName, int streetNo, int plotNo){
		int index = findHousingSocietyIndexByName(housingSocietyName);

		if(checkBounds(index)){
			//Plot indices
			return String.format("%s > %s", cityName, housingSocieties[index].cancelPlot(blockName, streetNo, plotNo));
		}
		else
			return String.format("FAILED! %s > Housing Society Name %s is incorrect.", cityName, housingSocietyName);
	}

	public HousingSociety findHousingSocietyByName(String housingSocietyName){
		HousingSociety housingSociety = new HousingSociety();

		for(int i = 0; i < housingSocieties.length; i++){
			if(housingSocietyName.equals(housingSocieties[i].getHousingSocietyName())){
				housingSociety = housingSocieties[i];
				break;
			}
		}
		return housingSociety;
	}
	public int findHousingSocietyIndexByName(String housingSocietyName){
		int index = -1;

		for(int i = 0; i < housingSocieties.length; i++){
			if(housingSocietyName.equals(housingSocieties[i].getHousingSocietyName())){
					index = i;
					break;
			}
		}
		return index;
	}

	public boolean checkBounds(int i){
		if(i >= 0 && i < housingSocieties.length)
			return true;
		else
			return false;
	}

	public double getTotalPlotPrice(){
		double totalPrice = 0;
		for(int i = 0; i < housingSocieties.length; i++)
			totalPrice += housingSocieties[i].getTotalPlotPrice();

		return totalPrice;
	}

	public double getAnnualRevenue(int year){
		double price = 0;
		for(int i = 0; i < housingSocieties.length; i++)
			price += housingSocieties[i].getAnnualRevenue(year);

		return price;
	}

	public double calTotalRevenue(){
		double price = 0;
		for(int i = 0; i < housingSocieties.length; i++)
			price += housingSocieties[i].calTotalRevenue();

		return price;
	}

	public String getCityName(){
		return cityName;
	}

	public Plot[] listBooked(){
		Plot[] bookedPlots;
		int bookedCount = 0;
		
		for(int i = 0; i < housingSocieties.length; i++)
			bookedCount += (housingSocieties[i].listBooked()).length;
		
		bookedPlots = new Plot[bookedCount];
		Plot temp[] = new Plot[housingSocieties.length];
		int counter = 0;
		
		for(int i = 0; i < housingSocieties.length; i++){
			//Array is stored at each index
			temp = housingSocieties[i].listBooked();
			for(int j = 0; j < temp.length; j++){	
				//Plot is stored at each index
				bookedPlots[counter++] = temp[j];
			}
		}

		return bookedPlots;
	}

	public Plot[] listAvailable(){
		Plot[] availablePlots;
		int availableCount = 0;
		
		for(int i = 0; i < housingSocieties.length; i++)
			availableCount += (housingSocieties[i].listAvailable()).length;
		
		availablePlots = new Plot[availableCount];
		Plot temp[] = new Plot[housingSocieties.length];
		int counter = 0;
		
		for(int i = 0; i < housingSocieties.length; i++){
			//Array is stored at each index
			temp = housingSocieties[i].listAvailable();
			for(int j = 0; j < temp.length; j++){	
				//Plot is stored at each index
				availablePlots[counter++] = temp[j];
			}
		}

		return availablePlots;
	}

	public CornerPlot[] listCornerPlots(){
		CornerPlot[] cornerPlots;
		int cornerCount = 0;
		
		for(int i =0; i < housingSocieties.length; i++)
			cornerCount += (housingSocieties[i].listCornerPlots()).length;

		cornerPlots = new CornerPlot[cornerCount];
		int counter = 0;
		CornerPlot temp[] = new CornerPlot[housingSocieties.length];

		for(int i =0; i < housingSocieties.length; i++){
			//Array is stored at each index
			temp = housingSocieties[i].listCornerPlots();

			for(int j = 0; j < temp.length;j++)
				cornerPlots[counter++] = temp[j];
		}

		return cornerPlots;
	}

	public int getTotalPlotCount(){
		int count = 0; 
		for(int i = 0; i < housingSocieties.length; i++)
			count+= housingSocieties[i].getTotalPlotCount();
		
		return count;
	}

	public int getTotalParksCount(){
		int count = 0; 
		for(int i = 0; i < housingSocieties.length; i++)
			count+= housingSocieties[i].getTotalParksCount();
		
		return count;
	}

	public int getTotalCommercialMarketsCount(){
		int count = 0; 
		for(int i = 0; i < housingSocieties.length; i++)
			count+= housingSocieties[i].getTotalCommercialMarketsCount();
		
		return count;
	}

	public HousingSociety[] getHousingSocieties(){
		return housingSocieties;
	}

	public String getReport(){
		StringBuilder sb= new StringBuilder();

		sb.append(String.format("\n---- REPORT of %s -----\n- Number of Housing Societies: %d \n- Total Plots: %s\n- Amenities \n    ~ Total Parks Count: %s \n    ~ Total Commercial Market Count: %s\n", cityName, noOfHousingSocieties, getTotalPlotCount(),getTotalParksCount(),getTotalCommercialMarketsCount()));

		for(int i = 0; i < housingSocieties.length; i++){
			sb.append(String.format("\n%s", housingSocieties[i].getReport()));
		}	

		sb.append("********************************************");
	
		return sb.toString();
	}


	public Plot[] unionOfArrays(){
		return this.findHousingSocietyByName("LDA AVENUE 1").unionOfArrays();
	}

	public Plot[] intersectionOfArrays(){
		return this.findHousingSocietyByName("LDA AVENUE 1").intersectionOfArrays();
	}
}