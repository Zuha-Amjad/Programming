package sp25_bcs;

public class CommercialMarket{
	private Shop shops[];
	private String marketName;

	public CommercialMarket(String marketName){
		this.marketName = marketName;

		shops = new Shop[10];

		for(int i =0; i< shops.length; i++)
			shops[i] = new Shop((i+1), Shape.RECTANGLE, PlotType.COMM_SHOP, "Shop_" + (i+1));
		
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("==== %s ==== \n", marketName));

		for(int i = 0; i< shops.length; i++)
			sb.append(String.format("%s \n", shops[i].toString()));

		return sb.toString();
	}

	public int getShopCount(){
		return shops.length;
	}

}