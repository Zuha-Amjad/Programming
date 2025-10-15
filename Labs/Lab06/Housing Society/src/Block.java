public class Block{

	private Plot plots[][];
		
	public Block(){
		plots = new Plot[5][];

		int counter = 5;

		for(int i = 0; i < plots.length; i++){
			plots[i] = new Plot[counter++];
			for(int j = 0; j < plots[i].length; j++){
				plots[i][j] = new Plot((i+1), (j+1), Shape.RECTANGLE, PlotType.RES_5_MARLA);
			}

		}
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();

		sb.append(" ");

		return sb.toString();
	}

}