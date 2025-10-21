package sp25_bcs;

public class Init{
	private static CityHousing[] cityHousing;

	static{
		cityHousing = new CityHousing[2];

		cityHousing[0] = new CityHousing("Lahore", 2); 
		cityHousing[1] = new CityHousing("Karachi", 2); 
	}

	public static String getData(){
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < cityHousing.length; i++)
			sb.append(cityHousing[i].toString() + "\n");
		
		return sb.toString();
	}

	public static CityHousing[] getCityHousingList(){
		return cityHousing;
	}

	public static CityHousing findCityByName(String cityName){
		int index = -1;
		for(int i = 0; i < cityHousing.length; i++)
			if(cityName.equals(cityHousing[i].getCityName())){
				index = i;
				break;
			}

		if(index != -1)
			return cityHousing[index];
		else
			return null;
	}

	public static String bookPlot(String cityName, String housingSocietyName, String blockName, String plotId, String ownerName){
		CityHousing c = findCityByName(cityName);
		
		if(c != null)
			return String.format("%s", c.bookPlot(housingSocietyName, blockName, plotId, ownerName));
		else
			return String.format("FAILED! %s > City Name %s is incorrect.", cityName);

	}
	public static String bookPlot(String cityName, String housingSocietyName, String blockName, int streetNo, int plotNo, String ownerName){
		int index = findCityIndexByName(cityName);

		if(checkBounds(index)){
			//Plot indices
			return String.format("%s", cityHousing[index].bookPlot(housingSocietyName, blockName, streetNo, plotNo, ownerName));
		}
		else
			return String.format("FAILED! %s > City Name %s is incorrect.", cityName);
	}

	public static String cancelPlot(String cityName, String housingSocietyName, String blockName, String plotId){
		CityHousing c = findCityByName(cityName);
		
		if(c != null)
			return String.format("%s", c.cancelPlot(housingSocietyName, blockName, plotId));
		else
			return String.format("FAILED! %s > City Name %s is incorrect.", cityName);

	}
	public static String cancelPlot(String cityName, String housingSocietyName, String blockName, int streetNo, int plotNo){
		int index = findCityIndexByName(cityName);

		if(checkBounds(index)){
			//Plot indices
			return String.format("%s", cityHousing[index].cancelPlot(housingSocietyName, blockName, streetNo, plotNo));
		}
		else
			return String.format("FAILED! %s > City Name %s is incorrect.", cityName);
	}


	public static int findCityIndexByName(String cityName){
		int index = -1;

		for(int i = 0; i < cityHousing.length; i++){
			if(cityName.equals(cityHousing[i].getCityName())){
					index = i;
					break;
			}
		}
		return index;
	}

	public static boolean checkBounds(int i){
		if(i >= 0 && i < cityHousing.length)
			return true;
		else
			return false;
	}

	public static Plot[] listBooked(){
		Plot[] bookedPlots;
		int bookedCount = 0;
		
		for(int i = 0; i < cityHousing.length; i++)
			bookedCount += (cityHousing[i].listBooked()).length;
		
		bookedPlots = new Plot[bookedCount];
		Plot temp[] = new Plot[cityHousing.length];
		int counter = 0;
		
		for(int i = 0; i < cityHousing.length; i++){
			//Array is stored at each index
			temp = cityHousing[i].listBooked();
			for(int j = 0; j < temp.length; j++){	
				//Plot is stored at each index
				bookedPlots[counter++] = temp[j];
			}
		}

		return bookedPlots;

	}

	public static Plot[] listAvailable(){
		Plot[] availablePlots;
		int availableCount = 0;
		
		for(int i = 0; i < cityHousing.length; i++)
			availableCount += (cityHousing[i].listAvailable()).length;
		
		availablePlots = new Plot[availableCount];
		Plot temp[] = new Plot[cityHousing.length];
		int counter = 0;
		
		for(int i = 0; i < cityHousing.length; i++){
			//Array is stored at each index
			temp = cityHousing[i].listAvailable();
			for(int j = 0; j < temp.length; j++){	
				//Plot is stored at each index
				availablePlots[counter++] = temp[j];
			}
		}

		return availablePlots;

	}

	public static CornerPlot[] listCornerPlots(){
		CornerPlot[] cornerPlots;
		int cornerCount = 0;
		
		for(int i =0; i < cityHousing.length; i++)
			cornerCount += (cityHousing[i].listCornerPlots()).length;

		cornerPlots = new CornerPlot[cornerCount];
		int counter = 0;
		CornerPlot temp[] = new CornerPlot[cityHousing.length];

		for(int i =0; i < cityHousing.length; i++){
			//Array is stored at each index
			temp = cityHousing[i].listCornerPlots();

			for(int j = 0; j < temp.length;j++)
				cornerPlots[counter++] = temp[j];
		}

		return cornerPlots;
	}

	public static double getAnnualRevenue(int year){
		double price = 0;
		for(int i = 0; i < cityHousing.length; i++)
			price += cityHousing[i].getAnnualRevenue(year);

		return price;
	}

	public static double calTotalRevenue(){
		double price = 0;
		for(int i = 0; i < cityHousing.length; i++)
			price += cityHousing[i].calTotalRevenue();

		return price;
	}

	public static CityHousing[] getArray(){
		return cityHousing;
	}


	public static Block findBlockByName(String cityName, String housingSocietyName, String blockName){
		Block b = new Block();

		CityHousing c = findCityHousingByName(cityName);
		HousingSociety h = findHousingSocietyByName(cityName, housingSocietyName);
		Block blocks[] = h.getBlocks();

		for(int i = 0; i < blocks.length; i++){
			if(blockName.equals(blocks[i].getBlockName())){
				b = blocks[i];
				break;
			
			}
		}
		return b;
	}

	public static HousingSociety findHousingSocietyByName(String cityName, String housingSocietyName){
		HousingSociety h = new HousingSociety();

		CityHousing c = findCityHousingByName(cityName);
		HousingSociety societies[] = c.getHousingSocieties();

		for(int i = 0; i < societies.length; i++){
			if(housingSocietyName.equals(societies[i].getHousingSocietyName())){
				h = societies[i];
				break;
			}
		}

		return h;
	}

	public static CityHousing findCityHousingByName(String cityName){
		CityHousing c = new CityHousing();

		for(int i = 0; i < cityHousing.length; i++){
			if(cityName.equals(cityHousing[i].getCityName())){
				c = cityHousing[i];
				break;
			}
		}

		return c;
	}

	public static String displayArray(Plot[] plots){
		return null;

	}

	public static String generalReport(){
		StringBuilder sb= new StringBuilder();

		sb.append(String.format("\n---- GENERAL REPORT ----\n- Number of City Housing Societies: %d\n", cityHousing.length));

		for(int i = 0; i < cityHousing.length; i++){
			sb.append(String.format("\nCITY %d\n%s", (i+1), cityHousing[i].getReport()));
		}	
	
		return sb.toString();
	}

	
	public static Plot[] unionOfArrays(){
		return cityHousing[0].unionOfArrays();
	}

	public static Plot[] intersectionOfArrays(){
		return cityHousing[0].intersectionOfArrays();
	}

}