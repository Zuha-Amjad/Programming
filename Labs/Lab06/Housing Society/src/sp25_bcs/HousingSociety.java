package sp25_bcs;


public class HousingSociety{
	private String housingSocietyName;
	private Block blocks[];
	private int noOfBlocks;

	public HousingSociety(String housingSocietyName, int noOfBlocks, String cityName){
		this.housingSocietyName = housingSocietyName;
		this.noOfBlocks = noOfBlocks;

		blocks = new Block[noOfBlocks];
	
		/*for(int i = 0; i < blocks.length; i++){
			blocks[i] = new Block("Block A", housingSocietyName, cityName);
		}*/

		blocks[0] = new Block("Block A", housingSocietyName, cityName);
		blocks[1] = new Block("Block B", housingSocietyName, cityName);
		blocks[2] = new Block("Block C", housingSocietyName, cityName);

	}
	public HousingSociety(){
	}
	@Override
	public String toString(){
		StringBuilder sb= new StringBuilder();

		String s = "---------------------------------------------------------------------------";

		sb.append(String.format("%s\n %40s \n%s \n" , s, housingSocietyName, s));
		for(int i = 0; i < blocks.length; i++)
			sb.append(String.format("%s", blocks[i].toString() + "\n"));

		return sb.toString();
	}

	public String displayCompact(){
		StringBuilder sb= new StringBuilder();

		String s = "--------------------------------------------------------------------------------------------------";

		sb.append(String.format("%s | Layout\n%40s" , housingSocietyName, s));
		for(int i = 0; i < blocks.length; i++)
			sb.append(String.format("%s", blocks[i].displayCompact()));

		sb.append(String.format("\n\nTOTAL BLOCKS: %-5d TOTAL PLOTS: %-5d TOTAL PARKS: %-5d TOTAL COMMERCIAL COMPLEXES: %-5d\n", getBlockCount(), getTotalPlotCount(), getTotalParksCount(), getTotalCommercialMarketsCount()));

		return sb.toString();
	}

	public int getBlockCount(){
		return blocks.length;
	}

	public int getTotalPlotCount(){
		int count = 0; 
		for(int i = 0; i < blocks.length; i++)
			count+= blocks[i].getTotalPlotCount();
		
		return count;
	}

	public int getTotalParksCount(){
		int count = 0; 
		for(int i = 0; i < blocks.length; i++)
			count+= blocks[i].getParkCount();
		
		return count;
	}

	public int getTotalCommercialMarketsCount(){
		int count = 0; 
		for(int i = 0; i < blocks.length; i++)
			count+= blocks[i].getCommercialMarketsCount();
		
		return count;
	}

	public double getTotalPlotPrice(){
		double totalPrice = 0;
		for(int i = 0; i < blocks.length; i++)
			totalPrice += blocks[i].getTotalPlotPrice();

		return totalPrice;
	}

	public double getAnnualRevenue(int year){
		double price = 0;
		for(int i = 0; i < blocks.length; i++)
			price += blocks[i].getAnnualRevenue(year);

		return price;
	}

	public double calTotalRevenue(){
		double price = 0;
		for(int i = 0; i < blocks.length; i++)
			price += blocks[i].calTotalRevenue();

		return price;
	}

	public String bookPlot(String blockName, String plotId, String ownerName){
		Block block = findBlockByName(blockName);

		if(block != null)
			return String.format("%s > %s", housingSocietyName, block.bookPlot(plotId, ownerName));
					
		else	
			return String.format("FAILED! %s > Block Name %s is incorrect.", housingSocietyName, blockName);
	}

	public String bookPlot(String blockName, int streetNo, int plotNo, String ownerName){
		int index = findBlockIndexByName(blockName);

		if(checkBounds(index)){
			//Plot indices
			return String.format("%s > %s", housingSocietyName, blocks[index].bookPlot(streetNo, plotNo, ownerName));
		}
		else
			return String.format("FAILED! %s > Block Name %s is incorrect.", housingSocietyName, blockName);
	}


	public String cancelPlot(String blockName, String plotId){
		Block block = findBlockByName(blockName);

		if(block != null)
			return String.format("%s > %s", housingSocietyName, block.cancelPlot(plotId));
					
		else	
			return String.format("FAILED! %s > Block Name %s is incorrect.", housingSocietyName, blockName);
	}

	public String cancelPlot(String blockName, int streetNo, int plotNo){
		int index = findBlockIndexByName(blockName);

		if(checkBounds(index)){
			//Plot indices
			return String.format("%s > %s", housingSocietyName, blocks[index].cancelPlot(streetNo, plotNo));
		}
		else
			return String.format("FAILED! %s > Block Name %s is incorrect.", housingSocietyName, blockName);
	}

