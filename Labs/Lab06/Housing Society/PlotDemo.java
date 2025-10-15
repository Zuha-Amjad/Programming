public class PlotDemo{

	public static void main(String args[]){
		Plot p1 = new Plot(1, 875, Shape.RECTANGLE, PlotType.RES_5_MARLA);
		System.out.println(p1);
		System.out.println(p1.calArea() + " m^2");

		CornerPlot c1 = new CornerPlot(23, 55, Shape.RECTANGLE, PlotType.RES_10_MARLA, 3, 3);
		System.out.println(c1.calArea() + " m^2");
		System.out.println(c1);

		Plot [] plots = new Plot[5];
		for(int i =0; i < plots.length ; i++){
			plots[i] = new Plot(i, (i+10), Shape.RECTANGLE, PlotType.RES_5_MARLA);
		}

		for(int i =0; i < plots.length ; i++){
			System.out.println(plots[i]);
		}
		
	}

}