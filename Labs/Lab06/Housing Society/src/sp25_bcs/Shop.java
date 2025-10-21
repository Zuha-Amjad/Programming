package sp25_bcs;


public class Shop extends Plot{
	private String shopName;

	public Shop(int plotNo, Shape shape, PlotType plotType, String shopName){
		super(plotNo, shape, plotType);
		setShopName(shopName);
	
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(String.format("%-10s", shopName));

		return sb.toString(); 
	}


	public void setShopName(String shopName){
		this.shopName = shopName;
	}

	public String getShopName(){
		return shopName;
	}
	
	public int getShopNo(){
		return getPlotNo();
	}





}