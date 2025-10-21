package sp25_bcs;

public class PlotDemo{

	public static void main(String args[]){

		System.out.println(Init.bookPlot("Lahore","LDA AVENUE 1", "Block A", "1-001", "Mouhid Amjad"));
		System.out.println(Init.cancelPlot("Lahore","LDA AVENUE 1", "Block A", "2-001"));
		System.out.println(Init.bookPlot("Lahore","LDA AVENUE 1", "Block A", 1, 3, "Fizza"));
		System.out.println(Init.bookPlot("Lahore","LDA AVENUE 1", "Block A", 1, 2, "Amjad"));
		System.out.println(Init.bookPlot("Lahore","LDA AVENUE 1", "Block A", "2-003", "Zuha"));
		System.out.println(Init.bookPlot("Lahore","LDA AVENUE 1", "Block A", "2-007", "Abdullah"));
		System.out.println(Init.bookPlot("Lahore","LDA AVENUE 1", "Block A", 2, 9, "IRFA MEHMOOD"));
		System.out.println(Init.bookPlot("Lahore","LDA AVENUE 1", "Block A", "2-001", "Nabila"));
		System.out.println(Init.cancelPlot("Lahore","LDA AVENUE 1", "Block A", "2-001"));
		System.out.println(Init.bookPlot("Lahore","LDA AVENUE 2", "Block C", "5-014", "ZUHA AMJAD"));


		System.out.println(Init.getData());
		Plot plots[] = Init.listBooked();
       		
		System.out.println("==== Booked Plots =====");

    		for(int i =0; i < plots.length; i++){
			System.out.print(plots[i].getAddress());
       			System.out.println(plots[i].displayCompact() + "  ");
    		}

		System.out.println("\nAnnual Revenue of 2025: PKR " + Init.getAnnualRevenue(2025));
		System.out.println("Total Revenue: PKR " + Init.calTotalRevenue() + "\n");


		Plot plot[] = Init.listAvailable();
		System.out.println("==== Available Plots =====");

		String[] printedCities = new String[10];
		int count = 0;
		
		for(int i = 0; i < plot.length; i++){
			String currentCity = plot[i].getAddress().getCityName();
			boolean alreadyPrinted = false;
			
			//Check if the city was printed before
			for(int k = 0; k < count; k++)
 				if(printedCities[k].equals(currentCity)){
            				alreadyPrinted = true;
           				break;
				}

    			if(!alreadyPrinted){
        			printedCities[count++] = currentCity;

				System.out.println("==== Plots in " + currentCity + " =====");

				//Print all plots of the city
				for(int j = 0; j < plot.length; j++)
					if(plot[j].getAddress().getCityName().equals(currentCity))
						System.out.println(plot[j].displayCompact());
			}	
		}

		//System.out.println(Init.findCityHousingByName("Lahore").getReport());

		System.out.println(Init.generalReport());

		CornerPlot[] c = Init.listCornerPlots();
		System.out.println("==== Corner Plots =====");

    		for(int i =0; i < c.length; i++){
			System.out.print(c[i].getAddress());
       			System.out.println(c[i].displayCompact() + "  ");
    		}

		Plot []pp = Init.unionOfArrays();

		for(int i =0; i <pp.length; i++){
			System.out.println(pp[i]);
    		}

		pp = Init.intersectionOfArrays();

		System.out.println("INTERSECTION");
		for(int i =0; i <pp.length; i++){
			System.out.println(pp[i]);
    		}

	}

}