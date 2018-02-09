package cellTypes;

import javafx.scene.shape.Polygon;

public class Triangle extends Polygon {
	
	double x;
	double y;
	double side;
	
	Triangle(double x, double y, double side){
		this.x = x;
		this.y = y;
		this.side = side;
		setLayoutX(x);
		setLayoutY(y);
	}	
	
}