	public Block findBlockByName(String blockName){
		Block block = new Block();

		for(int i = 0; i < blocks.length; i++){
			if(blockName.equals(blocks[i].getBlockName())){
				block = blocks[i];
				break;
			
			}
		}
		return block;
	}
	public int findBlockIndexByName(String blockName){
		int index = -1;

		for(int i = 0; i < blocks.length; i++){
			if(blockName.equals(blocks[i].getBlockName())){
				index = i;
				break;
			}
		}
		return index;
	}

	public boolean checkBounds(int i){
		if(i >= 0 && i < blocks.length)
			return true;
		else
			return false;
	}

	public String getHousingSocietyName(){
		return housingSocietyName;
	}

	public Block[] getBlocks(){
		return blocks;
	}

	public Plot[] listBooked(){
		Plot[] bookedPlots;
		int bookedCount = 0;
		
		for(int i = 0; i < blocks.length; i++)
			bookedCount += (blocks[i].listBooked()).length;
		
		bookedPlots = new Plot[bookedCount];
		Plot temp[] = new Plot[blocks.length];
		int counter = 0;
		
		for(int i = 0; i < blocks.length; i++){
			//Array is stored at each index
			temp = blocks[i].listBooked();
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
		
		for(int i = 0; i < blocks.length; i++)
			availableCount += (blocks[i].listAvailable()).length;
		
		availablePlots = new Plot[availableCount];
		Plot temp[] = new Plot[blocks.length];
		int counter = 0;
		
		for(int i = 0; i < blocks.length; i++){
			//Array is stored at each index
			temp = blocks[i].listAvailable();

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
		
		for(int i =0; i < blocks.length; i++)
			cornerCount += (blocks[i].listCornerPlots()).length;

		cornerPlots = new CornerPlot[cornerCount];
		int counter = 0;
		CornerPlot temp[] = new CornerPlot[blocks.length];

		for(int i =0; i < blocks.length; i++){
			//Array is stored at each index
			temp = blocks[i].listCornerPlots();

			for(int j = 0; j < temp.length;j++)
				cornerPlots[counter++] = temp[j];
		}

		return cornerPlots;
	}

	public String getReport(){
		StringBuilder sb= new StringBuilder();
		String s = "--------------------------------------------";

		sb.append(String.format("=== REPORT of %s ====\n- Number of Blocks: %d \n- Total Plots: %s\n- Amenities \n    ~ Total Parks Count: %s \n    ~ Total Commercial Market Count: %s\n%s", housingSocietyName, noOfBlocks,getTotalPlotCount(),getTotalParksCount(),getTotalCommercialMarketsCount(), s));

		for(int i = 0; i < blocks.length; i++){
			sb.append(String.format("\n%s", blocks[i].getReport()));
		}	
	
		return sb.toString();
	}

	public Plot[] unionOfArrays(){

		Plot[] array1 = this.listBooked();
		Plot[] array2 = this.listCornerPlots();

		//Temporary array
		Plot[] temp = new Plot[array1.length + array2.length];
		int count = 0;

		//Add all elements from array1
		for (int i = 0; i < array1.length; i++)
			temp[count++] = array1[i];
    
		//Skip the common elements
    		for(int i = 0; i < array2.length; i++){
        		boolean exists = false;
        		for(int j = 0; j < array1.length; j++){
				if(array2[i].getPlotId().equals(array1[j].getPlotId())){
					exists = true;
					break;
				}
        		}

			if(!(exists)){
				temp[count++] = array2[i];
			}
		}

		//Final array
		Plot[] unionArray = new Plot[count];
		for(int i = 0; i < count; i++){
			unionArray[i] = temp[i];
		}

		return unionArray;
	}

	public Plot[] intersectionOfArrays(){

		Plot[] array1 = this.listBooked();
		Plot[] array2 = this.listCornerPlots();

		Plot temp[] = new Plot[array1.length + array2.length]; 
		int count = 0;



		for(int i = 0; i < array1.length; i++){
			for(int j = 0; j < array2.length; j++){
				if(array1[i].getPlotId().equals(array2[j].getPlotId())){
					temp[count++] = array1[i];
					break;
				}
			}
		}


		Plot commonElements[] = new Plot[count];
 
		for(int i = 0; i < commonElements.length; i++) 
			commonElements[i] = temp[i];

		return commonElements;
	}




}