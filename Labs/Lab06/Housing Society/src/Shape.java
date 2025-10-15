public enum Shape{	
	RECTANGLE(10, 5), TRAPEZOID (12, 5, 10), L_SHAPE (10, 5, 5, 3);

	private double width;
	private double depth;
	private double front;
	private double back;
	private double width2;
	private double depth2;


	//Constructor Overloading
	Shape(double width, double depth){
		this.width = width;
		this.depth =depth;
	}

	Shape(double front,double back, double depth){
		this.front = front;
		this.back = back;
		this.depth =depth;
	}

	Shape(double width, double depth, double width1, double depth2){
		this.width = width;
		this.depth =depth;
		this.width2 = width2;
		this.depth2 =depth2;
	}


	public double calArea(Shape shape){
		double area = 0;
		
		if(shape == Shape.RECTANGLE)
			area = this.width * this.depth;

		else if(shape == Shape.TRAPEZOID)
			area = ((front + back) / 2) * depth;

		else
			area = (width * depth) + (width2 * depth2);

		return area; 
	}


}